// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/connServiceInvalid.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AdminQuerySDKVerifyInfoResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AdminQuerySDKVerifyInfoResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AdminQuerySDKVerifyInfoResponse";
    }

    public java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult> vecRules = null;

    public int eResultCode = 0;

    public java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult> getVecRules()
    {
        return vecRules;
    }

    public void  setVecRules(java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult> vecRules)
    {
        this.vecRules = vecRules;
    }

    public int getEResultCode()
    {
        return eResultCode;
    }

    public void  setEResultCode(int eResultCode)
    {
        this.eResultCode = eResultCode;
    }

    public AdminQuerySDKVerifyInfoResponse()
    {
    }

    public AdminQuerySDKVerifyInfoResponse(java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult> vecRules, int eResultCode)
    {
        this.vecRules = vecRules;
        this.eResultCode = eResultCode;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AdminQuerySDKVerifyInfoResponse t = (AdminQuerySDKVerifyInfoResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(vecRules, t.vecRules) && 
            com.qq.taf.jce.JceUtil.equals(eResultCode, t.eResultCode) );
    }

    public int hashCode()
    {
        try
        {
            throw new Exception("Need define key first!");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }
    public java.lang.Object clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void writeTo(com.qq.taf.jce.JceOutputStream _os)
    {
        _os.write(vecRules, 0);
        _os.write(eResultCode, 1);
    }

    static java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult> cache_vecRules;
    static int cache_eResultCode;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_vecRules)
        {
            cache_vecRules = new java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult>();
            com.qq.jce.WCS.AdminSDKVerifyInfoResult __var_42 = new com.qq.jce.WCS.AdminSDKVerifyInfoResult();
            ((java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult>)cache_vecRules).add(__var_42);
        }
        this.vecRules = (java.util.ArrayList<com.qq.jce.WCS.AdminSDKVerifyInfoResult>) _is.read(cache_vecRules, 0, true);
        this.eResultCode = (int) _is.read(eResultCode, 1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(vecRules, "vecRules");
        _ds.display(eResultCode, "eResultCode");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(vecRules, true);
        _ds.displaySimple(eResultCode, false);
    }

}

