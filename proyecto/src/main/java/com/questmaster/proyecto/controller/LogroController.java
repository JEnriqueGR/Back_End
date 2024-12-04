package com.questmaster.proyecto.controller;

import com.questmaster.proyecto.model.Logro;
import com.questmaster.proyecto.repository.LogroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logros")
public class LogroController {

    @Autowired
    private LogroRepository logroRepository;

    @GetMapping("/{juegoId}")
    public List<Logro> obtenerLogrosPorJuego(@PathVariable Long juegoId) {
        return logroRepository.findByJuegoId(juegoId);
    }

    @PutMapping("/{id}")
    public Logro cambiarEstado(@PathVariable Long id) {
        Logro logro = logroRepository.findById(id).orElseThrow();
        logro.setEstado(!logro.isEstado());
        return logroRepository.save(logro);
    }
}
