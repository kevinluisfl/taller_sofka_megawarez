package com.sofka.megawarez.service;

import com.sofka.megawarez.domain.Usuario;
import com.sofka.megawarez.repository.UsuarioRepository;
import com.sofka.megawarez.service.interfaces.IUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        usuario.setCreatedAt(Instant.now());
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        usuario.setId(id);
        usuario.setUpdatedAt(Instant.now());
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario deleteUsuario(Integer id) {
        var usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return usuario.get();
        } else {
            return null;
        }
    }
}
