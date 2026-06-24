package com.example.rutina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RutinaDTO {

    private String nombre;
    private String descripcion;
    private String nivel;
    private Integer duracionSemanas;

    private Long usuarioId;
    private Long ejercicioId;

}
