package com.amex.service.cucumbertest;

import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.amex.Application;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class AmexControllerCucmberStepsDefination {

	private static final Logger log = LoggerFactory.getLogger(AmexControllerCucmberStepsDefination.class);

	/*
	 * @Autowired RestTemplate restTemplate;
	 */

	RestTemplate restTemplate;
	ResponseEntity<String> response;

	@When("^the client calls /token$")
	public void the_client_issues_GET_version() throws Throwable {
		restTemplate = new RestTemplate();
		response = tryToGetGUID("3");
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		String expected = "{\"getGUIDbyTokenResponse\":{\"response\":null}}";
		JSONAssert.assertEquals(expected, response.getBody().toString(), true);
		HttpStatus currentStatusCode = response.getStatusCode();
	}

	@And("^the client receives server version (.+)$")
	public void the_client_receives_server_version_body(String version) throws Throwable {
		System.out.println(version);
		// assertThat(response.getBody(), version) ;
	}

	private ResponseEntity<String> tryToGetGUID(final String token) {
		return restTemplate.getForEntity("http://localhost:8080/amexsite/v1/corporate_accounts/tokens/"+token, String.class);
	}

}
