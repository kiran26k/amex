package com.amex.model;

public class GetGUIDbyTokenResponse
{
    private Response Response;

    public Response getResponse ()
    {
        return Response;
    }

    public void setResponse (Response Response)
    {
        this.Response = Response;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Response = "+Response+"]";
    }
}
	