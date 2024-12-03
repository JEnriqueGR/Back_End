package com.questmaster.proyecto.controller;

import com.questmaster.proyecto.modelo.Logro;
import com.questmaster.proyecto.repository.LogroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logros")
public class LogroController {
    @Autowired
    private LogroRepository logroRepository;

    @GetMapping
    public List<Logro> listarLogros(@RequestParam Long juegoId) {
        return logroRepository.findByJuegoId(juegoId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Logro> actualizarEstado(@PathVariable Long id, @RequestBody boolean estado) {
        return logroRepository.findById(id)
                .map(logro -> {
                    logro.setEstado(estado);
                    logroRepository.save(logro);
                    return ResponseEntity.ok(logro);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
