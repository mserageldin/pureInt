package com.pureInt.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pureInt.demo.domain.Breed;
import com.pureInt.demo.service.ParsingService;
@Controller
public class BreedController {
	private static final String Json_breed_url = "https://raw.githubusercontent.com/mlenze/CodingExcercise-Java/main/apidata.json";
	@Autowired
    private ParsingService parsingService;

	@RequestMapping(value = "/all")
	public ResponseEntity<Object> getBreed() {
	List<Breed> breeds = (List<Breed>) parsingService.parse(Json_breed_url);

	Collections.sort(breeds);
	List<JSONPObject> entities = new ArrayList<JSONPObject>();
	for (Breed n : breeds) {
		JSONPObject entity = new JSONPObject(n.Name, n.types);

		entities.add(entity);
	}
	return new ResponseEntity<Object>(entities, HttpStatus.OK);

	}
}
