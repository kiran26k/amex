package com.amex.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.amex.model.Response;


@MessagingGateway
public interface AmexProductService {
	
	//Queue 
	@Gateway(requestChannel = "getUserInfo.input")
	Response getUserInfo(String tokenId);
}
