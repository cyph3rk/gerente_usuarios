package br.com.fiap.gerente_usuarios.request;

import br.com.fiap.gerente_usuarios.model.UserRole;

public record UserRequest(String login, String password, UserRole role) {
}

