package es.ulpgc.gs1.gs1prototype.repository;

import es.ulpgc.gs1.gs1prototype.model.VetOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetOrderRepository extends JpaRepository<VetOrder,Long> {
}
