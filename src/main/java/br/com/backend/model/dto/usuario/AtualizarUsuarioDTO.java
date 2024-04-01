package br.com.backend.model.dto.usuario;


import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Schema(name = "AtualizarUsuario", description = "DTO atualizar usuário")
public class AtualizarUsuarioDTO {

    @Schema(description = "Nome", example = "Fulano de Tal")
    @NotNull
    @Length(min = 6)
    public String nome;

    @Schema(description = "Sua senha", example = "suasenha")
    @NotNull
    @Length(min = 6)
    public String senha;
}
