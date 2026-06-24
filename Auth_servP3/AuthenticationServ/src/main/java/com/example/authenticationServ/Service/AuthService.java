package com.example.authenticationServ.Service;

import com.example.authenticationServ.Dto.AuthResponse;
import com.example.authenticationServ.Dto.LoginDTO;
import com.example.authenticationServ.Dto.RegisterDTO;
import com.example.authenticationServ.Entity.UsuarioAuth;
import com.example.authenticationServ.Repository.UsuarioAuthRepository;
import com.example.authenticationServ.Security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioAuthRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UsuarioAuthRepository repository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterDTO dto) {

        UsuarioAuth usuario = new UsuarioAuth();
        usuario.setUsername(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setRol("USER");

        repository.save(usuario);

        String token = jwtService.generateToken(usuario.getUsername(), usuario.getRol());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginDTO dto) {

        UsuarioAuth usuario = repository.findByUsername(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(usuario.getUsername(), usuario.getRol());

        return new AuthResponse(token);
    }

}
