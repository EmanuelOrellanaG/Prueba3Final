package com.example.rutina.client;

import com.example.rutina.dto.EjercicioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ejercicio-service", url = "http://localhost:8085")
public interface EjercicioClient {

    @GetMapping("/api/ejercicios/{id}")
    EjercicioDTO obtenerEjercicio(@PathVariable Long id);
}
