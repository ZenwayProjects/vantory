package com.vantory.sector.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.sector.dtos.SectorDTO;
import com.vantory.sector.mappers.SectorMapper;
import com.vantory.sector.repositories.SectorRepository;
import com.vantory.utils.UserEmpresaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectorService {

    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;
    private final EstadoRepository estadoRepository;
    private final UserEmpresaService userEmpresaService;


    public List <SectorDTO> findAll() {
        return sectorRepository.findByEmpresaIdOrderByIdAsc(userEmpresaService.getEmpresaIdFromCurrentRequest())
                .stream()
                .map(sectorMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional <SectorDTO> findById(Long requestedId) {
        return sectorRepository
                .findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
                .map(sectorMapper::toDto);
    }

    @Transactional
    public SectorDTO create (SectorDTO sectorDTO) {
        estadoRepository.findById(sectorDTO.getEstadoId())
                .orElseThrow(() -> new BadRequestException("El estado no es válido."));
        sectorDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());
        return sectorMapper.toDto(sectorRepository.save(sectorMapper.toEntity(sectorDTO)));
    }


    @Transactional
    public void update(Long requestedId, SectorDTO sectorDTO) {
        sectorRepository.findByIdAndEmpresaId(requestedId, userEmpresaService.getEmpresaIdFromCurrentRequest())
                .orElseThrow(() -> new NotFoundException("El sector no se encuentra o no es válido."));

        estadoRepository.findById(sectorDTO.getEstadoId())
                .orElseThrow(() -> new BadRequestException("El estado no es válido."));

        sectorDTO.setId(requestedId);
        sectorDTO.setEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());

        sectorRepository.save(sectorMapper.toEntity(sectorDTO));
    }
    

    @Transactional
    public void delete(Long requestId) {
        sectorRepository.findByIdAndEmpresaId(requestId, userEmpresaService.getEmpresaIdFromCurrentRequest())
                .orElseThrow(() -> new BadRequestException("EL sector no se encuentra o no es válido."));
        sectorRepository.deleteById(requestId);
    }
}
