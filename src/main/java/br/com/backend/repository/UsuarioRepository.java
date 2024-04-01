package br.com.backend.repository;

import br.com.backend.model.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public Usuario findByName(String nome){
        return find("nome", nome).firstResult();
    }

    public Optional<Usuario> findByEmail(String email){
        return find("email", email).firstResultOptional();
    }

    public List<Usuario> findAlive(){
        return list("status", true);
    }

    public void deleteByName(String nome){
        delete("nome", nome);
    }

}
