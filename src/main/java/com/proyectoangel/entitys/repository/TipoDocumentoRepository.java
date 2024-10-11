package com.proyectoangel.entitys.repository;

import com.proyectoangel.entitys.TipoDocumento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {

    @Query(value="SELECT * FROM tipo_documentos",nativeQuery= true)
    List<TipoDocumento> listTipoDocumentos();

}
