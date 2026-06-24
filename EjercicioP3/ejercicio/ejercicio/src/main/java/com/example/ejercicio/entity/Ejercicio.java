package com.example.ejercicio.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ejercicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String grupoMuscular; // pecho, espalda, piernas
    private Integer series;
    private Integer repeticiones;
    private String descripcion;
}