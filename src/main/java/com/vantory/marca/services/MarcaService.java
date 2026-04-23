package com.vantory.marca.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.marca.dtos.MarcaDTO;
import com.vantory.marca.mappers.MarcaMapper;
import com.vantory.marca.repositories.MarcaRepository;
import com.vantory.utils.UserEmpresaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarcaService {

	private final MarcaRepository marcaRepository;

	private final MarcaMapper marcaMapper;

	private final EstadoRepository estadoRepository;

	private final UserEmpresaService userEmpresaService;

	public Page<MarcaDTO> findAll(Pageable pageable) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
		return marcaRepository.findByEmpresaIdOrderByIdAsc(empresaId, pageable)
			.map(marcaMapper::toListDto);
	}

	public Optional<MarcaDTO> findById(Long requestedId) {
		return marcaRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(marcaMapper::toListDto);
	}

	public MarcaDTO create(MarcaDTO marcaDTO) {
		estadoRepository.findById(marcaDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		marcaDTO.setId(null);
		marcaDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		return marcaMapper.toDTO(marcaRepository.save(marcaMapper.toEntity(marcaDTO)));
	}

	public void update(Long requestedId, MarcaDTO marcaDTO) {
		marcaRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Marca no encontrada"));

		estadoRepository.findById(marcaDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		marcaDTO.setId(requestedId);
		marcaDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		marcaRepository.save(marcaMapper.toEntity(marcaDTO));
	}

	public void delete(Long id) {
		marcaRepository.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Marca no encontrada"));

		marcaRepository.deleteById(id);
	}

}
