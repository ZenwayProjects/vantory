package com.vantory.producto.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vantory.empresa.Empresa;
import com.vantory.empresa.repositories.EmpresaRepository;
import com.vantory.estado.Estado;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.producto.Producto;
import com.vantory.producto.dtos.ProductoRequestDTO;
import com.vantory.producto.dtos.ProductoResponseDTO;
import com.vantory.producto.mappers.ProductoMapper;
import com.vantory.producto.repositories.ProductoRepository;
import com.vantory.productoCategoria.ProductoCategoria;
import com.vantory.productoCategoria.repositories.ProductoCategoriaRepository;
import com.vantory.unidad.Unidad;
import com.vantory.unidad.repositories.UnidadRepository;
import com.vantory.utils.Constantes;
import com.vantory.utils.UserEmpresaService;
import com.vantory.validator.EntidadValidatorFacade;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

	private final ProductoRepository productoRepository;

	private final ProductoMapper productoMapper;

	private final UserEmpresaService userEmpresaService;

	private final EntidadValidatorFacade entidadValidatorFacade;

	private final EmpresaRepository empresaRepository;

	private final UnidadRepository unidadRepository;

	private final ProductoCategoriaRepository productoCategoriaRepository;

	public Page<ProductoResponseDTO> findAllByFilters(Pageable pageable, Long estadoId, Long categoriaId) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
		return productoRepository.findByFilters(empresaId, estadoId, categoriaId, pageable)
				.map(productoMapper::toDto);
	}

	public ProductoResponseDTO findById(Long requestedId) {
		return productoRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
				.map(productoMapper::toDto).orElseThrow(() -> new NotFoundException("producto.not-found", requestedId));
	}

	@Transactional
	public ProductoResponseDTO create(ProductoRequestDTO productoRequestDTO) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		ProductoCategoria productoCategoria = productoCategoriaRepository
				.findByIdAndEstadoIdAndEmpresaId(productoRequestDTO.productoCategoriaId(), Constantes.ESTADO_ACTIVO,
						empresaId)
				.orElseThrow(() -> new BadRequestException("producto-categoria.not-valid"));
		Estado estado = entidadValidatorFacade.validarEstadoGeneral(productoRequestDTO.estadoId());
		Empresa empresa = empresaRepository.findById(empresaId).orElseThrow();
		Unidad unidad = unidadRepository
				.findByIdAndEstadoId(productoRequestDTO.unidadMinimaId(), Constantes.ESTADO_ACTIVO)
				.orElseThrow(() -> new BadRequestException("unidad.not-valid"));

		Producto productoWithTenant = productoMapper.toEntity(productoRequestDTO);
		productoWithTenant.setProductoCategoria(productoCategoria);
		productoWithTenant.setEstado(estado);
		productoWithTenant.setEmpresa(empresa);
		productoWithTenant.setUnidadMinima(unidad);

		Producto saveProducto = productoRepository.save(productoWithTenant);

		return productoMapper.toDto(saveProducto);

	}

	@Transactional
	public void update(Long requestedId, ProductoRequestDTO productoRequestDTO) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		productoRepository.findByIdAndEmpresaId(requestedId, empresaId)
				.orElseThrow(() -> new NotFoundException("producto.not-found", requestedId));

		ProductoCategoria productoCategoria = productoCategoriaRepository
				.findByIdAndEstadoIdAndEmpresaId(productoRequestDTO.productoCategoriaId(), Constantes.ESTADO_ACTIVO,
						empresaId)
				.orElseThrow(() -> new BadRequestException("producto-categoria.not-valid"));
		Estado estado = entidadValidatorFacade.validarEstadoGeneral(productoRequestDTO.estadoId());
		Empresa empresa = empresaRepository.findById(empresaId).orElseThrow();
		Unidad unidad = unidadRepository
				.findByIdAndEstadoId(productoRequestDTO.unidadMinimaId(), Constantes.ESTADO_ACTIVO)
				.orElseThrow(() -> new BadRequestException("unidad.not-valid"));

		Producto productoWithTenant = productoMapper.toEntity(productoRequestDTO);
		productoWithTenant.setId(requestedId);
		productoWithTenant.setProductoCategoria(productoCategoria);
		productoWithTenant.setEstado(estado);
		productoWithTenant.setEmpresa(empresa);
		productoWithTenant.setUnidadMinima(unidad);

		productoRepository.save(productoWithTenant);
	}

	@Transactional
	public void delete(Long id) {
		Producto producto = productoRepository
				.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
				.orElseThrow(() -> new NotFoundException("producto.not-found", id));
		producto.setEstado(Estado.builder().id(Constantes.ESTADO_INACTIVO).build());
		productoRepository.save(producto);
	}

}
