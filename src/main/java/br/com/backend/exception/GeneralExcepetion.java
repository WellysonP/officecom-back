package br.com.backend.exception;

import br.com.backend.model.dto.Message;
import org.jboss.logging.Logger;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralExcepetion implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = Logger.getLogger(GeneralExcepetion.class.getName());

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception e) {

        Message message = new Message();

        if(e instanceof NotFoundException){
            message.setMessage(e.getMessage());
            message.setStatusCode(Response.Status.NOT_FOUND.getStatusCode());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(message)
                    .build();
        }

        if(e instanceof NotAuthorizedException){
            message.setMessage(e.getMessage());
            message.setStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(message)
                    .build();
        }

        LOGGER.error("Failed to handle request", e);

        message.setMessage("Erro: Por favor entre em contato com o suporte.");
        message.setStatusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(message).build();
    }
}
