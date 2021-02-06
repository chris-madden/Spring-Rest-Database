package com.accela.persondb.controller;

import com.accela.persondb.model.Address;
import com.accela.persondb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/address")
    private List<Address> getAllAddresses()
    {
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    private Address getAddress(@PathVariable("id") int id)
    {
        return addressService.getAddressById(id);
    }

    @PostMapping("/address")
    private int saveAddress(@RequestBody Address address)
    {
        addressService.createAddress(address);
        return address.getId();
    }

    @PutMapping("/address")
    private ResponseEntity<Address> updateAddress(@RequestBody Address address)
    {
        return addressService.update(address);
        //addressService.saveOrUpdate(address);
        //return address.getId();
    }

    @DeleteMapping("/address/{id}")
    private void deleteAddress(@PathVariable("id") int id)
    {
        addressService.delete(id);
    }

}
