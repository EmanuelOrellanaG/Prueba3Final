package com.example.reserva.client;

import com.example.reserva.dto.ClaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "clase-service", url = "http://localhost:8087")
public interface ClaseClient {

    @GetMapping("/api/clases/{id}")
    ClaseDTO obtenerClase(@PathVariable Long id);

    @PutMapping("/api/clases/{id}/cupos")
    void actualizarCupos(@PathVariable Long id,
                         @RequestParam Integer nuevosCupos);
}
