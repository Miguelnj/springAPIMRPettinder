package es.ulpgc.gs1.gs1prototype.repository;

import es.ulpgc.gs1.gs1prototype.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
