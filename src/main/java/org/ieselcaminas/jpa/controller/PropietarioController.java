package org.ieselcaminas.jpa.controller;

import org.ieselcaminas.jpa.entity.Propietario;
import org.ieselcaminas.jpa.services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    public List<Propietario> listar() {
        return propietarioService.listarPropietarios();
    }

    @PostMapping
    public Propietario agregar(@RequestBody Propietario propietario) {
        return propietarioService.agregarPropietario(propietario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        propietarioService.eliminarPropietario(id);
    }
}