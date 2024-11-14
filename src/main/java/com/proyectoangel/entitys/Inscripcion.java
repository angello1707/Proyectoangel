package com.proyectoangel.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inscripciones")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscripcion_id")
    private int inscripcion_id;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario",referencedColumnName ="usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_id_curso",referencedColumnName ="curso_id", nullable = false)
    private Curso curso;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDateTime fecha_inscripcion;

    @Column(name = "contenido_formulario")
    private String contenido_formulario;
}