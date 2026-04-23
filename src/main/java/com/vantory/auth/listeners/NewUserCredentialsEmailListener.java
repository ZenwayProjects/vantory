package com.vantory.auth.listeners;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.vantory.auth.events.NewUserCredentialsEvent;
import com.vantory.email.services.EmailVerificationService;
import com.vantory.usuariorol.UsuarioRol;
import com.vantory.usuariorol.repositories.UsuarioRolRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewUserCredentialsEmailListener {

	private final UsuarioRolRepository usuarioRolRepository;
	private final EmailVerificationService emailService;

	@Async
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void onNewUserCredentialsCreated(NewUserCredentialsEvent event) {

		UsuarioRol ur = usuarioRolRepository.findForEmailById(event.usuarioRolId())
				.orElseThrow(() -> new IllegalStateException(
						"No se encontró UsuarioRol para enviar credenciales. id=" + event.usuarioRolId()));

		var user = ur.getUser();
		var persona = user.getPersona();

		emailService.sendNewUserCredentialsEmail(user.getUsername(), persona != null ? persona.getNombre() : null,
				persona != null ? persona.getApellido() : null, ur.getEmpresa().getNombre(), ur.getRol().getNombre(),
				event.tempPassword());
	}
}
