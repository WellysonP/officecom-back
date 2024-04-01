package br.com.backend.resource;

import br.com.backend.model.dto.auth.LoginDTO;
import br.com.backend.model.dto.auth.TokenResponse;
import br.com.backend.service.AuthService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

    @Inject
    AuthService authService;


    @POST()
    @Path("login")
    public TokenResponse login(@Valid LoginDTO login) {
        return authService.login(login);
    }
}
