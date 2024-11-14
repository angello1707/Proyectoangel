package com.proyectoangel.services.service;


import com.proyectoangel.controller.request.InscripcionRequest;
import com.proyectoangel.controller.response.InscripcionResponse;
import com.proyectoangel.entitys.Inscripcion;

import java.util.List;

public interface InscripcionService {

    List<Inscripcion> getListInscripcion();
    void deleteInscripcion(int id);
    InscripcionResponse searchInscripcion(int id);
    void saveInscripcion(InscripcionRequest inscripcionRequest);
    void updateInscripcion(InscripcionRequest inscripcionRequest);
}
