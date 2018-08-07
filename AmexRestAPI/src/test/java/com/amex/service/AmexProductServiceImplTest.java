package com.amex.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amex.model.Response;
import com.amex.serviceimpl.AmexProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AmexProductServiceImpl.class})
public class AmexProductServiceImplTest{
	
	
	
	@Autowired
	AmexProductService amexProdService;
	
	
	@Test
	@DirtiesContext
	public void getGUIDbyTokenServiceTest() throws Exception {
		Response userResponse = new Response(); 
		Response resp = amexProdService.getGUIDbyTokenService("12");
		assertEquals(userResponse, resp);
	}


	

}

