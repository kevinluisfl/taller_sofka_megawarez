package com.sofka.megawarez.service;

import com.sofka.megawarez.domain.Descarga;
import com.sofka.megawarez.repository.DescargaRepository;
import com.sofka.megawarez.service.interfaces.IDescarga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class DescargaService implements IDescarga {

    @Autowired
    private DescargaRepository descargaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Descarga> getDescargas() {
        return (List<Descarga>) descargaRepository.findAll();
    }

    @Override
    @Transactional
    public Descarga createDescarga(Descarga descarga) {
        descarga.setCreatedAt(Instant.now());
        return descargaRepository.save(descarga);
    }

    @Override
    @Transactional
    public Descarga updateDescarga(Integer id, Descarga descarga) {
        descarga.setId(id);
        return descargaRepository.save(descarga);
    }

    @Override
    @Transactional
    public Descarga deleteDescarga(Integer id) {
        var descarga = descargaRepository.findById(id);
        if (descarga.isPresent()) {
            descargaRepository.delete(descarga.get());
            return descarga.get();
        } else {
            return null;
        }
    }
}
