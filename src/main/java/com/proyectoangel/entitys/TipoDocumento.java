package com.proyectoangel.entitys;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="tipo_documentos")
@Builder
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
