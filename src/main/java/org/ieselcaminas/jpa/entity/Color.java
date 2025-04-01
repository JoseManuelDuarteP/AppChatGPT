package org.ieselcaminas.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Color {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    
    @ManyToMany(mappedBy = "colores")
    private List<Coche> coches;
    
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

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}