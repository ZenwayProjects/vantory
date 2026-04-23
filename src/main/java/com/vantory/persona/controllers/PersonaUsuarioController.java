package com.vantory.persona.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vantory.infrastructure.security.JwtService;
import com.vantory.persona.Persona;
import com.vantory.persona.dtos.PersonaDTO;
import com.vantory.persona.mappers.PersonaMapper;
import com.vantory.persona.repositories.PersonaRepository;
import com.vantory.user.User;
import com.vantory.user.repositories.UserRepository;
import com.vantory.usuarioEstado.UsuarioEstado;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaUsuarioController {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private UserRepository userRepository;

	// Suponiendo que tienes una instancia de JwtService
	@Autowired
	private JwtService jwtService;

	@PostMapping("/persona-usuario")
	public ResponseEntity<Map<String, Integer>> createPersona(@RequestBody PersonaDTO newPersonaRequest,
			@RequestHeader("Authorization") String authorizationHeader) {

		// Extraer el token de la cabecera Authorization
		String token = authorizationHeader.replace("Bearer ", "").trim();

		// Extraer el username desde el JWT usando la instancia de JwtService
		String username = jwtService.extractUsername(token);

		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		Persona persona = PersonaMapper.INSTANCE.toEntity(newPersonaRequest);
		persona = personaRepository.save(persona);

		user.setPersona(persona);
		user.setUsuarioEstado(UsuarioEstado.ACTIVADO_SIN_EMPRESA);

		userRepository.save(user);

		// Devolver solo el estado del usuario en la respuesta
		Map<String, Integer> response = new HashMap<>();
		response.put("usuarioEstado", user.getUsuarioEstado().getId().intValue());
		return ResponseEntity.ok(response);
	}

}
