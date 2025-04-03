package org.ieselcaminas.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String marca;

    @ManyToOne
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietario propietario;

    @OneToMany(mappedBy = "coche", cascade = CascadeType.ALL)
    private List<Modelo> modelos;

    @ManyToMany
    @JoinTable(
        name = "coche_color",
        joinColumns = @JoinColumn(name = "coche_id"),
        inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private List<Color> colores;

    // Getters y Setters
}