package com.proyectoangel.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tipo_documentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TipoDocumento {

    @Id
    @Column(name="tipo_documento_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int tipo_documento_id;

    @Column(name="sigla")
    private String sigla;

    @Column(name ="descripcion")
    private String descripcion;

}
