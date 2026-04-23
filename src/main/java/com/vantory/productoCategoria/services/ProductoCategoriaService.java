package com.vantory.productoCategoria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.productoCategoria.dtos.ProductoCategoriaDTO;
import com.vantory.productoCategoria.mappers.ProductoCategoriaMapper;
import com.vantory.productoCategoria.repositories.ProductoCategoriaRepository;
import com.vantory.utils.UserEmpresaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoCategoriaService {

	private final ProductoCategoriaMapper productoCategoriaMapper;

	private final ProductoCategoriaRepository productoCategoriaRepository;

	private final UserEmpresaService userEmpresaService;

	private final EstadoRepository estadoRepository;

	public List<ProductoCategoriaDTO> findAll() {
		return productoCategoriaRepository
			.findByEmpresaIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest())
			.stream()
			.map(productoCategoriaMapper::toListDto)
			.collect(Collectors.toList());
	}

	public ProductoCategoriaDTO create(ProductoCategoriaDTO productoCategoriaDTO) {
		estadoRepository.findById(productoCategoriaDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		productoCategoriaDTO.setId(null);
		productoCategoriaDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		return productoCategoriaMapper
			.toDTO(productoCategoriaRepository.save(productoCategoriaMapper.toEntity(productoCategoriaDTO)));
	}

	public void update(Long requestedId, ProductoCategoriaDTO productoCategoriaDTO) {
		productoCategoriaRepository
			.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Categoria de producto no encontrada"));

		estadoRepository.findById(productoCategoriaDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		productoCategoriaDTO.setId(requestedId);
		productoCategoriaDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		productoCategoriaRepository.save(productoCategoriaMapper.toEntity(productoCategoriaDTO));
	}

	public void delete(Long id) {
		productoCategoriaRepository.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Categoria de producto no encontrada"));

		productoCategoriaRepository.deleteById(id);
	}

}
