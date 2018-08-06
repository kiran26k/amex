package com.amex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amex.model.GUID;
import com.amex.service.AmexService;



@RestController
public class AmexController {
	
	@Autowired
	AmexService amexService;

	 ///amexsite/v1/corporate_accounts/tokens/{token_number}/
	 @GetMapping(path ="/amexsite/v1/corporate_accounts/tokens/{token_number}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public GUID getGUIDbyToken(@PathVariable("token_number") String token) {
		 //Call service giving GUID using token
		 
		 System.out.println("getGUIDbyToken");
		 GUID guidModel = amexService.getGUIDbyTokenService(token);
		 System.out.println(guidModel);
		 System.out.println(MediaType.APPLICATION_JSON_VALUE);
		 return guidModel;
	 }

	
}
