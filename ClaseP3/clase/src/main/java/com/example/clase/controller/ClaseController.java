package com.example.clase.controller;

import com.example.clase.dto.ClaseDTO;
import com.example.clase.entity.Clase;
import com.example.clase.service.ClaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clases", description = "API para gestión de clases del gimnasio")
@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    @Autowired
    private ClaseService service;

    @Operation(summary = "Crear clase", description = "Crea una nueva clase del gimnasio")
    @PostMapping
    public Clase crear(@RequestBody ClaseDTO dto){
        return service.crear(dto);
    }

    @Operation(summary = "Listar clases", description = "Obtiene todas las clases disponibles")
    @GetMapping
    public List<Clase> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar clase por ID")
    public Clase obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar clase por ID")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

}
