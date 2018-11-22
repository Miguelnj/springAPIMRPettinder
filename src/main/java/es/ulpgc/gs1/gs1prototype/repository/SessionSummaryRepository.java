package es.ulpgc.gs1.gs1prototype.repository;

import es.ulpgc.gs1.gs1prototype.model.SessionSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionSummaryRepository extends JpaRepository<SessionSummary,Long> {
}
