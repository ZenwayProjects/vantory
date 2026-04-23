package com.vantory.rol.services;

import java.util.List;

import com.vantory.rol.dtos.RolRequestDTO;
import com.vantory.rol.dtos.RolResponseDTO;

public interface RolService {

    RolResponseDTO create(RolRequestDTO request);

    RolResponseDTO update(Long id, RolRequestDTO request);

    RolResponseDTO getById(Long id);

    List<RolResponseDTO> getAll();

    void softDelete(Long id);

    void delete(Long id);

}
