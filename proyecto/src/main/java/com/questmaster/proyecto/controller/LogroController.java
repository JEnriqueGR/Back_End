package com.questmaster.proyecto.controller;

import com.questmaster.proyecto.model.Logro;
import com.questmaster.proyecto.repository.LogroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logros")
public class LogroController {

    @Autowired
    private LogroRepository logroRepository;

    @GetMapping("/{juegoId}")
    public List<Logro> getLogrosByJuego(@PathVariable Long juegoId) {
        return logroRepository.findByJuegoId(juegoId);
    }

    @PutMapping("/{logroId}/estado")
    public ResponseEntity<Logro> updateLogroEstado(@PathVariable Long logroId, @RequestBody EstadoRequest estadoRequest) {
        Optional<Logro> logroOptional = logroRepository.findById(logroId);
        if (logroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Logro logro = logroOptional.get();
        logro.setEstado(estadoRequest.isEstado());
        logroRepository.save(logro);
        return ResponseEntity.ok(logro);
    }

    // Clase auxiliar para manejar el estado
    public static class EstadoRequest {
        private boolean estado;

        public boolean isEstado() {
            return estado;
        }

        public void setEstado(boolean estado) {
            this.estado = estado;
        }
    }

    @GetMapping("/logro/{logroId}")
    public Logro getLogro(@PathVariable Long logroId) {
        return logroRepository.findById(logroId).orElseThrow();
    }

}


