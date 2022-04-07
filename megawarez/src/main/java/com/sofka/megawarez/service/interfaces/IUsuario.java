package com.sofka.megawarez.service.interfaces;

import com.sofka.megawarez.domain.Usuario;

import java.util.List;

public interface IUsuario {

    public List<Usuario> getUsuarios();

    public Usuario createUsuario(Usuario usuario);

    public Usuario updateUsuario(Integer id, Usuario usuario);

    public Usuario deleteUsuario(Integer id);
}
