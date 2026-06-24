package com.example.membresia.controller;

import com.example.membresia.dto.MembresiaDTO;
import com.example.membresia.entity.Membresia;
import com.example.membresia.service.MembresiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

        private final MembresiaService membresiaService;

        public MembresiaController(MembresiaService membresiaService) {
            this.membresiaService = membresiaService;
        }

        @PostMapping
        public Mono<Membresia> crear(@RequestBody MembresiaDTO dto) {
        return membresiaService.crear(dto);
    }

        @GetMapping
        public ResponseEntity<List<Membresia>> listar() {
            return ResponseEntity.ok(membresiaService.listar());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Membresia> obtenerPorId(@PathVariable Long id) {

            Membresia m = membresiaService.obtenerPorId(id);
            return (m!= null) ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
        }

        @PutMapping("/{id}")
        public Mono<Membresia> actualizar(@PathVariable Long id,
                                          @RequestBody MembresiaDTO dto) {
            return membresiaService.actualizar(id, dto);
        }

            @DeleteMapping("/{id}")
            public ResponseEntity <Void> eliminar(@PathVariable Long id) {
                membresiaService.eliminar(id);
                return ResponseEntity.noContent().build();
            }
    }

