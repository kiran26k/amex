package com.amex.model;

public class GUID {
	
	private GetGUIDbyTokenResponse getGUIDbyTokenResponse;

    public GetGUIDbyTokenResponse getGetGUIDbyTokenResponse ()
    {
        return getGUIDbyTokenResponse;
    }

    public void setGetGUIDbyTokenResponse (GetGUIDbyTokenResponse getGUIDbyTokenResponse)
    {
        this.getGUIDbyTokenResponse = getGUIDbyTokenResponse;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [getGUIDbyTokenResponse = "+getGUIDbyTokenResponse+"]";
    }

}
