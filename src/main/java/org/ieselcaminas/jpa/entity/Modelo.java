package org.ieselcaminas.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "coche_id", nullable = false)
    private Coche coche;

    // Getters y Setters
}