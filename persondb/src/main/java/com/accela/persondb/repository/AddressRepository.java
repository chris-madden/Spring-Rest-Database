package com.accela.persondb.repository;

import com.accela.persondb.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
