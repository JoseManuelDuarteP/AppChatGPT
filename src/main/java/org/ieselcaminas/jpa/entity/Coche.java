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

    public Coche {}



    private List<Color> colores;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Color> getColores() {
        return colores;
    }

    public void setColores(List<Color> colores) {
        this.colores = colores;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                '}';
    }
}