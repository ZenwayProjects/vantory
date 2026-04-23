package com.vantory.grupo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.grupo.mappers.GrupoMapper;
import com.vantory.grupo.repositories.GrupoRepository;
import com.vantory.grupo.dtos.GrupoDTO;
import com.vantory.utils.UserEmpresaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrupoService {

	private final GrupoMapper grupoMapper;

	private final GrupoRepository grupoRepository;

	private final UserEmpresaService userEmpresaService;

	private final EstadoRepository estadoRepository;

	public List<GrupoDTO> findAll() {
		return grupoRepository.findByEmpresaIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest())
			.stream()
			.map(grupoMapper::toListDto)
			.collect(Collectors.toList());
	}

	public Optional<GrupoDTO> findById(Long requestedId) {
		return grupoRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(grupoMapper::toListDto);
	}

	public GrupoDTO create(GrupoDTO grupoDTO) {
		estadoRepository.findById(grupoDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		grupoDTO.setId(null);
		grupoDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		return grupoMapper.toDTO(grupoRepository.save(grupoMapper.toEntity(grupoDTO)));
	}

	public void update(Long requestedId, GrupoDTO grupoDTO) {
		grupoRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Grupo no encontrado"));

		estadoRepository.findById(grupoDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		grupoDTO.setId(requestedId);
		grupoDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		grupoRepository.save(grupoMapper.toEntity(grupoDTO));
	}

	public void delete(Long id) {
		grupoRepository.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Grupo no encontrado"));

		grupoRepository.deleteById(id);
	}

}
