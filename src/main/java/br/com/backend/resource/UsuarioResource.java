package br.com.backend.resource;

import br.com.backend.model.dto.usuario.AtualizarUsuarioDTO;
import br.com.backend.model.dto.usuario.CriarUsuarioDTO;
import br.com.backend.model.dto.usuario.UsuarioDTO;
import br.com.backend.service.UsuarioService;
import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @RolesAllowed({"ADMIN", "ATIVO"})
    @Operation(summary = "Método para listar usuários")
    @APIResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = UsuarioDTO.class, type = SchemaType.ARRAY)))
    @GET
    public List<UsuarioDTO> list() {
        return usuarioService.list();
    }

    @RolesAllowed({"ADMIN", "ATIVO"})
    @Operation(summary = "Método para buscar usuário por id")
    @APIResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = UsuarioDTO.class, type = SchemaType.OBJECT)))
    @GET
    @Path("{id}")
    public UsuarioDTO get(@PathParam("id") Long id){
        return usuarioService.findById(id);
    }

    @Operation(summary = "Método para adicionar usuário")
    @APIResponse(responseCode = "201",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CriarUsuarioDTO.class, type = SchemaType.OBJECT)))
    @Transactional
    @POST
    public Response add(@Valid CriarUsuarioDTO criarUsuario) {
        UsuarioDTO usuario = usuarioService.create(criarUsuario);
        return Response.status(Response.Status.CREATED)
                .entity(usuario).build();
    }

    @RolesAllowed({"ADMIN", "ATIVO"})
    @Operation(summary = "Método para atualizar usuário")
    @APIResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = UsuarioDTO.class, type = SchemaType.OBJECT)))
    @Transactional
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @Valid UsuarioDTO atualizarUsuario) {
        UsuarioDTO usuario = usuarioService.update(atualizarUsuario, id);
        return Response.status(Response.Status.OK)
                .entity(usuario).build();
    }


    @RolesAllowed({"ADMIN", "ATIVO"})
    @Operation(summary = "Método para deletar usuário")
    @Transactional
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
    }
}
