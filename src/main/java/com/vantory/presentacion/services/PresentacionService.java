package com.vantory.presentacion.services;

import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.presentacion.dtos.PresentacionDTO;
import com.vantory.presentacion.mappers.PresentacionMapper;
import com.vantory.presentacion.repositories.PresentacionRepository;
import com.vantory.utils.UserEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PresentacionService {

	private final PresentacionRepository presentacionRepository;

	private final PresentacionMapper presentacionMapper;

	private final UserEmpresaService userEmpresaService;

	private final EstadoRepository estadoRepository;

	public List<PresentacionDTO> findAll() {
		return presentacionRepository.findByEmpresaIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest())
			.stream()
			.map(presentacionMapper::toDTO)
			.collect(Collectors.toList());
	}

	public Optional<PresentacionDTO> findById(Long requestedId) {
		return presentacionRepository
			.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.map(presentacionMapper::toDTO);
	}

	@Transactional
	public PresentacionDTO create(PresentacionDTO presentacionDTO) {
		presentacionDTO.setId(null);
		presentacionDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		return presentacionMapper.toDTO(presentacionRepository.save(presentacionMapper.toEntity(presentacionDTO)));
	}

	@Transactional
	public void update(Long requestId, PresentacionDTO presentacionDTO) {
		presentacionRepository.findByIdAndEmpresaId(requestId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Presentacion no encontrada."));

		estadoRepository.findById(presentacionDTO.getEstadoId())
			.orElseThrow(() -> new NotFoundException("Estado no encontrado"));

		presentacionDTO.setId(requestId);
		presentacionDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

		presentacionRepository.save(presentacionMapper.toEntity(presentacionDTO));

	}

	@Transactional
	public void delete(Long requestId) {
		presentacionRepository.findByIdAndEmpresaId(requestId, userEmpresaService.getEmpresaIdFromCurrentRequest())
			.orElseThrow(() -> new NotFoundException("Presentacion no encontrada."));

		presentacionRepository.deleteById(requestId);

	}

}
