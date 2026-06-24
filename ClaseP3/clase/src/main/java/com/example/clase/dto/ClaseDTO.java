package com.example.clase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaseDTO {

    private String nombre;
    private String descripcion;
    private String entrenador;
    private LocalDateTime horario;
    private Integer capacidadMaxima;
}
