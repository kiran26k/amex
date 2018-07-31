package com.amex.service;

import com.amex.model.GUID;

public interface AmexService {
	
	GUID getGUIDbyTokenService(String tokenId);

}
