package com.amex.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.amex.Application;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AmexControllerIntgrationTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	//RestTemplate restTemplate;
	
	
	
	@Before
	public void setUp() {
		
	}

	@Test
	public void testRetrieveGUID() throws Exception {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String getUserURI = "http://localhost:" + port +"/amexsite/v1/corporate_accounts/tokens/3";
		ResponseEntity<String> response = restTemplate.exchange(getUserURI,	HttpMethod.GET, entity, String.class);
		String expected = "{\"getGUIDbyTokenResponse\":{\"response\":null}}";
		System.out.println(" response amex "+response + " port "+ port);
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@After
	public void teardown() {
	
	}

}
