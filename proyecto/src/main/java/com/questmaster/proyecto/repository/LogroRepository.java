package com.questmaster.proyecto.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Repository
public interface LogroRepository extends JpaRepository<Logro, Long> {
    List<Logro> findByJuegoId(Long juegoId);
}
