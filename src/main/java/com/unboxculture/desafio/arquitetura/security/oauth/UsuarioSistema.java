package com.unboxculture.desafio.arquitetura.security.oauth;

import com.unboxculture.desafio.core.entity.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class UsuarioSistema extends User {

    private Usuario usuario;

    public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> permissoes) {
        super(usuario.getEmail(), usuario.getSenha(), permissoes);
        this.usuario = usuario;
    }
}
