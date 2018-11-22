package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.Address;
import es.ulpgc.gs1.gs1prototype.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {

    private final AddressService addressService;
    private static final String addressPath = "/address";

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = addressPath)
    public List<Address> getAllAddresss(){
        return addressService.getAll();
    }

    @GetMapping(path = addressPath + "/{id}")
    public Address getAddress(@PathVariable Long id){
        return addressService.get(id);
    }

    @PostMapping(path = addressPath)
    public void addAddress(@RequestBody Address address){
        addressService.add(address);
    }



}
