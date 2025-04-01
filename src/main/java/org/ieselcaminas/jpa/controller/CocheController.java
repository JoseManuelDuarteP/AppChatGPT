package org.ieselcaminas.jpa.controller;


import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.services.CocheService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/coches")
public class CocheController {
    private final CocheService cocheService;

    public CocheController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @GetMapping
    public List<Coche> getAllCoches() {
        return cocheService.getAllCoches();
    }

    @PostMapping
    public Coche addCoche(@RequestBody Coche coche) {
        return cocheService.saveCoche(coche);
    }

    @DeleteMapping("/{id}")
    public void deleteCoche(@PathVariable Long id) {
        cocheService.deleteCoche(id);
    }
}