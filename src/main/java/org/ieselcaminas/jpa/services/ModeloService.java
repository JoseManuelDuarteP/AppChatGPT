package org.ieselcaminas.jpa.services;


import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.entity.Modelo;
import org.ieselcaminas.jpa.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> listarModelos() {
        return modeloRepository.findAll();
    }

    public Modelo agregarModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public void eliminarModelo(Long id) {
        modeloRepository.deleteById(id);
    }

    public Modelo encontrarModelo(Long id) {
        if (modeloRepository.findById(id).isPresent()) {
            return modeloRepository.findById(id).get();
        } else {
            return null;
        }
    }
}