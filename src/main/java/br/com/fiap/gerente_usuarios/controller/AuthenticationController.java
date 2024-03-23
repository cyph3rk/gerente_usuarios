package br.com.fiap.gerente_usuarios.controller;


import br.com.fiap.gerente_usuarios.model.Usuario;
import br.com.fiap.gerente_usuarios.repositorio.IUsuarioRepositorio;
import br.com.fiap.gerente_usuarios.request.UserAuthRequest;
import br.com.fiap.gerente_usuarios.request.UserRequest;
import br.com.fiap.gerente_usuarios.response.UserResponse;
import br.com.fiap.gerente_usuarios.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final IUsuarioRepositorio repository;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, IUsuarioRepositorio repository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserAuthRequest data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new UserResponse(token));
    }


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UserRequest data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
