package com.amex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amex.model.GUID;
import com.amex.service.AmexService;


@RestController
public class AmexController {
	
	@Autowired
	AmexService amexService;

	 @RequestMapping("guid")
	 @ResponseBody
	 public GUID getGUIDbyToken(@RequestParam(name="tokenId", required=false, defaultValue="Unknown")String token) {
		 //Call service giving GUID using token
		 GUID guidModel = amexService.getGUIDbyTokenService(token);
		 return guidModel;
	 }

}
