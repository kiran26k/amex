package com.amex.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.amex.model.GetGUIDbyTokenResp;
import com.amex.model.Response;
import com.amex.serviceimpl.AmexProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmexProductServiceImpl.class)
@EnableAutoConfiguration
public class AmexProductServiceImplTest{
	
	
	
	@Autowired
	AmexProductService amexProdService;
	
	
	@Test
	@DirtiesContext
	public void getGUIDbyTokenServiceTest() throws Exception {
		Response userResponse = new Response();
		userResponse.setGetGUIDbyTokenResp(new GetGUIDbyTokenResp());
		userResponse.setRespCd("123");
		System.out.println("amexProdService "+amexProdService);
		//amexProdService.getUserInfo("kiran");
		//System.out.println(amexProdService.getUserInfo("kiran"));
		Response response = amexProdService.getUserInfo("kiran");
		System.out.println(response);
		System.out.println(userResponse);
		Assert.assertEquals(userResponse, response);
	}
	
	

	

}

