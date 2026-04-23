package com.vantory.fase.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.fase.dtos.FaseDTO;
import com.vantory.fase.mappers.FaseMapper;
import com.vantory.fase.repositories.FaseRepository;
import com.vantory.utils.UserEmpresaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FaseService {
    private final FaseRepository faseRepository;
    private final FaseMapper faseMapper;
    private final EstadoRepository estadoRepository;
    private final UserEmpresaService userEmpresaService;


    public List<FaseDTO> findAll() {
        return faseRepository.findByEmpresaIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest())
                .stream()
                .map(faseMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<FaseDTO> findById(Long requestedId) {
        return faseRepository
                .findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
                .map(faseMapper::toDto);
                
    }

    @Transactional
    public FaseDTO create (FaseDTO faseDTO) {
        estadoRepository.findById(faseDTO.getEstadoId())
                .orElseThrow(() -> new BadRequestException("El estado no es válido"));

                faseDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

                return faseMapper.toDto(faseRepository.save(faseMapper.toEntity(faseDTO)));
    }

    @Transactional
    public void update(Long requestedId, FaseDTO faseDTO) {
        faseRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
                .orElseThrow(() -> new NotFoundException("Fase no encontrada o no válida."));
            
        estadoRepository.findById(faseDTO.getEstadoId())
                .orElseThrow(() -> new BadRequestException("El estado no es válido."));

        faseDTO.setId(requestedId);
        faseDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

        faseRepository.save(faseMapper.toEntity(faseDTO));
    }

    @Transactional
    public void delete (Long requestId) {
        faseRepository.findByIdAndEmpresaId(requestId, userEmpresaService.getEmpresaIdFromCurrentRequest())
                .orElseThrow(() -> new NotFoundException("Fase no encontrada o no válida"));
                faseRepository.deleteById((requestId));
    }


    
}
