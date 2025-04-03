package org.ieselcaminas.jpa.services;


import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    public List<Coche> listarCoches() {
        return cocheRepository.findAll();
    }

    public Coche agregarCoche(Coche coche) {
        return cocheRepository.save(coche);
    }

    public void eliminarCoche(Long id) {
        cocheRepository.deleteById(id);
    }
}