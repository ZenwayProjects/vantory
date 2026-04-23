package com.vantory.pais.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.pais.dtos.PaisDTO;
import com.vantory.pais.mappers.PaisMapper;
import com.vantory.pais.repositories.PaisRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.utils.UserEmpresaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaisService {

	private final PaisMapper paisMapper;

	private final PaisRepository paisRepository;

	private final UserEmpresaService userEmpresaService;

	private final EstadoRepository estadoRepository;

	public List<PaisDTO> findAll() {
		return paisRepository.findByEmpresaIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest())
			.stream()
			.map(paisMapper::toListDto)
			.collect(Collectors.toList());
	}

	public Optional<PaisDTO> findById(Long requestedId) {
		return paisRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(paisMapper::toListDto);
	}

	public PaisDTO create(PaisDTO paisDTO) {
		estadoRepository.findById(paisDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		paisDTO.setId(null);
		paisDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		return paisMapper.toDTO(paisRepository.save(paisMapper.toEntity(paisDTO)));
	}

	public void update(Long requestedId, PaisDTO paisDTO) {
		paisRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Pais no encontrado"));

		estadoRepository.findById(paisDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido"));

		paisDTO.setId(requestedId);
		paisDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		paisRepository.save(paisMapper.toEntity(paisDTO));
	}

	public void delete(Long id) {
		paisRepository.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Pais no encontrado"));

		paisRepository.deleteById(id);
	}

}