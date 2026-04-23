package com.vantory.ordenCompra.services;

import com.vantory.articuloKardex.ArticuloKardex;
import com.vantory.articuloKardex.repositories.ArticuloKardexRepository;
import com.vantory.articuloOrdenCompra.ArticuloOrdenCompra;
import com.vantory.articuloOrdenCompra.repositories.ArticuloOrdenCompraRepository;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.kardex.Kardex;
import com.vantory.ordenCompra.OrdenCompra;
import com.vantory.ordenCompra.constantes.OrdenCompraConstantes;
import com.vantory.ordenCompra.constantes.PedidoConstantes;
import com.vantory.ordenCompra.dtos.OrdenCompraCreateDTO;
import com.vantory.pedido.Pedido;
import com.vantory.pedido.repositories.PedidoRepository;
import com.vantory.proveedor.Proveedor;
import com.vantory.validator.EntidadValidatorFacade;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.ordenCompra.dtos.OrdenCompraDTO;
import com.vantory.ordenCompra.mappers.OrdenCompraMapper;
import com.vantory.ordenCompra.repositories.OrdenCompraRepository;
import com.vantory.utils.UserEmpresaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrdenCompraService {

	private final OrdenCompraRepository ordenCompraRepository;
	private final PedidoRepository pedidoRepository;
	private final OrdenCompraMapper ordenCompraMapper;
	private final UserEmpresaService userEmpresaService;
	private final EntidadValidatorFacade entidadValidatorFacade;
	private final ArticuloOrdenCompraRepository articuloOrdenCompraRepository;
	private final ArticuloKardexRepository articuloKardexRepository;
	private final OrdenCompraEstadoCalculator ordenCompraEstadoCalculator;

	public Page<OrdenCompraDTO> findAll(Pageable pageable) {
		return ordenCompraRepository
			.findByEmpresaIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest(), pageable)
			.map(ordenCompraMapper::toDTO);
	}

	public OrdenCompraDTO findById(Long requestedId) {
		return ordenCompraRepository
			.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(ordenCompraMapper::toDTO)
			.orElseThrow(() -> new NotFoundException("orden-compra.not-found", requestedId));
	}

	@Transactional
	public OrdenCompraDTO create(OrdenCompraCreateDTO ordenCompraDTO) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		ordenCompraDTO.setEmpresaId(empresaId);

		Pedido pedido = entidadValidatorFacade.validarPedido(ordenCompraDTO.getPedidoId(), empresaId);
		Proveedor proveedor = entidadValidatorFacade.validarProveedor(ordenCompraDTO.getProveedorId(), empresaId);
		Estado estadoInicial = entidadValidatorFacade.validarEstadoParaOrdenCompra(OrdenCompraConstantes.ESTADO_ORDEN_COMPRA_INICIAL_ACTIVO);

		OrdenCompra ordenCompra = ordenCompraMapper.toEntity(ordenCompraDTO);

		ordenCompra.setEmpresa(Empresa.builder().id(empresaId).build());
		ordenCompra.setPedido(pedido);
		ordenCompra.setProveedor(proveedor);
		ordenCompra.setEstado(estadoInicial);

		OrdenCompra guardado = ordenCompraRepository.save(ordenCompra);

		return ordenCompraMapper.toDTO(guardado);

	}

	@Transactional
	public void update(Long requestedId, OrdenCompraDTO ordenCompraDTO) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		OrdenCompra ordenCompra = entidadValidatorFacade.validarOrdenCompra(requestedId, empresaId);
		Pedido pedido = entidadValidatorFacade.validarPedido(ordenCompraDTO.getPedidoId(), empresaId);
		Proveedor proveedor = entidadValidatorFacade.validarProveedor(ordenCompraDTO.getProveedorId(), empresaId);
		Estado estado = entidadValidatorFacade.validarEstadoParaOrdenCompra(ordenCompraDTO.getEstadoId());

		ordenCompra.setDescripcion(ordenCompraDTO.getDescripcion());
		ordenCompra.setFechaHora(ordenCompraDTO.getFechaHora());
		ordenCompra.setPedido(pedido);
		ordenCompra.setProveedor(proveedor);
		ordenCompra.setEstado(estado);
		ordenCompraRepository.save(ordenCompra);
	}

	@Transactional
	public void delete(Long requestedId) {
		Long empresaId =  userEmpresaService.getEmpresaIdFromCurrentRequest();
		entidadValidatorFacade.validarOrdenCompra(requestedId, empresaId);

		ordenCompraRepository.deleteById(requestedId);
	}

	@Transactional
	public void enviarOrdenCompraAlProveedor(Long ordenCompraId){
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		OrdenCompra ordenCompra = entidadValidatorFacade.validarOrdenCompra(ordenCompraId, empresaId);
		Estado nuevoEstadoOrdenCompra = entidadValidatorFacade.validarEstadoParaOrdenCompra(OrdenCompraConstantes.ESTADO_ORDEN_COMPRA_ENTREGADO_AL_PROVEEDOR);
		if(!ordenCompra.getEstado().getId().equals(OrdenCompraConstantes.ESTADO_ORDEN_COMPRA_INICIAL_ACTIVO)){
			throw new BadRequestException("Solo las ordenes de compra con estado activo pueden enviarse al proveedor");
		}

		ordenCompra.setEstado(nuevoEstadoOrdenCompra);
		Pedido pedido = ordenCompra.getPedido();
		Estado nuevoEstadoPedido = entidadValidatorFacade.validarEstadoParaPedido(PedidoConstantes.ESTADO_CON_ORDEN_COMPRA);
		pedido.setEstado(nuevoEstadoPedido);
		pedidoRepository.save(pedido);

	}

	@Transactional
	public void validarEstadoDeEntrega(Long ordenCompraId, Long empresaId){
		if (ordenCompraId == null) {
			log.info("⏭️ Kardex sin orden de compra asociada, no se valida estado de entrega.");
			return;
		}
		OrdenCompra ordenCompra = entidadValidatorFacade.validarOrdenCompra(ordenCompraId, empresaId);
		Kardex kardex = entidadValidatorFacade.validarKardexPorOrdenCompra(ordenCompraId, empresaId);
		List<ArticuloOrdenCompra> articulosOC = articuloOrdenCompraRepository.findByEmpresaIdAndOrdenCompraIdOrderByIdAsc(empresaId, ordenCompraId);
		List<ArticuloKardex> articulosKardex = articuloKardexRepository.findByEmpresaIdAndKardexIdOrderByIdAsc(empresaId, kardex.getId());

		Estado nuevoEstado = ordenCompraEstadoCalculator.calcularNuevoEstado(articulosOC, articulosKardex);

		if (nuevoEstado != null && !ordenCompra.getEstado().equals(nuevoEstado)) {
			ordenCompra.setEstado(nuevoEstado);
			ordenCompraRepository.save(ordenCompra);
			log.info("✅ Estado de OC actualizado a {}", nuevoEstado.getId());
		}



	}

}
