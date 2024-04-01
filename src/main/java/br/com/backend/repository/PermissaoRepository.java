package br.com.backend.repository;

import br.com.backend.model.entity.Permissao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PermissaoRepository implements PanacheRepository<Permissao> {


    public Permissao findByNome(String nome){
        return find("nome", nome).firstResult();
    }

    public void deleteByNome(String nome){
        delete("nome", nome);
    }
}
