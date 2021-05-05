package com.catarino.test.entity;

import java.io.Serializable;
import java.util.List;

public class PersonData implements Serializable {

	private final List<Person> persons;
	private final int subListSize;

	public PersonData(List<Person> persons, int subListSize) {
		this.persons = persons;
		this.subListSize = subListSize;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public int getSubListSize() {
		return subListSize;
	}
}
