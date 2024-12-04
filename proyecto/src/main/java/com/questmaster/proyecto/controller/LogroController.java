package com.questmaster.proyecto.controller;

import com.questmaster.proyecto.model.Logro;
import com.questmaster.proyecto.repository.LogroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogroController {

    @Autowired
    private LogroRepository logroRepository;

    @GetMapping("/logros/{juegoId}")
    public List<Logro> getLogrosByJuego(@PathVariable Long juegoId) {
        return logroRepository.findByJuegoId(juegoId);
    }

    @PutMapping("/logro/{logroId}")
    public Logro updateLogro(@PathVariable Long logroId, @RequestParam boolean estado) {
        Logro logro = logroRepository.findById(logroId).orElseThrow();
        logro.setEstado(estado);
        return logroRepository.save(logro);
    }
}

