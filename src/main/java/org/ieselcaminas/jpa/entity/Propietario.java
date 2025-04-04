package org.ieselcaminas.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Coche> coches = new ArrayList<>();

    // Constructor vacío (necesario para JPA)
    public Propietario() {}

    // Constructor con parámetros
    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Coche coche) {
        coches.add(coche);
    }

    @Override
    public String toString() {
        return "ID propietario: " + this.id + " - Nombre: " + this.nombre;
    }
}