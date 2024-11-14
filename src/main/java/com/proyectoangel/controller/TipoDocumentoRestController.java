package com.proyectoangel.controller;

import com.proyectoangel.controller.request.TipoDocumentoRequest;
import com.proyectoangel.controller.response.TipoDocumentoResponse;
import com.proyectoangel.entitys.TipoDocumento;
import com.proyectoangel.services.service.TipoDocumentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/tipo_documentos")

public class TipoDocumentoRestController {

    private  final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoRestController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<TipoDocumento>> listDocumentTypes(){
        List<TipoDocumento> tipoDocumentos = tipoDocumentoService.listarTiposDeDocumentos();
        return ResponseEntity.accepted().body(tipoDocumentos);
    }

    @PostMapping("/save")
    public ResponseEntity<String> guardarTipoDocumento(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
        tipoDocumentoService.guardarTiposDeDocumentos(tipoDocumentoRequest);
        return ResponseEntity.accepted().body("Tipo de documento guardardo");
    }

    @GetMapping("/delete")
    public ResponseEntity<String> eliminarTipoDocumento(@RequestParam("id") int id ){
        tipoDocumentoService.eliminarTiposDeDocumentos(id);
        return ResponseEntity.accepted().body("Tipo de documento elimindo");
    }

    @GetMapping("/update")
    public ResponseEntity<String> actualizarTipoDocumento(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
        tipoDocumentoService.actualizarTiposDeDocumentos(tipoDocumentoRequest);
        return ResponseEntity.accepted().body("Tipo de documento actualizado");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<TipoDocumentoResponse> consultarTipoDocumento(@PathVariable int id){
        TipoDocumentoResponse tipoDocumentos = tipoDocumentoService.consultarTiposDeDocumentos(id);
        return ResponseEntity.accepted().body(tipoDocumentos);
    }





}
