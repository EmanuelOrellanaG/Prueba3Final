package com.example.reserva.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaResponseDTO {

    private Long id;
    private String nombreUsuario;
    private String nombreClase;
    private LocalDateTime fechaReserva;
}
