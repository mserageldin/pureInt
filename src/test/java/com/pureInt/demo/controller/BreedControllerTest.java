package com.pureInt.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class BreedControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BreedController MainService;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetBreed() {
		MainService.getBreed();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all").accept(MediaType.APPLICATION_JSON);
		RequestBuilder responseBuilder = MockMvcRequestBuilders.get("https://dog.ceo/api/breeds/list/all").accept(MediaType.APPLICATION_JSON);
		MvcResult result;
		MvcResult expect;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			expect= mockMvc.perform(responseBuilder).andReturn();
			System.out.println(result.getResponse());
			//String expected = "{id:Course1,name:Spring,description:10Steps}";

			

			JSONAssert.assertEquals(expect.getResponse().getContentAsString(), result.getResponse()
					.getContentAsString(), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
