package com.proyectoangel.services;


import com.proyectoangel.entitys.Inscripcion;
import com.proyectoangel.entitys.repository.InscripcionRepository;
import com.proyectoangel.services.service.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class InscripcionServiceImplement implements InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> getListInscripcion() {
        return inscripcionRepository.listInscripciones();
    }

}
