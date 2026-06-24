package com.example.pago.dto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long membresiaId;

    @NotNull
    private Double monto;

    @NotNull
    private LocalDate fechaPago;

    private String metodoPago;

    private String estado;
}