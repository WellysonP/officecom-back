package br.com.backend.model.dto.auth;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Schema(name = "Login", description = "DTO Login")
public class LoginDTO implements Serializable {

    @Schema(description = "Email", example = "email@example.com")
    @NotNull
    @Email
    public String email;

    @Schema(description = "Sua senha", example = "suasenha")
    @NotNull
    @Length(min = 5)
    public String senha;
}
