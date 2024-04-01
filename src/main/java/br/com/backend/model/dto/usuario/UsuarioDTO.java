package br.com.backend.model.dto.usuario;

import br.com.backend.model.entity.Permissao;
import br.com.backend.model.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "Usuario", description = "DTO usuário")
public class UsuarioDTO implements Serializable {

    @Schema(description = "Id usuário", example = "1", hidden = true)
    public Long id;

    @Schema(description = "Email", example = "email@example.com")
    public String email;

    @Schema(description = "Senha", example = "suasenha", hidden = true)
    @Length(min = 6)
    public String senha;

    @Schema(description = "Nome", example = "Fulano de Tal")
    @Length(min = 6)
    public String nome;

    @Schema(description = "Endereço", example = "Seu Endereço")
    public String endereco;

    @Schema(description = "Telefone", example = "00000000000")
    public String telefone;

    @Schema(description = "Status", example = "ATIVO")
    public String status;

    @Schema(description = "Permissao", example = "USER")
    public String permissao;

    @Schema(description = "Criado em", example = "2022-03-13 19:21:37", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createdAt;



    @Schema(description = "Atualizado em", example = "2022-03-13 19:21:37", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date updatedAt;

    static public UsuarioDTO entityToDTO(Usuario usuario){
        UsuarioDTO response = new UsuarioDTO();
        response.id = usuario.getId();
        response.email = usuario.getEmail();
        response.senha = usuario.getSenha();
        response.endereco = usuario.getEndereco();
        response.nome = usuario.getNome();
        response.status = usuario.getStatus();
        response.permissao = usuario.getPermissao();
        response.updatedAt = usuario.getUpdatedAt();
        response.createdAt = usuario.getCreatedAt();
        response.telefone = usuario.getTelefone();
        return response;
    }
}
