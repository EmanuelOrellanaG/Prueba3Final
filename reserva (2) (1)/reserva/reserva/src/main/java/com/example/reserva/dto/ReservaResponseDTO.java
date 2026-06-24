package com.example.reserva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaResponseDTO {

    private Long id;
    private String nombreUsuario;
    private String nombreClase;
    private LocalDateTime fechaReserva;
}
