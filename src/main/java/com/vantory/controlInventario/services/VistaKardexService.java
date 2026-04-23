package com.vantory.controlInventario.services;

import com.vantory.controlInventario.VistaKardex;
import com.vantory.controlInventario.repositories.VistaKardexRepository;
import com.vantory.utils.UserEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VistaKardexService {

	private final VistaKardexRepository vistaKardexRepository;

	private final UserEmpresaService userEmpresaService;

	public List<VistaKardex> findByProEmpresaId() {
		return vistaKardexRepository.findByEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());
	}

}
