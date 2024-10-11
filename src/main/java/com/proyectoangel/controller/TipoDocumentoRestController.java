package com.proyectoangel.controller;

import com.proyectoangel.entitys.TipoDocumento;
import com.proyectoangel.services.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/tipo_documentos")
@RequiredArgsConstructor

public class TipoDocumentoRestController {

    private final TipoDocumentoService tipoDocumentoService;

    @GetMapping("/list")
    public ResponseEntity<List<TipoDocumento>> listTipoDocumentoApi(){
        List<TipoDocumento> TipoDocumentoList=tipoDocumentoService.getListTipoDocumento();
        return new ResponseEntity<>(TipoDocumentoList, HttpStatus.ACCEPTED);
    }

   
}
