package br.com.fiap.gerente_usuarios.repositorio;

import br.com.fiap.gerente_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, String> {
    UserDetails findByLogin(String login);

}
