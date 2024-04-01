package br.com.backend.service;

import br.com.backend.enums.StatusEnum;
import br.com.backend.exception.NotAuthorizedException;
import br.com.backend.model.dto.auth.LoginDTO;
import br.com.backend.model.dto.auth.TokenResponse;
import br.com.backend.model.entity.Usuario;
import br.com.backend.repository.UsuarioRepository;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

@ApplicationScoped
public class AuthService {

    @Inject
    UsuarioRepository usuarioRepository;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    public TokenResponse login(LoginDTO login){
        TokenResponse tokenResponse = new TokenResponse();

       Optional<Usuario> usuario = usuarioRepository.findByEmail(login.email);

       if(usuario.isEmpty()){
           throw new NotAuthorizedException("Erro ao efetuar a autenticação");
       }

        if(!BCrypt.checkpw(login.senha, usuario.get().getSenha())){
            throw new NotAuthorizedException("Erro ao realizar o login, e-mail ou senha inválido!");
        }

        if ("INATIVO".equals(usuario.get().getStatus())) {
            throw new NotAuthorizedException("Usuário inativo");
        }

        tokenResponse.token = gerarTokenJWT(usuario.get());

        return tokenResponse;
    }

    public String gerarTokenJWT(Usuario usuario){
        Set<String> groups = new HashSet<>();

        groups.add(usuario.getPermissao());
        groups.add(usuario.getStatus());

        String token =
                Jwt.issuer(issuer)
                        .upn(usuario.getEmail())
                        .groups(groups)
                        .claim(Claims.full_name, usuario.getNome())
                        .expiresAt(Instant.now().plus(Duration.ofHours(1)))
                        .sign();
        return token;
    }
}
