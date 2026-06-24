package com.example.membresia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "membresias")

public class Membresia {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private Long userId;

        @Column(nullable = false)
        private String nombre;

        private String descripcion;

        @Column(nullable = false)
        private Double precio;

        @Column(nullable = false)
        private Integer duracionDias;

        @Column(nullable = false)
        private Boolean activa;
    }

