package com.sofka.megawarez.service;

import com.sofka.megawarez.domain.Subcategoria;
import com.sofka.megawarez.repository.SubcategoriaRepository;
import com.sofka.megawarez.service.interfaces.ISubcategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class SubcategoriaService implements ISubcategoria {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Subcategoria> getSubcategorias() {
        return (List<Subcategoria>) subcategoriaRepository.findAll();
    }

    @Override
    @Transactional
    public Subcategoria createSubcategoria(Subcategoria subcategoria) {
        subcategoria.setCreatedAt(Instant.now());
        return subcategoriaRepository.save(subcategoria);
    }

    @Override
    @Transactional
    public Subcategoria updateSubcategoria(Integer id, Subcategoria subcategoria) {
        subcategoria.setId(id);
        return subcategoriaRepository.save(subcategoria);
    }

    @Override
    @Transactional
    public Subcategoria deleteSubcategoria(Integer id) {
        var subcategoria = subcategoriaRepository.findById(id);
        if (subcategoria.isPresent()) {
            subcategoriaRepository.delete(subcategoria.get());
            return subcategoria.get();
        } else {
            return null;
        }
    }

}
