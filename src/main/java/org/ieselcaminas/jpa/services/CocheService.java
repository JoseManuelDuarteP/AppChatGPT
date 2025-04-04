package org.ieselcaminas.jpa.services;


import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.entity.Modelo;
import org.ieselcaminas.jpa.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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


    public String generarMatricula() {
        Random random = new Random();
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";

        int numRan = random.nextInt(10000);
        String parteNumerica = String.format("%04d", numRan); // rellena con ceros a la izquierda

        StringBuilder parteLetras = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char letra = letras.charAt(random.nextInt(letras.length()));
            parteLetras.append(letra);
        }

        return parteNumerica + "-" + parteLetras;
    }

    public Coche encontrarCoche(Long id) {
        if (cocheRepository.findById(id).isPresent()) {
            return cocheRepository.findById(id).get();
        } else {
            return null;
        }
    }
}