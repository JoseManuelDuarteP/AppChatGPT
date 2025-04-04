package org.ieselcaminas.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Coche> coches = new ArrayList();

    public Modelo() {}

    public Modelo(String nombre) {
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

    public List<Coche> getCoche() {
        return coches;
    }

    public void setCoche(Coche coche) {
        coches.add(coche);
    }

    @Override
    public String toString() {
        return "ID modelo: " + this.id + " - Modelo: " + this.nombre;
    }
}