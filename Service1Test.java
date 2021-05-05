package com.catarino.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.catarino.test.entity.Person;
import com.catarino.test.entity.PersonData;

@SpringBootTest
class Service1Test {

	private Service1 service = new Service1();

	@Test
	void processTest() {
		Person p1 = new Person("firstName1", "lastName", 11);
		Person p2 = new Person("firstName2", "lastName", 12);
		Person p3 = new Person("firstName3", "lastName", 13);
		Person p4 = new Person("firstName4", "lastName", 14);
		Person p5 = new Person("firstName5", "lastName", 15);

		PersonData personData = new PersonData(Arrays.asList(p1, p2, p3, p4, p5), 2);
		List<List<Person>> result = service.process(personData);
		assertEquals(3, result.size());
		assertEquals(2, result.get(0).size());
		assertEquals(2, result.get(1).size());
		assertEquals(1, result.get(2).size());
	}

}