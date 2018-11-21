package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.Gs1prototypeApplication;
import es.ulpgc.gs1.gs1prototype.model.VetOrder;
import es.ulpgc.gs1.gs1prototype.service.VetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = Gs1prototypeApplication.APIURL, maxAge = 4800, allowCredentials = "true")
public class VetOrderController {

    private VetOrderService vetOrderService;
    private static final String vetOrderPath = "/vetorder";

    @Autowired
    public VetOrderController(VetOrderService vetOrderService){
        this.vetOrderService = vetOrderService;
    }

    @GetMapping(vetOrderPath)
    public List<VetOrder> getAllVetOrders(){
        return vetOrderService.getAll();
    }

    @GetMapping(vetOrderPath + "/{id}")
    public VetOrder getVetOrder(@PathVariable Long id){
        return vetOrderService.get(id);
    }



}


