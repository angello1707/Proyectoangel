package com.proyectoangel.services;

import com.proyectoangel.controller.request.UsuarioRequest;
import com.proyectoangel.controller.response.UsuarioResponse;
import com.proyectoangel.controller.response.TipoDocumentoResponse;
import com.proyectoangel.entitys.Usuario;
import com.proyectoangel.entitys.TipoDocumento;
import com.proyectoangel.entitys.repository.UsuarioRepository;
import com.proyectoangel.services.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImplement implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getListUsuarios() {
        return usuarioRepository.listUsuarios();
    }

    @Override
    public void deleteUser(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponse searchUser(int id) {
        Usuario usuario = usuarioRepository.searchUser(id);
        return Objects.nonNull(usuario) ? buildUsuarioResponse(usuario) : UsuarioResponse.builder().build();
    }

    @Override
    public void saveUser(UsuarioRequest usuarioRequest) {
        if (usuarioRepository.existsByDocumento(usuarioRequest.getDocumento())) {
            throw new RuntimeException("El documento ya está registrado. Por favor, use un documento diferente.");
        }
        Usuario usuario = new Usuario();
        TipoDocumento tipoDocumento = new TipoDocumento();
        if (Objects.nonNull(usuarioRequest)) {
            tipoDocumento.setTipo_documento_id(usuarioRequest.getTipo_documento()); // Actualización para usar el id correcto
            usuario.setApellido_usuario(usuarioRequest.getApellido_usuario());
            usuario.setNombre_usuario(usuarioRequest.getNombre_usuario());
            usuario.setTipo_documento(tipoDocumento);
            usuario.setDocumento(usuarioRequest.getDocumento());
            usuario.setEmail(usuarioRequest.getEmail());
            usuario.setPassword(usuarioRequest.getPassword());
            usuario.setEmpresa(usuarioRequest.getEmpresa());
            usuario.setTelefono(usuarioRequest.getTelefono());
            usuarioRepository.save(usuario);

        }
    }

    @Override
    public void updateUser(UsuarioRequest usuarioRequest) {
        if (Objects.nonNull(usuarioRequest)) {
            Optional<Usuario> usuario = usuarioRepository.findById(usuarioRequest.getId());
            if (usuario.isPresent()) {
                Usuario usuarioActualizar = buildUsuarioEntity(usuarioRequest);
                usuarioRepository.save(usuarioActualizar);
            }
        }
    }

    private static Usuario buildUsuarioEntity(UsuarioRequest usuarioRequest) {
        return Usuario.builder()
                .usuario_id(usuarioRequest.getId())
                .apellido_usuario(usuarioRequest.getApellido_usuario())
                .nombre_usuario(usuarioRequest.getNombre_usuario())
                .tipo_documento(buildTipoDocumentoEntity(usuarioRequest))
                .documento(usuarioRequest.getDocumento())
                .email(usuarioRequest.getEmail())
                .password(usuarioRequest.getPassword())
                .empresa(usuarioRequest.getEmpresa())
                .telefono(usuarioRequest.getTelefono())
                .build();
    }

    private static TipoDocumento buildTipoDocumentoEntity(UsuarioRequest usuarioRequest) {
        return TipoDocumento.builder()
                .tipo_documento_id(usuarioRequest.getTipo_documento())
                .build();
    }

    private static UsuarioResponse buildUsuarioResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .usuario_id(usuario.getUsuario_id())
                .nombre_usuario(usuario.getNombre_usuario())
                .apellido_usuario(usuario.getApellido_usuario())
                .tipoDocumentoResponse(buildTipoDocumentoResponse(usuario.getTipo_documento()))
                .documento(usuario.getDocumento())
                .email(usuario.getEmail())
                .empresa(usuario.getEmpresa())
                .telefono(usuario.getTelefono())
                .build();
    }

    private static TipoDocumentoResponse buildTipoDocumentoResponse(TipoDocumento tipoDocumento) {
        return TipoDocumentoResponse.builder()
                .tipo_documento_id(tipoDocumento.getTipo_documento_id())
                .sigla(tipoDocumento.getSigla())
                .descripcion(tipoDocumento.getDescripcion())
                .build();
    }
}