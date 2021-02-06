package com.accela.persondb.service;

import com.accela.persondb.model.Address;
import com.accela.persondb.model.Person;
import com.accela.persondb.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> getAllAddresses()
    {
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    public Address getAddressById(int id)
    {
        return addressRepository.findById(id).get();
    }

    public void createAddress(Address address)
    {
        addressRepository.save(address);
    }

    public ResponseEntity<Address> update(Address address)
    {
        if(addressRepository.findById(address.getId()).isPresent())
        {
            return new ResponseEntity<>(addressRepository.save(address), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(address, HttpStatus.BAD_REQUEST);
        }
    }

    public void delete(int id)
    {
        addressRepository.deleteById(id);
    }

}
