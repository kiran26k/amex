package com.amex.service.cucumbertest;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	/*@Autowired
	RestTemplate restTemplate;*/
	
	 @When("^the client calls /token$")
	    public void the_client_issues_GET_version() throws Throwable
	    {
		  System.out.println("test feature ");
	        //executeGet("http://localhost:8080/version");
	    }

	    @Then("^the client receives status code of (\\d+)$")
	    public void the_client_receives_status_code_of(int statusCode) throws Throwable
	    {
	        /*final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
	        assertThat("status code is incorrect : "+ latestResponse.getBody(), currentStatusCode.value(), is(statusCode) );
*/	    }

	    @And("^the client receives server version (.+)$")
	    public void the_client_receives_server_version_body(String version) throws Throwable
	    {
	        //assertThat(latestResponse.getBody(), is(version)) ;
	    }

}
