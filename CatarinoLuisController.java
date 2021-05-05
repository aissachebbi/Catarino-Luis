package com.catarino.test.controller;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catarino.test.entity.Person;
import com.catarino.test.entity.PersonData;
import com.catarino.test.service.Service1;

@RestController
public class CatarinoLuisController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CatarinoLuisController.class);

	@Autowired
	private Service1 service1;

	@GetMapping("/ping")
	public String ping() {
		LOGGER.info("Pong at {}", Calendar.getInstance().getTime());
		return "OK";
	}

	@PostMapping(value = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<List<Person>> process(@RequestBody PersonData personData) {
		return service1.process(personData);
	}
}
