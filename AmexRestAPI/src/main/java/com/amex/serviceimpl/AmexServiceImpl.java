package com.amex.serviceimpl;

import org.springframework.stereotype.Service;

import com.amex.model.GUID;
import com.amex.model.GetGUIDbyTokenResponse;
import com.amex.service.AmexService;

@Service("amexService")
public class AmexServiceImpl implements AmexService{

	public GUID getGUIDbyTokenService(String tokenId) {
		GUID guid = new GUID();
		System.out.println("getGUIDbyTokenService");
		//setting static for now
		GetGUIDbyTokenResponse getGUIDbyTokenResponse = new GetGUIDbyTokenResponse();
		guid.setGetGUIDbyTokenResponse(getGUIDbyTokenResponse);
		return guid;
	}

	

}
