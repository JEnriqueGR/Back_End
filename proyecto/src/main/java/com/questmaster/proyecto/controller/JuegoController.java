package com.questmaster.proyecto.controller;

import com.questmaster.proyecto.model.Juego;
import com.questmaster.proyecto.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JuegoController {

    @Autowired
    private JuegoRepository juegoRepository;

    @GetMapping("/juegos")
    public List<Juego> getAllJuegos() {
        return juegoRepository.findAll();
    }
}
