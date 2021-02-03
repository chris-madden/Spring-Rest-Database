package com.accela.persondb.repository;

import com.accela.persondb.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository  extends CrudRepository<Person, Integer> {
}
