package com.example.ejercicio.controller;

import com.example.ejercicio.dto.EjercicioDTO;
import com.example.ejercicio.entity.Ejercicio;
import com.example.ejercicio.service.EjercicioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ejercicios", description = "Gestión de ejercicios del gimnasio")
@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    private final EjercicioService service;

    public EjercicioController(EjercicioService service) {
        this.service = service;
    }

    @Operation(summary = "Crear ejercicio")
    @PostMapping
    public Ejercicio crear(@RequestBody EjercicioDTO dto) {
        return service.crear(dto);
    }

    @Operation(summary = "Listar ejercicios")
    @GetMapping
    public List<Ejercicio> listar() {
        return service.listar();
    }

    @Operation(summary = "Obtener ejercicio por ID")
    @GetMapping("/{id}")
    public Ejercicio obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @Operation(summary = "Actualizar ejercicio")
    @PutMapping("/{id}")
    public Ejercicio actualizar(@PathVariable Long id, @RequestBody EjercicioDTO dto) {
        return service.actualizar(id, dto);
    }

    @Operation(summary = "Eliminar ejercicio")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}