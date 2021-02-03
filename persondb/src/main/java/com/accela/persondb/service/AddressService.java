package com.accela.persondb.service;

import com.accela.persondb.model.Address;
import com.accela.persondb.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        addressRepository.findAll().forEach(address -> addresses.add(address));
        return addresses;
    }

    public Address getAddressById(int id)
    {
        return addressRepository.findById(id).get();
    }

    public void saveOrUpdate(Address address)
    {
        addressRepository.save(address);
    }

    public void delete(int id)
    {
        addressRepository.deleteById(id);
    }

}
