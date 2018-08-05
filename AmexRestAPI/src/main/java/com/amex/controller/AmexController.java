package com.amex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amex.model.GUID;
import com.amex.service.AmexService;



@Controller
public class AmexController {
	
	@Autowired
	AmexService amexService;

	 
	 @GetMapping(path ="/amexsite/v1/corporate_accounts/tokens/{token_number}/", produces=MediaType.APPLICATION_JSON_VALUE)
	 public GUID getGUIDbyToken(@PathVariable String token) {
		 //Call service giving GUID using token
		 System.out.println("getGUIDbyToken");
		 GUID guidModel = amexService.getGUIDbyTokenService(token);
		 return guidModel;
	 }

	
}
