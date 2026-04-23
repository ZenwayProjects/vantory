package com.vantory.articuloKardex.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vantory.articuloKardex.ArticuloKardex;
import com.vantory.articuloKardex.dtos.ArticuloKardexDTO;
import com.vantory.articuloKardex.mappers.ArticuloKardexMapper;
import com.vantory.articuloKardex.repositories.ArticuloKardexRepository;
import com.vantory.articuloKardex.services.factory.ArticuloKardexFactory;
import com.vantory.estado.Estado;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.kardex.Kardex;
import com.vantory.ordenCompra.services.OrdenCompraService;
import com.vantory.presentacionProducto.PresentacionProducto;
import com.vantory.utils.UserEmpresaService;
import com.vantory.validator.EntidadValidatorFacade;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticuloKardexService {

	private final UserEmpresaService userEmpresaService;
	private final ArticuloKardexMapper articuloKardexMapper;
	private final ArticuloKardexRepository articuloKardexRepository;
	private final EntidadValidatorFacade entidadValidatorFacade;
	private final OrdenCompraService ordenCompraService;
	private final ArticuloKardexFactory articuloKardexFactory;

	public Page<ArticuloKardexDTO> findAll(Pageable pageable) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
		return articuloKardexRepository.findByEmpresaIdOrderByIdAsc(empresaId, pageable)
				.map(articuloKardexMapper::toListDTO);
	}

	public List<ArticuloKardexDTO> findAllByKardexId(Long kardexId) {
		return articuloKardexRepository
				.findByEmpresaIdAndKardexIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest(), kardexId)
				.stream().map(articuloKardexMapper::toListDTO).collect(Collectors.toList());
	}

	public Optional<ArticuloKardexDTO> findById(Long requestedId) {
		return articuloKardexRepository
				.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
				.map(articuloKardexMapper::toListDTO);
	}

	@Transactional
	public ArticuloKardexDTO create(ArticuloKardexDTO articuloKardexDTO, HttpServletRequest request) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		Kardex kardex = entidadValidatorFacade.validarKardex(articuloKardexDTO.getKardexId(), empresaId);
		entidadValidatorFacade.validarEstadoGeneral(articuloKardexDTO.getEstadoId());
		entidadValidatorFacade.validarProductoPresentacion(articuloKardexDTO.getPresentacionProductoId(), empresaId);

		List<ArticuloKardex> guardados = articuloKardexFactory.crearArticulos(articuloKardexDTO, empresaId, request);

		Long ordenCompraId = (kardex.getOrdenCompra() != null) ? kardex.getOrdenCompra().getId() : null;
		ordenCompraService.validarEstadoDeEntrega(ordenCompraId, empresaId);

		return articuloKardexMapper.toDTO(guardados.getLast());
	}

	@Transactional
	public void update(Long requestedId, ArticuloKardexDTO articuloKardexDTO) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		ArticuloKardex articuloKardexExistente = entidadValidatorFacade.validarArticuloKardex(requestedId, empresaId);

		Kardex kardex = entidadValidatorFacade.validarKardex(articuloKardexDTO.getKardexId(), empresaId);

		PresentacionProducto presentacion = entidadValidatorFacade
				.validarProductoPresentacion(articuloKardexDTO.getPresentacionProductoId(), empresaId);

		Estado estado = entidadValidatorFacade.validarEstadoGeneral(articuloKardexDTO.getEstadoId());

		articuloKardexExistente.setKardex(kardex);
		articuloKardexExistente.setPresentacionProducto(presentacion);
		articuloKardexExistente.setEstado(estado);

		articuloKardexRepository.save(articuloKardexExistente);
	}

	public void delete(Long id) {
		articuloKardexRepository.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
				.orElseThrow(() -> new NotFoundException("El artículo de kardex no fue encontrado."));

		articuloKardexRepository.deleteById(id);
	}

}
