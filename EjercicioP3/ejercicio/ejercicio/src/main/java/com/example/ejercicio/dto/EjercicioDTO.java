package com.example.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EjercicioDTO {

    private String nombre;
    private String grupoMuscular;
    private Integer series;
    private Integer repeticiones;
    private String descripcion;
}