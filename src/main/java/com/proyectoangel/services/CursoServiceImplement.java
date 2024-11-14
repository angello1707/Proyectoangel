package com.proyectoangel.services;

import com.proyectoangel.controller.request.CursoRequest;
import com.proyectoangel.controller.response.CursoResponse;
import com.proyectoangel.entitys.Curso;
import com.proyectoangel.entitys.repository.CursoRepository;
import com.proyectoangel.services.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoServiceImplement implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public List<Curso> getListCurso() {

        return cursoRepository.listCursos();
    }

    @Override
    public void deleteCurso(int id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public CursoResponse searchCurso(int id) {
        Curso curso = cursoRepository.searchCurso(id);
        return Objects.nonNull(curso) ? buildCursoResponse(curso) : CursoResponse.builder().build();
    }

    @Override
    public void saveCurso(CursoRequest cursoRequest){
        Curso curso = new Curso();
        if (Objects.nonNull(cursoRequest)) {
            curso.setCurso_id(cursoRequest.getId());
            curso.setTitulo(cursoRequest.getTitulo());
            curso.setDescripcion(cursoRequest.getDescripcion());
            curso.setFecha_inicio(LocalDate.parse(cursoRequest.getFecha_inicio()));
            curso.setFecha_fin(LocalDate.parse(cursoRequest.getFecha_fin()));
            curso.setEstado(cursoRequest.getEstado());
            cursoRepository.save(curso);
        }
    }

    @Override
    public void updateCurso(CursoRequest cursoRequest) {
        if (Objects.nonNull(cursoRequest)) {
            Optional<Curso> curso = cursoRepository.findById(cursoRequest.getId());
            if (curso.isPresent()) {
                Curso cursoActualizar = buildCursoEntity(cursoRequest);
                cursoRepository.save(cursoActualizar);
            }
        }
    }

    private static Curso buildCursoEntity(CursoRequest cursoRequest) {
        return Curso.builder()
                .curso_id(cursoRequest.getId())
                .titulo(cursoRequest.getTitulo())
                .descripcion(cursoRequest.getDescripcion())
                .fecha_inicio(LocalDate.parse(cursoRequest.getFecha_inicio()))
                .fecha_fin(LocalDate.parse(cursoRequest.getFecha_fin()))
                .estado(cursoRequest.getEstado())
                .build();
    }

    private static CursoResponse buildCursoResponse(Curso curso) {
        return CursoResponse.builder()
                .curso_id(curso.getCurso_id())
                .titulo(curso.getTitulo())
                .descripcion(curso.getDescripcion())
                .fecha_inicio(String.valueOf(curso.getFecha_inicio()))
                .fecha_fin(String.valueOf(curso.getFecha_fin()))
                .estado(curso.getEstado())
                .build();
    }
}
