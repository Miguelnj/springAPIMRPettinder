package es.ulpgc.gs1.gs1prototype.repository;

import es.ulpgc.gs1.gs1prototype.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Long> {
}
