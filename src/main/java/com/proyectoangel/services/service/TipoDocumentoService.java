package com.proyectoangel.services.service;


import com.proyectoangel.controller.request.TipoDocumentoRequest;
import com.proyectoangel.controller.response.TipoDocumentoResponse;
import com.proyectoangel.entitys.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {

    List<TipoDocumento> listarTiposDeDocumentos();
    void guardarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest);
    void eliminarTiposDeDocumentos(int id);
    void actualizarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest);
    TipoDocumentoResponse consultarTiposDeDocumentos(int id);
}
