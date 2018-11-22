package es.ulpgc.gs1.gs1prototype.service;


import es.ulpgc.gs1.gs1prototype.model.VetOrder;
import es.ulpgc.gs1.gs1prototype.repository.VetOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VetOrderService {

    private final VetOrderRepository vetOrderRepository;
    private final ThreadService threadService;

    @Autowired
    public VetOrderService(VetOrderRepository vetOrderRepository,ThreadService threadService) {
        this.vetOrderRepository = vetOrderRepository;
        this.threadService = threadService;
    }

    public List<VetOrder> getAll(){
        return vetOrderRepository.findAll();
    }

    public VetOrder get(Long id) {
        return vetOrderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void add(VetOrder vetOrder) {vetOrderRepository.save(vetOrder);}

}