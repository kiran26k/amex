package com.amex.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

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
		System.out.println("amexProdService "+amexProdService);
		Response resp = amexProdService.getUserInfo("12");
		assertEquals(userResponse, resp);
	}
	
	

	

}

