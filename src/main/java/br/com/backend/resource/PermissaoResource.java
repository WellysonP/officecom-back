//package br.com.backend.resource;
//
//import br.com.backend.model.dto.permissao.PermissaoDTO;
//import br.com.backend.service.PermissaoService;
//import io.quarkus.security.Authenticated;
//import org.eclipse.microprofile.openapi.annotations.Operation;
//import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
//import org.eclipse.microprofile.openapi.annotations.media.Content;
//import org.eclipse.microprofile.openapi.annotations.media.Schema;
//import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
//import org.eclipse.microprofile.openapi.annotations.tags.Tag;
//
//import javax.annotation.security.RolesAllowed;
//import javax.inject.Inject;
//import javax.transaction.Transactional;
//import javax.validation.Valid;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Tag(name = "Application Resource", description = "Endpoints comuns da aplicação")
//@Path("/v1/permissoes")
//@Authenticated
//public class PermissaoResource {
//
//    @Inject
//    PermissaoService permissaoService;
//
//    @Operation(summary = "Método para listar permissões")
//    @APIResponse(responseCode = "200",
//            content = @Content(
//                    mediaType = MediaType.APPLICATION_JSON,
//                    schema = @Schema(implementation = PermissaoDTO.class, type = SchemaType.ARRAY)))
//    @GET
//    @RolesAllowed({"ADMIN", "USER"})
//    public List<PermissaoDTO> list() {
//        return permissaoService.list();
//    }
//
//    @Operation(summary = "Método para buscar permissão por id")
//    @APIResponse(responseCode = "200",
//            content = @Content(
//                    mediaType = MediaType.APPLICATION_JSON,
//                    schema = @Schema(implementation = PermissaoDTO.class, type = SchemaType.OBJECT)))
//    @GET
//    @Path("{id}")
//    @RolesAllowed({"ADMIN", "USER"})
//    public PermissaoDTO get(@PathParam("id") Long id){
//        return permissaoService.findById(id);
//    }
//
//    @Transactional
//    @POST()
//    @Operation(summary = "Método para adicionar permissão")
//    @APIResponse(responseCode = "201",
//            content = @Content(
//                    mediaType = MediaType.APPLICATION_JSON,
//                    schema = @Schema(implementation = PermissaoDTO.class, type = SchemaType.OBJECT)))
//    @RolesAllowed({"ADMIN", "USER"})
//    public Response create(@Valid PermissaoDTO criarPermissao) {
//        PermissaoDTO permissao = permissaoService.create(criarPermissao);
//        return Response.status(Response.Status.CREATED).entity(permissao).build();
//    }
//
//    @Transactional
//    @PUT
//    @Path("{id}")
//    @Operation(summary = "Método para atualizar permissão")
//    @APIResponse(responseCode = "200",
//            content = @Content(
//                    mediaType = MediaType.APPLICATION_JSON,
//                    schema = @Schema(implementation = PermissaoDTO.class, type = SchemaType.OBJECT)))
//    @RolesAllowed({"ADMIN", "USER"})
//    public Response update(@PathParam("id") Long id, @Valid PermissaoDTO atualizarPermissao) {
//        PermissaoDTO permissao = permissaoService.update(atualizarPermissao, id);
//        return Response.status(Response.Status.OK)
//                .entity(permissao).build();
//    }
//
//    @Operation(summary = "Método para deletar permissão")
//    @Transactional
//    @DELETE
//    @Path("{id}")
//    @RolesAllowed({"ADMIN", "USER"})
//    public void delete(@PathParam("id") Long id) {
//        permissaoService.delete(id);
//    }
//
//}
