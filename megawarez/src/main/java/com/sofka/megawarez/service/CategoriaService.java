package com.sofka.megawarez.service;

import com.sofka.megawarez.domain.Categoria;
import com.sofka.megawarez.repository.CategoriaRepository;
import com.sofka.megawarez.service.interfaces.ICategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class CategoriaService implements ICategoria {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public Categoria createCategoria(Categoria categoria) {
        categoria.setCreatedAt(Instant.now());
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public Categoria updateCategoria(Integer id, Categoria categoria) {
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public Categoria deleteCategoria(Integer id) {
        var categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.delete(categoria.get());
            return categoria.get();
        } else {
            return null;
        }
    }
}
