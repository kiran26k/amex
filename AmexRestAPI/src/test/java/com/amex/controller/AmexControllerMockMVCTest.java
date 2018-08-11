package com.amex.controller;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amex.model.GUID;
import com.amex.service.AmexService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AmexControllerMockMVCTest {

	@Autowired
	MockMvc springMvc;

	/*@Autowired
	WebApplicationContext wContext;*/

	@InjectMocks
	AmexController amexController;

	@MockBean
	AmexService amexService;

	/*@Before
	public void init() throws Exception {
		springMvc = MockMvcBuilders.webAppContextSetup(wContext).build();
		amexService = Mockito.mock(AmexService.class);
	}*/

	@Test
	public void testLocalServiceWithMockedRemoteService() throws Exception {
		GUID response1 = new GUID();
		Mockito.when(amexService.getGUIDbyTokenService("3")).thenReturn(response1);

		/*RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/amexsite/v1/corporate_accounts/tokens/3")
				.accept(MediaType.APPLICATION_JSON);

		ResultActions resultActions = springMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk());
		String guid = resultActions.andReturn().getResponse().getContentAsString();
		resultActions.andDo(MockMvcResultHandlers.print());*/

		MvcResult mvcResult = springMvc.perform(MockMvcRequestBuilders.get("/amexsite/v1/corporate_accounts/tokens/3")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		// To verify mock has been called or not
		//Mockito.verify(amexService);

	}

	@After
	public void teardown() {
		amexService = null;
	}

}
