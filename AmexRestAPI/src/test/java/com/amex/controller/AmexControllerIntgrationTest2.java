package com.amex.controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amex.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AmexControllerIntgrationTest2 {

	@Autowired
	MockMvc springMvc;

	@Before
	public void setUp() {

	}

	@Test
	public void testRetrieveGUID() throws Exception {

		MvcResult mvcResult = springMvc.perform(MockMvcRequestBuilders.get("/amexsite/v1/corporate_accounts/tokens/3")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		String jsonResp = "{\"getGUIDbyTokenResponse\":{\"response\":null}}";
		JSONAssert.assertEquals(jsonResp, mvcResult.getResponse().getContentAsString(), true);
		System.out.println(mvcResult.getResponse());
	
	}

	@After
	public void teardown() {

	}

}
