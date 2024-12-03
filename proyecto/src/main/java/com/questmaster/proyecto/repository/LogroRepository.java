package com.questmaster.proyecto.repository;

import com.questmaster.proyecto.modelo.Logro;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LogroRepository extends JpaRepository<Logro, Long> {
    List<Logro> findByJuegoId(Long juegoId);
}
