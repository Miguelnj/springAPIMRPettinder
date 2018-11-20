package es.ulpgc.gs1.gs1prototype.service;


import es.ulpgc.gs1.gs1prototype.model.user.Vet;
import es.ulpgc.gs1.gs1prototype.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VetService {

    private VetRepository vetRepository;

    @Autowired
    public VetService(VetRepository vetRepository){
        this.vetRepository = vetRepository;
    }


    public List<Vet> getAll() {
        return vetRepository.findAll();
    }

    public Vet get(Long id) {
        return vetRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}
