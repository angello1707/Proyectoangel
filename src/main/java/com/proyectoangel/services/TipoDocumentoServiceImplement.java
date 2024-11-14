package com.proyectoangel.services;

import com.proyectoangel.controller.request.TipoDocumentoRequest;
import com.proyectoangel.controller.response.TipoDocumentoResponse;
import com.proyectoangel.entitys.TipoDocumento;
import com.proyectoangel.entitys.repository.TipoDocumentoRepository;
import com.proyectoangel.services.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImplement implements TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRespository;

    @Override
    public List<TipoDocumento> listarTiposDeDocumentos() {
        return tipoDocumentoRespository.listDocumentType();
    }

    @Override
    public void guardarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest) {
        if(Objects.nonNull(tipoDocumentoRequest)){
            TipoDocumento tipoDocumento =  TipoDocumento.builder()
                    .sigla(tipoDocumentoRequest.getSigla())
                    .descripcion(tipoDocumentoRequest.getDescripcion())
                    .build();
            tipoDocumentoRespository.save(tipoDocumento);
        }
    }

    @Override
    public void eliminarTiposDeDocumentos(int id) {
        tipoDocumentoRespository.deleteById(id);
    }

    @Override
    public void actualizarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest) {
        if(Objects.nonNull(tipoDocumentoRequest)){
            TipoDocumento tipoDocumento = TipoDocumento.builder()
                    .sigla(tipoDocumentoRequest.getSigla())
                    .descripcion(tipoDocumentoRequest.getDescripcion())
                    .build();
            tipoDocumentoRespository.save(tipoDocumento);
        }
    }

    @Override
    public TipoDocumentoResponse consultarTiposDeDocumentos(int id) {
        TipoDocumento tipoDocumento = tipoDocumentoRespository.findByDocumentType(id);
        if(Objects.nonNull(tipoDocumento)){
            return TipoDocumentoResponse.builder()
                    .tipo_documento_id(tipoDocumento.getTipo_documento_id())
                    .sigla(tipoDocumento.getSigla())
                    .descripcion(tipoDocumento.getDescripcion())
                    .build();
        }
        return TipoDocumentoResponse.builder().build();
    }
}
