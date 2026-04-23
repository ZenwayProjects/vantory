package com.vantory.departamento.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.vantory.departamento.dtos.DepartamentoDTO;
import com.vantory.departamento.mappers.DepartamentoMapper;
import com.vantory.departamento.repositories.DepartamentoRepository;
import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.pais.repositories.PaisRepository;
import com.vantory.utils.UserEmpresaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

	private final DepartamentoMapper departamentoMapper;

	private final DepartamentoRepository departamentoRepository;

	private final PaisRepository paisRepository;

	private final UserEmpresaService userEmpresaService;

	private final EstadoRepository estadoRepository;

	public List<DepartamentoDTO> findAll() {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

		return departamentoRepository.findByEmpresaIdOrderByIdAsc(empresaId)
				.stream()
			.map(departamentoMapper::toListDto)
				.collect(Collectors.toList());
	}

	public Optional<DepartamentoDTO> findById(Long requestedId) {
		return departamentoRepository
			.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(departamentoMapper::toListDto);
	}

	public DepartamentoDTO create(DepartamentoDTO departamentoDTO) {
		paisRepository
			.findByIdAndEmpresaId(departamentoDTO.getPaisId(), userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new BadRequestException("El pa�s no es v�lido para la empresa del usuario autenticado"));

		estadoRepository.findById(departamentoDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es v�lido"));

		departamentoDTO.setId(null);
		departamentoDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		return departamentoMapper.toDTO(departamentoRepository.save(departamentoMapper.toEntity(departamentoDTO)));
	}

	public void update(Long requestedId, DepartamentoDTO departamentoDTO) {
		departamentoRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Departamento no encontrado"));

		paisRepository
			.findByIdAndEmpresaId(departamentoDTO.getPaisId(), userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new BadRequestException("El pa�s no es v�lido para la empresa del usuario autenticado"));

		departamentoDTO.setId(requestedId);
		departamentoDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		departamentoRepository.save(departamentoMapper.toEntity(departamentoDTO));
	}

	public void delete(Long id) {
		departamentoRepository.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Departamento no encontrado"));

		departamentoRepository.deleteById(id);
	}

}