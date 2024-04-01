package br.com.backend.service;


import br.com.backend.enums.PermissaoEnum;
import br.com.backend.enums.StatusEnum;
import br.com.backend.model.dto.usuario.AtualizarUsuarioDTO;
import br.com.backend.model.dto.usuario.CriarUsuarioDTO;
import br.com.backend.model.dto.usuario.UsuarioDTO;
import br.com.backend.model.entity.Usuario;
import br.com.backend.model.dto.Message;
import br.com.backend.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> list() {
        List<UsuarioDTO> list = usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTO::entityToDTO)
                .collect(Collectors.toList());
        return list;
    }

    public UsuarioDTO findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findByIdOptional(id);

        if (usuario.isEmpty()) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new Message("Usuário não encontrado!", Response.Status.NOT_FOUND.getStatusCode()))
                    .build()
            );
        }

        return UsuarioDTO.entityToDTO(usuario.get());
    }

    public UsuarioDTO create(CriarUsuarioDTO criarUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNome(criarUsuario.nome);
        usuario.setEmail(criarUsuario.email);
        usuario.setTelefone(criarUsuario.telefone);
        usuario.setEndereco(criarUsuario.endereco);
        usuario.setPermissao(String.valueOf(PermissaoEnum.USER));
        usuario.setStatus(String.valueOf(StatusEnum.INATIVO));

        String salt = BCrypt.gensalt();
        String senha = BCrypt.hashpw(criarUsuario.senha, salt) ;

        usuario.setSenha(senha);

        Optional<Usuario> usuarioExiste = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExiste.isPresent()) {
            throw new WebApplicationException(Response
                    .status(Response.Status.CONFLICT)
                    .entity(new Message("Usuário já existe!", Response.Status.CONFLICT.getStatusCode()))
                    .build()
            );
        }

        usuarioRepository.persist(usuario);

        return UsuarioDTO.entityToDTO(usuario);
    }

    public UsuarioDTO update(UsuarioDTO atualizarUsuario, Long id) {

        Usuario usuario = usuarioRepository.findById(id);

        if (Objects.isNull(usuario)) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new Message("Usuário não encontrado!", Response.Status.NOT_FOUND.getStatusCode()))
                    .build()
            );
        }

        if (atualizarUsuario.nome != null) {
            usuario.setNome(atualizarUsuario.nome);
        }
        if (atualizarUsuario.senha != null) {
            usuario.setSenha(atualizarUsuario.senha);
        }
        if (atualizarUsuario.telefone != null) {
            usuario.setTelefone(atualizarUsuario.telefone);
        }
        if (atualizarUsuario.permissao != null) {
            usuario.setPermissao(atualizarUsuario.permissao);
        }
        if (atualizarUsuario.status != null) {
            usuario.setStatus(atualizarUsuario.status);
        }

        usuarioRepository.persist(usuario);
        return UsuarioDTO.entityToDTO(usuario);
    }

    public void delete(Long id) {

        Usuario usuario = usuarioRepository.findById(id);

        if (Objects.isNull(usuario)) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new Message("Usuário não encontrado!", Response.Status.NOT_FOUND.getStatusCode()))
                    .build()
            );
        }

        usuarioRepository.delete(usuario);
    }
}
