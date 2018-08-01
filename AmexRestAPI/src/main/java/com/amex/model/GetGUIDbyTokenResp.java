package com.amex.model;

public class GetGUIDbyTokenResp 
{
    private String GUID ;

    public String getGUID  ()
    {
        return GUID ;
    }

    public void setGUID  (String GUID )
    {
        this.GUID  = GUID ;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [GUID  = "+GUID +"]";
    }
}