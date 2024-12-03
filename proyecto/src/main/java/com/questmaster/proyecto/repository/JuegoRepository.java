package com.questmaster.proyecto.repository;

import com.questmaster.proyecto.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {
}
