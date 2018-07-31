package com.amex.serviceimpl;

import org.springframework.stereotype.Service;

import com.amex.model.GUID;
import com.amex.service.AmexService;

@Service("amexService")
public class AmexServiceImpl implements AmexService{

	public GUID getGUIDbyTokenService(String tokenId) {
		GUID guid = new GUID();
		//setting static for now
		guid.setGuid("1234");
		return guid;
	}

	

}
