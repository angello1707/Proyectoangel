package com.proyectoangel.entitys.repository;

import com.proyectoangel.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario,Integer>{

    boolean existsByDocumento(String documento);

    @Query(value="SELECT * FROM Usuarios",nativeQuery= true)
    List<Usuario> listUsuarios();

    @Query(value = "SELECT * FROM Usuarios WHERE CASE usuario_id=:id", nativeQuery = true)//lo hace de forma nativa lo hace mas rapido
    Usuario searchUser(@Param(value = "id") int id);

}
