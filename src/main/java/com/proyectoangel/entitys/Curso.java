package com.proyectoangel.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cursos")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private long curso_id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin")
    private LocalDate fecha_fin;

    @Column(name = "estado", columnDefinition = "ENUM('activo', 'inactivo') DEFAULT 'activo'")
    private String estado = "activo"; // Valor por defecto
}
