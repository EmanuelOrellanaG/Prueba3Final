package com.example.reserva.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class ClaseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String entrenador;
    private LocalDateTime horario;
    private Integer cuposDisponibles;
}