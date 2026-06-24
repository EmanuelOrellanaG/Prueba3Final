package com.example.reserva.controller;

import com.example.reserva.dto.ReservaDTO;
import com.example.reserva.entity.Reserva;
import com.example.reserva.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Gestión de reservas de clases")
public class ReservaController {

    @Autowired
    private ReservaService service;


    @PostMapping
    @Operation(summary = "Crear reserva")
    public Reserva crearReserva(
            @RequestBody ReservaDTO dto,
            @RequestHeader("username") String username
    ) {
        return service.crear(dto, username);
    }


    @GetMapping
    @Operation(summary = "Listar reservas")
    public List<Reserva> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar reserva por ID")
    public Reserva buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar reserva")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
