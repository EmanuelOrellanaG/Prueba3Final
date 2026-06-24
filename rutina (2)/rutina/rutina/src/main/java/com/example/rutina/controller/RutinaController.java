package com.example.rutina.controller;

import com.example.rutina.dto.RutinaDTO;
import com.example.rutina.entity.Rutina;
import com.example.rutina.service.RutinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rutinas", description = "Gestion de rutinas del gimnasio")
@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    private final RutinaService service;

    public RutinaController(RutinaService service){
        this.service = service;
    }

    @Operation(summary = "Crear rutina")
    @PostMapping
    public Rutina crear(@RequestBody RutinaDTO dto){
        return service.crear(dto);
    }

    @Operation(summary = "Listar rutinas")
    @GetMapping
    public List<Rutina> listar(){
        return service.listar();
    }

    @Operation(summary = "Obtener rutina por ID")
    @GetMapping("/{id}")
    public Rutina obtenerPorId(@PathVariable Long id){
        return service.obtener(id);
    }

    @Operation(summary = "Actualizar rutina")
    @PutMapping("/{id}")
    public Rutina actualizar(@PathVariable Long id, @RequestBody RutinaDTO dto){
        return service.actualizar(id,dto);
    }

    @Operation(summary = "Eliminar rutina")
    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        service.eliminar(id);
    }
}
