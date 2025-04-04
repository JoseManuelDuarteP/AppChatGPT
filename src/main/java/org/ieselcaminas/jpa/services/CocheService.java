package org.ieselcaminas.jpa.services;


import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.entity.Modelo;
import org.ieselcaminas.jpa.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

    public void exportarCochesACSV(String nombreArchivo) {
        List<Coche> coches = cocheRepository.findAll();

        try (PrintWriter writer = new PrintWriter(new File(nombreArchivo))) {
            writer.println("ID,Marca,Modelo,Propietario,Matrícula");

            for (Coche coche : coches) {
                String modelo = coche.getModelo() != null ? coche.getModelo().getNombre() : "Sin modelo";
                String propietario = coche.getPropietario() != null ? coche.getPropietario().getNombre() : "Sin propietario";
                String matricula = coche.getMatricula() != null ? coche.getMatricula() : "Sin matrícula";

                writer.printf("%d,%s,%s,%s,%s%n",
                        coche.getId(),
                        coche.getMarca(),
                        modelo,
                        propietario,
                        matricula
                );
            }

            System.out.println("Archivo CSV generado con éxito: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}