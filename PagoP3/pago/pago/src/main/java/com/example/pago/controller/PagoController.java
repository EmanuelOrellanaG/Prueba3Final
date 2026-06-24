package com.example.pago.controller;
import com.example.pago.dto.PagoDTO;
import com.example.pago.entity.Pago;
import com.example.pago.service.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Pagos", description = "Gestión de pagos del gimnasio")
@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @Operation(summary = "Crear pago")
    @PostMapping
    public Pago crear(@RequestBody PagoDTO dto) {
        return service.crear(dto);
    }

    @Operation(summary = "Listar todos los pagos")
    @GetMapping
    public List<Pago> listar() {
        return service.listar();
    }

    @Operation(summary = "Obtener pago por ID")
    @GetMapping("/{id}")
    public Pago obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @Operation(summary = "Actualizar pago")
    @PutMapping("/{id}")
    public Pago actualizar(@PathVariable Long id, @RequestBody PagoDTO dto) {
        return service.actualizar(id, dto);
    }

    @Operation(summary = "Eliminar pago")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}