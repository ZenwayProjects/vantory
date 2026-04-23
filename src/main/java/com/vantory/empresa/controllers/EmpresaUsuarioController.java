package com.vantory.empresa.controllers;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vantory.empresa.Empresa;
import com.vantory.empresa.dtos.EmpresaDTO;
import com.vantory.empresa.mappers.EmpresaMapper;
import com.vantory.empresa.services.EmpresaService;
import com.vantory.empresarol.EmpresaRol;
import com.vantory.empresarol.repositories.EmpresaRolRepository;
import com.vantory.estado.Estado;
import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.infrastructure.security.JwtService;
import com.vantory.modulo.Modulo;
import com.vantory.modulo.enums.AlcanceModulo;
import com.vantory.modulo.repositories.ModuloRepository;
import com.vantory.moduloempresa.ModuloEmpresa;
import com.vantory.moduloempresa.repositories.ModuloEmpresaRepository;
import com.vantory.permiso.Permiso;
import com.vantory.permiso.repositories.PermisoRepository;
import com.vantory.rol.Rol;
import com.vantory.rol.repositories.RolRepository;
import com.vantory.rolpermiso.RolPermiso;
import com.vantory.rolpermiso.repositories.RolPermisoRepository;
import com.vantory.user.User;
import com.vantory.user.repositories.UserRepository;
import com.vantory.usuarioEstado.UsuarioEstado;
import com.vantory.usuariorol.UsuarioRol;
import com.vantory.usuariorol.repositories.UsuarioRolRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/empresas")
@RequiredArgsConstructor
public class EmpresaUsuarioController {

	private final EmpresaService empresaService;

	private final JwtService jwtService;

	private final UserRepository userRepository;

	private final UsuarioRolRepository usuarioRolRepository;

	private final ModuloRepository moduloRepository;

	private final EstadoRepository estadoRepository;

	private final ModuloEmpresaRepository moduloEmpresaRepository;

	private final RolRepository rolRepository;

	private final EmpresaRolRepository empresaRolRepository;

	private final PermisoRepository permisoRepository;

	private final RolPermisoRepository rolPermisoRepository;

	@Transactional
	@PostMapping("/empresa-usuario")
	public ResponseEntity<Map<String, Integer>> createEmpresa(@RequestBody EmpresaDTO empresaDTO,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = authorizationHeader.replace("Bearer ", "").trim();
		String username = jwtService.extractUsername(token);

		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		Empresa empresa = EmpresaMapper.INSTANCE.toEmpresa(empresaDTO);
		empresa.setPersona(user.getPersona());

		// 1. Guardar la entidad Empresa
		Empresa savedEmpresa = empresaService.save(empresa);

		// ==========================================
		// INICIO DE INICIALIZACIÓN DE PERMISOS BASE
		// ==========================================

		// A. Habilitar módulos base para la empresa (modulo_empresa)
		List<Modulo> modulosBase = moduloRepository.findByAlcanceAndRequeridoTrue(AlcanceModulo.EMPRESA);
		Estado estadoActivo = estadoRepository.getReferenceById(1L);
		List<ModuloEmpresa> modulosEmpresa = modulosBase.stream().map(modulo -> {

			ModuloEmpresa me = new ModuloEmpresa();
			me.setModulo(modulo);
			me.setEmpresa(savedEmpresa);
			// Asegúrate de usar el objeto o ID correcto según tu entidad Estado
			me.setEstado(estadoActivo);
			return me;
		}).toList();
		moduloEmpresaRepository.saveAll(modulosEmpresa);

		// B. Crear el vínculo Empresa - Rol para el Rol 2 (empresa_rol)
		Rol rolAdmin = rolRepository.findById(2L)
			.orElseThrow(() -> new RuntimeException("Rol Administrador no encontrado"));

		EmpresaRol empresaRol = new EmpresaRol();
		empresaRol.setEmpresa(savedEmpresa);
		empresaRol.setRol(rolAdmin);
		empresaRol.setEstado(estadoActivo);
		EmpresaRol savedEmpresaRol = empresaRolRepository.save(empresaRol);

		// C. Asignar los permisos específicos al rol en esta empresa (rol_permiso)
		List<Long> modulosIds = modulosBase.stream().map(Modulo::getId).toList();

		if (!modulosIds.isEmpty()) {
			List<Permiso> permisosAdmin = permisoRepository.findByModuloIdInAndAdminEmpresaTrue(modulosIds);

			List<RolPermiso> rolPermisos = permisosAdmin.stream().map(permiso -> {
				RolPermiso rp = new RolPermiso();
				rp.setEmpresaRol(savedEmpresaRol);
				rp.setPermiso(permiso);
				rp.setEstado(estadoActivo);

				// ¡LA SOLUCIÓN! Asigna la fecha manualmente.
				// (Nota: Usa LocalDateTime.now(), LocalDate.now() o new Date()
				// dependiendo del tipo de dato que tengas en tu entidad RolPermiso)
				rp.setCreatedAt(Instant.now());

				return rp;
			}).toList();
			rolPermisoRepository.saveAll(rolPermisos);
		}

		// ==========================================
		// FIN DE INICIALIZACIÓN
		// ==========================================

		user.setUsuarioEstado(UsuarioEstado.ACTIVADO_CON_EMPRESA);
		userRepository.save(user);

		UsuarioRol usuarioRol = usuarioRolRepository.findByUser(user);
		usuarioRol.setEmpresa(savedEmpresa);
		usuarioRolRepository.save(usuarioRol);

		Map<String, Integer> response = new HashMap<>();
		response.put("usuarioEstado", user.getUsuarioEstado().getId().intValue());

		return ResponseEntity.ok(response);
	}

}
