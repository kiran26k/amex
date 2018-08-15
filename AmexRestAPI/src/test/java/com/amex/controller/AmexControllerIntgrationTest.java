package com.amex.controller;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.amex.Application;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AmexControllerIntgrationTest {

	@LocalServerPort
	private int port;
	
	@Value("classpath:GuidResp.json")
	Resource resource;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	//RestTemplate restTemplate;
	@Before
	public void setUp() {
		
	}

	@Test
	public void testRetrieveGUID() throws Exception {
		String expected =getJsonModel();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String getUserURI = "http://localhost:" + port +"/amexsite/v1/corporate_accounts/tokens/3";
		ResponseEntity<String> response = restTemplate.exchange(getUserURI,	HttpMethod.GET, entity, String.class);
		Assert.assertNotEquals(expected, response.getBody());
		//JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@After
	public void teardown() {
	
	}
	
	private String getJsonModel() throws IOException {
		File json =resource.getFile();
		ObjectMapper mapperObj = new ObjectMapper();
		Object readValue = mapperObj.readValue(resource.getInputStream(), Object.class);
		return mapperObj.writeValueAsString(readValue);
	}

}
