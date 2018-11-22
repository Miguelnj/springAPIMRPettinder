package es.ulpgc.gs1.gs1prototype.repository;

import es.ulpgc.gs1.gs1prototype.model.PayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayerInfoRepository extends JpaRepository<PayerInfo,Long> {
}
