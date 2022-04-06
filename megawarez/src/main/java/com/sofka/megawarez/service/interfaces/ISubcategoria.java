package com.sofka.megawarez.service.interfaces;

import com.sofka.megawarez.domain.Subcategoria;

import java.util.List;

public interface ISubcategoria {

    public List<Subcategoria> getList();

    public Subcategoria createSubcategoria(Subcategoria subcategoria);

    public Subcategoria updateSubcategoria(Integer id, Subcategoria subcategoria);

    public Subcategoria deleteSubcategoria(Integer id);
}
