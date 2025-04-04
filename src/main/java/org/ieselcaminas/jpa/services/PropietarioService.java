package org.ieselcaminas.jpa.services;


import org.ieselcaminas.jpa.entity.Modelo;
import org.ieselcaminas.jpa.entity.Propietario;
import org.ieselcaminas.jpa.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Propietario> listarPropietarios() {
        return propietarioRepository.findAll();
    }

    public Propietario agregarPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public void eliminarPropietario(Long id) {
        propietarioRepository.deleteById(id);
    }

    public Propietario encontrarPropietario(Long id) {
        if (propietarioRepository.findById(id).isPresent()) {
            return propietarioRepository.findById(id).get();
        } else {
            return null;
        }
    }
}