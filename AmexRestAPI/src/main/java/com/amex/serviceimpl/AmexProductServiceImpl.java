package com.amex.serviceimpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;

import com.amex.model.GetGUIDbyTokenResp;
import com.amex.model.Response;

@Configuration
public class AmexProductServiceImpl{

	@Bean
	public String getString() {
		return "testbd";
	}
	
	@Bean
	public IntegrationFlow getUserInfo(String tokenId) {
		System.out.println("Test");
		Response response = new Response();
		response.setGetGUIDbyTokenResp(new GetGUIDbyTokenResp());
		response.setRespCd("123");
		//return flow -> flow.transform((String s) -> s.toUpperCase());
		return flow -> flow.transform((String s) -> response);
	}
	
	

}

