package com.vantory.kardex.services;

import com.vantory.almacen.Almacen;
import com.vantory.auditoria.AuthenticationService;
import com.vantory.auditoria.RequestUtils;
import com.vantory.empresa.Empresa;
import com.vantory.ordenCompra.OrdenCompra;
import com.vantory.validator.EntidadValidatorFacade;
import com.vantory.estado.Estado;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.kardex.Kardex;
import com.vantory.kardex.mappers.KardexMapper;
import com.vantory.kardex.repositories.KardexRepository;
import com.vantory.pedido.Pedido;
import com.vantory.kardex.dtos.KardexDTO;
import com.vantory.produccion.Produccion;
import com.vantory.tipoMovimiento.TipoMovimiento;
import com.vantory.utils.UserEmpresaService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KardexService {

	private final KardexRepository kardexRepository;
	private final KardexMapper kardexMapper;
	private final UserEmpresaService userEmpresaService;
	private final EntidadValidatorFacade entidadValidatorFacade;
    private final RequestUtils requestUtils;
    private final AuthenticationService authenticationService;
    private final HttpServletRequest request;

	public Page<KardexDTO> findAll(Pageable pageable) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
		return kardexRepository.findByEmpresaIdOrderByIdAsc(empresaId, pageable).map(kardexMapper::toDto);
	}

	public Optional<KardexDTO> findById(Long requestedId) {
		return kardexRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(kardexMapper::toDto);
	}

	@Transactional
	public KardexDTO create(KardexDTO kardexDTO) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		kardexDTO.setEmpresaId(empresaId);

		Kardex kardex = kardexMapper.toEntity(kardexDTO);

		aplicarValidacionesYRelaciones(kardexDTO, kardex, empresaId);
		Kardex guardado = kardexRepository.save(kardex);
		return kardexMapper.toDto(guardado);
	}

	@Transactional
	public KardexDTO update(Long requestedId, KardexDTO kardexDTO) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		Kardex kardexExistente = entidadValidatorFacade.validarKardex(requestedId, empresaId);
		kardexMapper.updateEntityFromDto(kardexDTO, kardexExistente);

		aplicarValidacionesYRelaciones(kardexDTO, kardexExistente, empresaId);

		Kardex guardado = kardexRepository.save(kardexExistente);
		return kardexMapper.toDto(guardado);
	}

	@Transactional
	public void delete(Long requestId) {
		kardexRepository.findByIdAndEmpresaId(requestId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Kardex no encontrado o no v�lido"));

		kardexRepository.deleteById(requestId);
	}

	private void aplicarValidacionesYRelaciones(KardexDTO kardexDTO, Kardex kardex, Long empresaId) {
		Estado estado = entidadValidatorFacade.validarEstadoGeneral(kardexDTO.getEstadoId());
		Almacen almacen = entidadValidatorFacade.validarAlmacen(kardexDTO.getAlmacenId(), empresaId);
		Produccion produccion = entidadValidatorFacade.validarProduccion(kardexDTO.getProduccionId(), empresaId);
		TipoMovimiento tipoMovimiento = entidadValidatorFacade.validarTipoMovimiento(kardexDTO.getTipoMovimientoId(),
				empresaId);
        Pedido pedido = null;
        if (kardexDTO.getPedidoId() != null) {
            pedido = entidadValidatorFacade.validarPedido(kardexDTO.getPedidoId(), empresaId);
        }

        OrdenCompra ordenCompra = null;
        if (kardexDTO.getOrdenCompraId() != null) {
            ordenCompra = entidadValidatorFacade.validarOrdenCompra(kardexDTO.getOrdenCompraId(), empresaId);
        }

        if (kardexDTO.getClienteProveedorId() != null) {
            Empresa clienteProveedor = entidadValidatorFacade
                    .validarClienteProveedor(kardexDTO.getClienteProveedorId());
            kardex.setClienteProveedor(clienteProveedor);
        }

		kardex.setEstado(estado);
		kardex.setAlmacen(almacen);
		kardex.setProduccion(produccion);
		kardex.setTipoMovimiento(tipoMovimiento);
		kardex.setPedido(pedido);
		kardex.setOrdenCompra(ordenCompra);

        asignarDatosAuditoria(kardex);

	}

    private void asignarDatosAuditoria(Kardex kardex) {

        kardex.setIp(requestUtils.getClientIp(request));
        kardex.setHost(requestUtils.getClientHost(request));

        kardex.setUsername(authenticationService
                .getAuthenticatedUser()
                .getUsername());

        kardex.setRol(requestUtils.getAuthenticatedRole());
    }

}
