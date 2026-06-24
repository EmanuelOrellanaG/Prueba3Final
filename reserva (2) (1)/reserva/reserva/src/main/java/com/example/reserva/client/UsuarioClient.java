package com.example.reserva.client;

import com.example.reserva.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service", url = "http://localhost:8082")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO obtenerUsuario(@PathVariable Long id);

    @GetMapping("/api/usuarios/username/{username}")
    UsuarioDTO obtenerPorUsername(@PathVariable String username);
}
