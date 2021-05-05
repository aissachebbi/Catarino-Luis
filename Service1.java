package com.catarino.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.catarino.test.entity.Person;
import com.catarino.test.entity.PersonData;

@Service
public class Service1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(Service1.class);

	public List<List<Person>> process(PersonData personData) {

		List<Person> personList = personData.getPersons().stream().filter(this::hasValidAttributes).collect(Collectors.toList());
		List<List<Person>> subSets = new ArrayList<>();
		List<Person> tempList = new ArrayList<>(personData.getSubListSize());
		for (Person p : personList) {
			tempList.add(p);
			if (tempList.size() == personData.getSubListSize()) {
				subSets.add(tempList);
				tempList = new ArrayList<>(personData.getSubListSize());
			}
		}

		if (!tempList.isEmpty()) {
			subSets.add(tempList);
		}

		return subSets;
	}

	private boolean hasValidAttributes(final Person person) {
		boolean result = isValidAttribute(person.getFirstName()) && isValidAttribute(person.getLastName());
		if (!result) {
			LOGGER.warn("{} with invalid attribute(s)", person);
		}
		return result;
	}

	private boolean isValidAttribute(final String attribute) {
		return !(attribute == null || attribute.isEmpty());
	}

}
