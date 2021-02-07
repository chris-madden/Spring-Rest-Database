package com.accela.persondb;

import com.accela.persondb.controller.PersonController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersondbApplicationTests {

	@Autowired
	PersonController personController;

	@Test
	void contextLoads()
	{
		assertNotNull(personController);
 	}

}
