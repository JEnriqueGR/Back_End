package com.questmaster.proyecto.modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "juegos") // Mapea esta clase a la tabla "juegos" en MySQL
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String plataforma; // Cambiamos "descripcion" por "plataforma" según tu tabla

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
    private List<Logro> logros;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public List<Logro> getLogros() {
        return logros;
    }

    public void setLogros(List<Logro> logros) {
        this.logros = logros;
    }
}
