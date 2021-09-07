package com.pureInt.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pureInt.demo.domain.Breed;
import com.pureInt.demo.service.ParsingService;
@Service
public class JsonParsingService implements ParsingService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Breed> parse(String url) {
		JsonFactory factory = new JsonFactory();
		List<Breed> result = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper(factory);

		JsonNode rootNode;

		JsonNode breed = restTemplate.getForObject(url, JsonNode.class);
		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = breed.fields();

		while (fieldsIterator.hasNext()) {

			Map.Entry<String, JsonNode> field = fieldsIterator.next();

			List<String> values = new ArrayList();
			Iterator<JsonNode> iter = field.getValue().iterator();
		//	System.out.println("Key:" + field.getKey() + "\tValue:" + field.getValue().iterator());
			while (iter.hasNext()) {

				values.add(iter.next().toString());

			}
			Breed br = new Breed(field.getKey(), values);
			result.add(br);

		}

		return result;

	}

}
