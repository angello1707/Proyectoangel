package com.proyectoangel.entitys.repository;

import com.proyectoangel.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario,Integer>{


    @Query(value="SELECT * FROM Usuarios",nativeQuery= true)
    List<Usuario> listUsuarios();



}
