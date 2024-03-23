package br.com.fiap.gerente_usuarios.repositorio;

import br.com.fiap.gerente_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);

}
