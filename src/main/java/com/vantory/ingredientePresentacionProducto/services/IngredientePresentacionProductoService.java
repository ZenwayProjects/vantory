package com.vantory.ingredientePresentacionProducto.services;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.ingrediente.Ingrediente;
import com.vantory.ingrediente.repositories.IngredienteRepository;
import com.vantory.ingredientePresentacionProducto.IngredientePresentacionProducto;
import com.vantory.ingredientePresentacionProducto.dtos.IngredientePresentacionProductoRequestDTO;
import com.vantory.ingredientePresentacionProducto.dtos.IngredientePresentacionProductoResponseDTO;
import com.vantory.ingredientePresentacionProducto.mappers.IngredientePresentacionProductoMapper;
import com.vantory.ingredientePresentacionProducto.repositories.IngredientePresentacionProductoRepository;
import com.vantory.presentacionProducto.PresentacionProducto;
import com.vantory.presentacionProducto.repositories.PresentacionProductoRepository;
import com.vantory.unidad.Unidad;
import com.vantory.unidad.repositories.UnidadRepository;
import com.vantory.utils.Constantes;
import com.vantory.utils.UserEmpresaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientePresentacionProductoService {

	private final IngredientePresentacionProductoRepository ingredientePresentacionProductoRepository;
	private final IngredienteRepository ingredienteRepository;
	private final PresentacionProductoRepository presentacionProductoRepository;
	private final UnidadRepository unidadRepository;
	private final EstadoRepository estadoRepository;
	private final UserEmpresaService userEmpresaService;
	private final IngredientePresentacionProductoMapper mapper;

	// -------------------------------------------------------------------------
	// LIST / GET
	// -------------------------------------------------------------------------

	@Transactional(readOnly = true)
	public Page<IngredientePresentacionProductoResponseDTO> list(Pageable pageable) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
		Page<IngredientePresentacionProducto> page = ingredientePresentacionProductoRepository
				.findByEmpresaId(empresaId, pageable);
		return mapper.toPage(page);
	}

	@Transactional(readOnly = true)
	public IngredientePresentacionProductoResponseDTO getById(Long id) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		IngredientePresentacionProducto entity = ingredientePresentacionProductoRepository
				.findByIdAndEmpresaId(id, empresaId)
				.orElseThrow(() -> new NotFoundException("ingrediente-presentacion-producto.not-found", id));

		return mapper.toDto(entity);
	}

	// -------------------------------------------------------------------------
	// CREATE
	// -------------------------------------------------------------------------

	@Transactional
	public IngredientePresentacionProductoResponseDTO create(IngredientePresentacionProductoRequestDTO dto) {

		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		// Validar/obtener ingrediente
		Ingrediente ingrediente = ingredienteRepository
				.findById(dto.ingredienteId())
				.orElseThrow(() -> new BadRequestException("ingrediente.not-valid"));

		// Validar/obtener presentación de producto
		PresentacionProducto presentacionProducto = presentacionProductoRepository
				.findById(dto.presentacionProductoId())
				.orElseThrow(() -> new BadRequestException("presentacion-producto.not-valid"));

		// Validar/obtener unidad
		Unidad unidad = unidadRepository
				.findById(dto.unidadId())
				.orElseThrow(() -> new BadRequestException("unidad.not-valid"));

		// Validar/obtener estado
		Estado estado = estadoRepository
				.findById(dto.estadoId())
				.orElseThrow(() -> new BadRequestException("estado.not-valid"));

		Empresa empresa = Empresa.builder().id(empresaId).build();

		IngredientePresentacionProducto entity = new IngredientePresentacionProducto();
		entity.setIngrediente(ingrediente);
		entity.setPresentacionProducto(presentacionProducto);
		entity.setUnidad(unidad);
		entity.setEstado(estado);
		entity.setEmpresa(empresa);

		if (dto.cantidad() != null) {
			entity.setCantidad(BigDecimal.valueOf(dto.cantidad().longValue()));
		}

		IngredientePresentacionProducto saved = ingredientePresentacionProductoRepository.save(entity);

		return mapper.toDto(saved);
	}

	// -------------------------------------------------------------------------
	// UPDATE
	// -------------------------------------------------------------------------

	@Transactional
	public void update(Long requestedId, IngredientePresentacionProductoRequestDTO dto) {

		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		IngredientePresentacionProducto entity = ingredientePresentacionProductoRepository
				.findByIdAndEmpresaId(requestedId, empresaId)
				.orElseThrow(() -> new NotFoundException("ingrediente-presentacion-producto.not-found", requestedId));

		// mismas validaciones de create
		Ingrediente ingrediente = ingredienteRepository
				.findById(dto.ingredienteId())
				.orElseThrow(() -> new BadRequestException("ingrediente.not-valid"));

		PresentacionProducto presentacionProducto = presentacionProductoRepository
				.findById(dto.presentacionProductoId())
				.orElseThrow(() -> new BadRequestException("presentacion-producto.not-valid"));

		Unidad unidad = unidadRepository
				.findById(dto.unidadId())
				.orElseThrow(() -> new BadRequestException("unidad.not-valid"));

		Estado estado = estadoRepository
				.findById(dto.estadoId())
				.orElseThrow(() -> new BadRequestException("estado.not-valid"));

		entity.setIngrediente(ingrediente);
		entity.setPresentacionProducto(presentacionProducto);
		entity.setUnidad(unidad);
		entity.setEstado(estado);

		if (dto.cantidad() != null) {
			entity.setCantidad(BigDecimal.valueOf(dto.cantidad().longValue()));
		} else {
			entity.setCantidad(null);
		}

		ingredientePresentacionProductoRepository.save(entity);
	}

	// -------------------------------------------------------------------------
	// DELETE (lógico) -> estado inactivo
	// -------------------------------------------------------------------------

	@Transactional
	public void delete(Long id) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		IngredientePresentacionProducto entity = ingredientePresentacionProductoRepository
				.findByIdAndEmpresaId(id, empresaId)
				.orElseThrow(() -> new NotFoundException("ingrediente-presentacion-producto.not-found", id));

		entity.setEstado(Estado.builder().id(Constantes.ESTADO_INACTIVO).build());

		ingredientePresentacionProductoRepository.save(entity);
	}
}
