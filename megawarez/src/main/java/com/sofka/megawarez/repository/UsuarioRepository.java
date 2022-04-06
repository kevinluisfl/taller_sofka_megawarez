package com.sofka.megawarez.repository;

import com.sofka.megawarez.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}