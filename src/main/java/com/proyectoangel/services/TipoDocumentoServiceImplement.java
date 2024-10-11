package com.proyectoangel.services;

import com.proyectoangel.entitys.TipoDocumento;
import com.proyectoangel.entitys.repository.TipoDocumentoRepository;
import com.proyectoangel.services.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImplement implements TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> getListTipoDocumento() {
        return tipoDocumentoRepository.listTipoDocumentos();

    }
}
