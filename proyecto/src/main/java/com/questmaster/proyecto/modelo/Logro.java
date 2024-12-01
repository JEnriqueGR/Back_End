package com.questmaster.proyecto.modelo;

import jakarta.persistence.*;

@Entity
public class Logro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private boolean estado;
    private String dificultad;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public String getDificultad() { return dificultad; }
    public void setDificultad(String dificultad) { this.dificultad = dificultad; }

    public Juego getJuego() { return juego; }
    public void setJuego(Juego juego) { this.juego = juego; }
}
