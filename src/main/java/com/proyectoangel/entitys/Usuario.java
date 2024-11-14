package com.proyectoangel.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="usuarios")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int usuario_id;

    @Column(name="nombre_usuario", nullable = false)
    private String nombre_usuario;

    @Column(name="apellido_usuario", nullable = false)
    private String apellido_usuario;

    @ManyToOne
    @JoinColumn(name = "fk_id_tipo_documento",referencedColumnName ="tipo_documento_id", nullable = false)
    private TipoDocumento tipo_documento;

    @Column(name="documento",nullable = false)
    private String documento;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="empresa")
    private String empresa;

    @Column(name="telefono")
    private String telefono;

}
