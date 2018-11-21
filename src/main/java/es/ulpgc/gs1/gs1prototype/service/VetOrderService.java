package es.ulpgc.gs1.gs1prototype.service;


import es.ulpgc.gs1.gs1prototype.model.VetOrder;
import es.ulpgc.gs1.gs1prototype.repository.VetOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VetOrderService {
    private final VetOrderRepository vetOrderRepository;

    @Autowired
    public VetOrderService(VetOrderRepository vetOrderRepository) {
        this.vetOrderRepository = vetOrderRepository;
    }

    public VetOrder get(Long id) {
        return vetOrderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<VetOrder> getAll() {
        return vetOrderRepository.findAll();
    }
}
