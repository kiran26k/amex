package com.amex.model;

public class Response
{
    private GetGUIDbyTokenResp  getGUIDbyTokenResp ;

    private String RespCd;

    public GetGUIDbyTokenResp  getGetGUIDbyTokenResp  ()
    {
        return getGUIDbyTokenResp ;
    }

    public void setGetGUIDbyTokenResp  (GetGUIDbyTokenResp  getGUIDbyTokenResp )
    {
        this.getGUIDbyTokenResp  = getGUIDbyTokenResp ;
    }

    public String getRespCd ()
    {
        return RespCd;
    }

    public void setRespCd (String RespCd)
    {
        this.RespCd = RespCd;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [getGUIDbyTokenResp  = "+getGUIDbyTokenResp +", RespCd = "+RespCd+"]";
    }
}