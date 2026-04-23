package com.vantory.unidad.services;

import java.util.Optional;

import com.vantory.tipounidad.TipoUnidad;
import com.vantory.unidad.Unidad;
import com.vantory.validator.EntidadValidatorFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.unidad.dtos.UnidadDTO;
import com.vantory.unidad.mappers.UnidadMapper;
import com.vantory.unidad.repositories.UnidadRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UnidadService {

	private final UnidadRepository unidadRepository;

	private final UnidadMapper unidadMapper;
	private final EntidadValidatorFacade entidadValidatorFacade;
	private final EstadoRepository estadoRepository;

	public Page<UnidadDTO> findAll(Pageable pageable) {
		return unidadRepository.findAllByOrderById(pageable).map(unidadMapper::toDTO);
	}

	public Optional<UnidadDTO> findById(Long requestId) {
		return unidadRepository.findById(requestId)
			.map(unidadMapper::toDTO);
	}

	@Transactional
	public UnidadDTO create(UnidadDTO unidadDTO) {
		estadoRepository.findById(unidadDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es v�lido"));

		TipoUnidad tipoUnidad = entidadValidatorFacade.validarTipoUnidad(unidadDTO.getTipoUnidadId());
		Unidad guardado = unidadMapper.toEntity(unidadDTO);
		guardado.setTipoUnidad(tipoUnidad);
		return unidadMapper.toDTO(unidadRepository.save(guardado));
	}

	@Transactional
	public void update(Long requestId, UnidadDTO unidadDTO) {
		unidadRepository.findById(requestId)
			.orElseThrow(() -> new NotFoundException("Unidad no encontrada"));

		estadoRepository.findById(unidadDTO.getEstadoId())
			.orElseThrow(() -> new NotFoundException("Estado no encontrado"));

		unidadDTO.setId(requestId);
		unidadRepository.save(unidadMapper.toEntity(unidadDTO));
	}

	@Transactional
	public void delete(Long requestId) {
		unidadRepository.findById(requestId)
			.orElseThrow(() -> new NotFoundException("Unidad no encontrada"));

		unidadRepository.deleteById(requestId);
	}

}
