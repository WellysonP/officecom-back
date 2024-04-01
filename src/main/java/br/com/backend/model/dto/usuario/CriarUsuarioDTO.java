package br.com.backend.model.dto.usuario;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Schema(name = "CriarUsuario", description = "DTO criar usuário")
public class CriarUsuarioDTO {

    @Schema(description = "Email", example = "email@example.com")
    @NotNull
    @Email
    public String email;

    @Schema(description = "Nome", example = "Fulano de Tal")
    @NotNull
    @Length(min = 5)
    public String nome;

    @Schema(description = "Telefone", example = "00000000000")
    @NotNull
    @Length(min = 11)
    public String telefone;

    @Schema(description = "Endereço", example = "Seu Endereço")
    @NotNull
    @Length(min = 6)
    public String endereco;

    @Schema(description = "Sua senha", example = "suasenha")
    @NotNull
    @Length(min = 5)
    public String senha;
}
