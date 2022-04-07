package com.sofka.megawarez.service.interfaces;

import com.sofka.megawarez.domain.Descarga;

import java.util.List;

public interface IDescarga {

    public List<Descarga> getDescargas();

    public Descarga createDescarga(Descarga descarga);

    public Descarga updateDescarga(Integer id, Descarga descarga);

    public Descarga deleteDescarga(Integer id);
}
