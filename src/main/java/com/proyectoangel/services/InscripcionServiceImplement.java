package com.proyectoangel.services;

import com.proyectoangel.controller.request.InscripcionRequest;
import com.proyectoangel.controller.response.InscripcionResponse;
import com.proyectoangel.entitys.Curso;
import com.proyectoangel.entitys.Inscripcion;
import com.proyectoangel.entitys.Usuario;
import com.proyectoangel.entitys.repository.InscripcionRepository;
import com.proyectoangel.services.service.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InscripcionServiceImplement implements InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> getListInscripcion() {
        return inscripcionRepository.listInscripciones();
    }

    @Override
    public InscripcionResponse searchInscripcion(int id) {
        Inscripcion inscripcion = inscripcionRepository.searchInscripcion(id);  // Debería devolver una entidad de tipo Inscripcion
        return Objects.nonNull(inscripcion) ? buildInscripcionResponse(inscripcion) : InscripcionResponse.builder().build();
    }

    @Override
    public void saveInscripcion(InscripcionRequest inscripcionRequest) {
        Inscripcion inscripcion = new Inscripcion();
        Usuario usuario = new Usuario();
        Curso curso = new Curso();

        if (Objects.nonNull(inscripcionRequest)) {
            usuario.setUsuario_id(inscripcionRequest.getUsuario_id());
            curso.setCurso_id(inscripcionRequest.getCurso_id());
            inscripcion.setUsuario(usuario);
            inscripcion.setCurso(curso);
            inscripcion.setFecha_inscripcion(inscripcionRequest.getFecha_inscripcion());
            inscripcion.setContenido_formulario(inscripcionRequest.getContenido_formulario());

            inscripcionRepository.save(inscripcion);
        }
    }

    @Override
    public void updateInscripcion(InscripcionRequest inscripcionRequest) {
        if (Objects.nonNull(inscripcionRequest)) {
            Optional<Inscripcion> inscripcion = inscripcionRepository.findById(inscripcionRequest.getInscripcion_id());
            if (inscripcion.isPresent()) {
                Inscripcion inscripcionActualizar = buildInscripcionEntity(inscripcionRequest);
                inscripcionRepository.save(inscripcionActualizar);
            }
        }
    }

    @Override
    public void deleteInscripcion(int id) {
        inscripcionRepository.deleteById(id);
    }

    private static Inscripcion buildInscripcionEntity(InscripcionRequest inscripcionRequest) {
        Usuario usuario = new Usuario();
        Curso curso = new Curso();

        usuario.setUsuario_id(inscripcionRequest.getUsuario_id());
        curso.setCurso_id(inscripcionRequest.getCurso_id());

        return Inscripcion.builder()
                .inscripcion_id(inscripcionRequest.getInscripcion_id())
                .usuario(usuario)
                .curso(curso)
                .fecha_inscripcion(inscripcionRequest.getFecha_inscripcion())
                .contenido_formulario(inscripcionRequest.getContenido_formulario())
                .build();
    }

    private static InscripcionResponse buildInscripcionResponse(Inscripcion inscripcion) {
        return InscripcionResponse.builder()
                .inscripcion_id(inscripcion.getInscripcion_id())
                .usuario_id(inscripcion.getUsuario().getUsuario_id())
                .curso_id(inscripcion.getCurso().getCurso_id())
                .fecha_inscripcion(inscripcion.getFecha_inscripcion())
                .contenido_formulario(inscripcion.getContenido_formulario())
                .build();
    }
}

