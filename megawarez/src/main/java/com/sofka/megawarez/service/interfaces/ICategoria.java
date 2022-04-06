package com.sofka.megawarez.service.interfaces;

import com.sofka.megawarez.domain.Categoria;

import java.util.List;

public interface ICategoria {

    public List<Categoria> getList();

    public Categoria createCategoria(Categoria categoria);

    public Categoria updateCategoria(Integer id, Categoria categoria);

    public Categoria deleteCategoria(Integer id);
}
