package org.ieselcaminas.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    @ManyToMany(mappedBy = "colores")
    private List<Coche> coches;

    // Getters y Setters
}