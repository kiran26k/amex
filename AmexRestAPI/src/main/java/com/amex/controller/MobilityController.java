package com.amex.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amex.model.GetGUIDbyTokenResp;
import com.amex.model.Response;



@RestController
public class MobilityController {
	

	
	 @GetMapping(path ="/amexsite/v1/corporate_accounts/mobility", produces = MediaType.APPLICATION_JSON_VALUE)
	 public Response getMobilityData() {	 
		 System.out.println("getMobilityData");
		  Response res = new Response();
		  GetGUIDbyTokenResp guiDbyTokenResp = new GetGUIDbyTokenResp();
		  res.setGetGUIDbyTokenResp(guiDbyTokenResp);
		  return res;
	 }
	 
	 
	 @PostMapping(path ="/amexsite/v1/corporate_accounts/mobility", produces = MediaType.APPLICATION_JSON_VALUE)
	 public Response getData() {	 
		 System.out.println("getData post");
		  Response res = new Response();
		  GetGUIDbyTokenResp guiDbyTokenResp = new GetGUIDbyTokenResp();
		  res.setGetGUIDbyTokenResp(guiDbyTokenResp);
		  return res;
	 }

	
}
