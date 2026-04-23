package com.vantory.auth.events;

public record NewUserCredentialsEvent(Long usuarioRolId, String tempPassword) {

}
