package com.questmaster.proyecto.repository;

import com.questmaster.proyecto.model.Logro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LogroRepository extends JpaRepository<Logro, Long> {
    List<Logro> findByJuegoId(Long juegoId);
}
