package com.vantory.criterioEvaluacion.services;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vantory.criterioEvaluacion.dtos.CriterioEvaluacionDTO;
import com.vantory.criterioEvaluacion.mappers.CriterioEvaluacionMapper;
import com.vantory.criterioEvaluacion.repositirories.CriterioEvaluacionRepository;
import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.tipoEvaluacion.repositories.TipoEvaluacionRepository;
import com.vantory.utils.UserEmpresaService;

@Service
@RequiredArgsConstructor
public class CriterioEvaluacionService {

	private final UserEmpresaService userEmpresaService;

	private final CriterioEvaluacionRepository criterioEvaluacionRepository;

	private final CriterioEvaluacionMapper criterioEvaluacionMapper;

	private final TipoEvaluacionRepository tipoEvaluacionRepository;

	private final EstadoRepository estadoRepository;

	public Page<CriterioEvaluacionDTO> findAll(Pageable pageable) {
		Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
		return criterioEvaluacionRepository
			.findByEmpresaIdOrderByIdAsc(empresaId, pageable)
			.map(criterioEvaluacionMapper::toListDTO);
	}

	public Optional<CriterioEvaluacionDTO> findById(Long requestedId) {
		return criterioEvaluacionRepository
			.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(criterioEvaluacionMapper::toListDTO);
	}

	public CriterioEvaluacionDTO create(CriterioEvaluacionDTO criterioEvaluacionDTO) {
		tipoEvaluacionRepository.findById(criterioEvaluacionDTO.getTipoEvaluacionId())
			.orElseThrow(() -> new BadRequestException("El tipo de evaluación no es válido."));

		estadoRepository.findById(criterioEvaluacionDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido."));

		criterioEvaluacionDTO.setId(null);
		criterioEvaluacionDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		return criterioEvaluacionMapper
			.toDTO(criterioEvaluacionRepository.save(criterioEvaluacionMapper.toEntity(criterioEvaluacionDTO)));
	}

	public void update(Long requestedId, CriterioEvaluacionDTO criterioEvaluacionDTO) {
		criterioEvaluacionRepository
			.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("El criterio de evaluación no fue encontrado."));

		tipoEvaluacionRepository.findById(criterioEvaluacionDTO.getTipoEvaluacionId())
			.orElseThrow(() -> new BadRequestException("El tipo de evaluación no es válido."));

		estadoRepository.findById(criterioEvaluacionDTO.getEstadoId())
			.orElseThrow(() -> new BadRequestException("El estado no es válido."));

		criterioEvaluacionDTO.setId(requestedId);
		criterioEvaluacionDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		criterioEvaluacionRepository.save(criterioEvaluacionMapper.toEntity(criterioEvaluacionDTO));
	}

	public void delete(Long id) {
		criterioEvaluacionRepository.findByIdAndEmpresaId(id, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("El criterio de evaluación no fue encontrado."));

		criterioEvaluacionRepository.deleteById(id);
	}

}
