package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Address;
import es.ulpgc.gs1.gs1prototype.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll(){return addressRepository.findAll();}

    public Address get(Long id){return addressRepository.getOne(id);}

    public void add(Address address){addressRepository.save(address);}



}