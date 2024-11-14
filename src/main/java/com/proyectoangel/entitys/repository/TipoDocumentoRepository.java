package com.proyectoangel.entitys.repository;

import com.proyectoangel.entitys.TipoDocumento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {

    @Query(value = "SELECT * FROM tipo_documentos",nativeQuery = true)
    List<TipoDocumento> listDocumentType();

    @Query(value = "SELECT * FROM tipo_documentos WHERE id=:id",nativeQuery = true)
    TipoDocumento findByDocumentType(@Param("id") int id);

}
