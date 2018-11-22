package es.ulpgc.gs1.gs1prototype.repository;

import es.ulpgc.gs1.gs1prototype.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary,Long> {
}
