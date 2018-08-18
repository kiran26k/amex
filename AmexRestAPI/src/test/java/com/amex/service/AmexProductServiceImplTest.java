package com.amex.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class AmexProductServiceImplTest {

	@Autowired
	@Qualifier("getUserInfo.input")
	private MessageChannel getUserInfoChannel;


	@Test
	@SuppressWarnings("unchecked")
	public void getUserInfo() throws Exception {	
		System.out.println("getUserInfo.input");
	}
	
	
	@Configuration
    @EnableIntegration
    public static class Config {

        @Bean
        public IntegrationFlow fileNotFoundFlow() {
            return IntegrationFlows.from("getUserInfo.input")
                    .<Object>handle((payload, headers) -> {
                        System.out.println(payload);
                        return payload;
                    }, e -> e.id("getUserInfo.ouput"))
                    .channel("getUserInfo.input")
                    .get();
        }

    }
	
	
}
