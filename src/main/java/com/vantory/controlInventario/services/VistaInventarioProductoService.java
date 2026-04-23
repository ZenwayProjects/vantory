package com.vantory.controlInventario.services;

import com.vantory.controlInventario.VistaInventarioProducto;
import com.vantory.controlInventario.repositories.VistaInventarioProductoRepository;
import com.vantory.utils.UserEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VistaInventarioProductoService {

	private final VistaInventarioProductoRepository vistaInventarioProductoRepository;

	private final UserEmpresaService userEmpresaService;

	public List<VistaInventarioProducto> findByProEmpresaId() {
		return vistaInventarioProductoRepository
			.findByProEmpresaId(userEmpresaService.getEmpresaIdFromCurrentRequest());
	}

}
