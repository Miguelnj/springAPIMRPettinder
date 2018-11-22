package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.VetOrder;
import es.ulpgc.gs1.gs1prototype.service.VetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VetOrderController {

    private final VetOrderService vetOrderService;
    private static final String vetOrderPath = "/vetOrders";

    @Autowired
    public VetOrderController(VetOrderService vetOrderService) {
        this.vetOrderService = vetOrderService;
    }

    @GetMapping(path = vetOrderPath)
    public List<VetOrder> getAllVetOrders(){
        return vetOrderService.getAll();
    }

    @GetMapping(path = vetOrderPath + "/{id}")
    public VetOrder getVetOrder(@PathVariable Long id){
        return vetOrderService.get(id);
    }

    @PostMapping(path = vetOrderPath)
    public void addVetOrder(@RequestBody VetOrder vetOrder){
        vetOrderService.add(vetOrder);
    }



}


