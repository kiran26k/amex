package com.amex.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.amex.Application;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles(value = "integration")
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AmexControllerTest {

	RestTemplate restTemplate;
	

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8081);
	

	@Before
	public void setUp() {
		mockGUIDService();
	}

	@Test
	public void testLocalServiceWithMockedRemoteService() throws Exception {
		restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/amex", String.class);
		String expected = "SampleResponse: {\r\n" + 
				"  \"getGUIDbyTokenResponse\": {\r\n" + 
				"    \"Response\": {\r\n" + 
				"      \"RespCd\": \"0\",\r\n" + 
				"      \"getGUIDbyTokenResp\": {\r\n" + 
				"        \"GUID\": \"e82662gvebdjdi987277\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		JSONAssert.assertEquals(expected, response.getBody(), true);
	}

	private void mockGUIDService() {	
		WireMock.stubFor(WireMock.get(WireMock.urlMatching("/amexsite/v1/corporate_accounts/tokens/123/"))
	            .willReturn(
	                    WireMock.aResponse()
	                            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
	                            .withStatus(HttpStatus.OK.value())
	                            .withBodyFile("GuidResp.json")
	            ));
	}
	
	
	

}
