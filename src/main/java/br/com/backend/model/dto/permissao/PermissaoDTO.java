package br.com.backend.model.dto.permissao;

import br.com.backend.model.entity.Permissao;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "Permissao", description = "Model Permissão")
public class PermissaoDTO implements Serializable {

    @Schema(description = "Id", example = "null")
    private Long id;

    @Schema(description = "Nome", example = "ROLE_CRIAR_USUARIO")
    @NotEmpty
    @Length(min = 2)
    private String nome;

    @Schema(description = "Descricao", example = "Essa permissão deve permitir criar usuário")
    @NotEmpty
    @Length(min = 6)
    private String descricao;

    @Schema(description = "Grupo", example = "UGE")
    @NotEmpty
    @Length(min = 2)
    private String grupo;

    @Schema(description = "Criado em", example = "2022-03-13 19:21:37")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @Schema(description = "Atualizado em", example = "2022-03-13 19:21:37")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    static public PermissaoDTO entityToDTO(Permissao permissao){
        PermissaoDTO response = new PermissaoDTO();
        response.id = permissao.getId();
        response.nome = permissao.getNome();
        response.descricao = permissao.getDescricao();
        response.grupo = permissao.getGrupo();
        response.createdAt = permissao.getCreatedAt();
        response.updatedAt = permissao.getUpdatedAt();
        return response;
    }
}
