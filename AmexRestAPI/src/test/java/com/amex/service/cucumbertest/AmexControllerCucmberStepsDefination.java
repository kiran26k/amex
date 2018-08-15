package com.amex.service.cucumbertest;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.amex.Application;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class AmexControllerCucmberStepsDefination {

	private static final Logger log = LoggerFactory.getLogger(AmexControllerCucmberStepsDefination.class);

	RestTemplate restTemplate;
	ResponseEntity<String> response;
	Response resp;
	String url;
	String tokenNO;

	@Given("^url getuserinfo \"([^\"]*)\"$")
	public void api_getuserinfo_token_url_running(String url) {
		this.url = url;
		System.out.println("url " + url);
		resp = RestAssured.given().when().get(url);
		Assert.assertEquals(200, resp.getStatusCode());
	}

	@And("^token no(.+)$")
	public void the_token_no(String token) throws Throwable {
		tokenNO = token;
		System.out.println("Given token " + token);
	}

	@When("^method getuserinfo GET$")
	public void the_client_issues_GET_version() throws Throwable {
		restTemplate = new RestTemplate();
		response = tryToGetGUID(tokenNO);
	}

	@Then("^status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		String expected = "{\"getGUIDbyTokenResponse\":{\"response\":null}}";
		// JSONAssert.assertEquals(expected, response.toString(), true);
		HttpStatus currentStatusCode = response.getStatusCode();
	}

	private ResponseEntity<String> tryToGetGUID(final String token) {
		return restTemplate.getForEntity("http://localhost:8080/amexsite/v1/corporate_accounts/tokens/" + token + "/",
				String.class);
	}

}
