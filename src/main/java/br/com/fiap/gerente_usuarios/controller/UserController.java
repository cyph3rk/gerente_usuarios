package br.com.fiap.gerente_usuarios.controller;

import br.com.fiap.gerente_usuarios.model.Usuario;
import br.com.fiap.gerente_usuarios.repositorio.IUsuarioRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final IUsuarioRepositorio repository;
    private final IUsuarioRepositorio userRepository;

    @Autowired
    public UserController(IUsuarioRepositorio repository, IUsuarioRepositorio userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

     @GetMapping
    public ResponseEntity<Object> getAllUsers(){

         logger.info("GET - ResponseEntity getAllUsers");

         List<Usuario> users = this.repository.findAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/filter/{login}")
    public UserDetails getJwtRequestFilter(@PathVariable String login) {
        logger.info("GET - getJwtRequestFilter");
        return userRepository.findByLogin(login);
    }

}
