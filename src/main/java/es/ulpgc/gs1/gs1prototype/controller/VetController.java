package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.user.Vet;
import es.ulpgc.gs1.gs1prototype.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VetController {

    private final VetService vetService;
    private static final String vetPath = "/vets";
    private static final String vetAvailablePath = "/vetsAvailable";

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping(vetPath)
    public List<Vet> getAllVets(){
        return vetService.getAll();
    }

    @GetMapping(vetPath + "/{id}")
    public Vet getUser(@PathVariable Long id){
        return vetService.get(id);
    }

    @GetMapping(vetPath + "/name/{username}")
    public Vet getUserByUsername(@PathVariable String username){
        return vetService.getByUsername(username);
    }

    @GetMapping(vetAvailablePath)
    public List<Vet> getAvailableVets(){
        return getAllVets();
    }



}
