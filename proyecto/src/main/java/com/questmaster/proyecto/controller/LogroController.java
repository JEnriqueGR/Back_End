package com.questmaster.proyecto.controller;

import com.questmaster.proyecto.modelo.Logro;
import com.questmaster.proyecto.repository.LogroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logros")
public class LogroController {
    private final LogroRepository logroRepository;

    public LogroController(LogroRepository logroRepository) {
        this.logroRepository = logroRepository;
    }

    @GetMapping
    public List<Logro> listarLogros() {
        return logroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Logro obtenerLogro(@PathVariable Long id) {
        return logroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Logro actualizarEstado(@PathVariable Long id, @RequestBody boolean estado) {
        Logro logro = logroRepository.findById(id).orElse(null);
        if (logro != null) {
            logro.setEstado(estado);
            return logroRepository.save(logro);
        }
        return null;
    }
}
