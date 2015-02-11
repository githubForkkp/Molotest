// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/mainProgram.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class ModifyClientUpdateInfoBatchResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.ModifyClientUpdateInfoBatchResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.ModifyClientUpdateInfoBatchResponse";
    }

    public java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse> rsps = null;

    public java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse> getRsps()
    {
        return rsps;
    }

    public void  setRsps(java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse> rsps)
    {
        this.rsps = rsps;
    }

    public ModifyClientUpdateInfoBatchResponse()
    {
    }

    public ModifyClientUpdateInfoBatchResponse(java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse> rsps)
    {
        this.rsps = rsps;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ModifyClientUpdateInfoBatchResponse t = (ModifyClientUpdateInfoBatchResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(rsps, t.rsps) );
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
        _os.write(rsps, 0);
    }

    static java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse> cache_rsps;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_rsps)
        {
            cache_rsps = new java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse>();
            com.qq.jce.WCS.ModifyClientUpdateInfoResponse __var_6 = new com.qq.jce.WCS.ModifyClientUpdateInfoResponse();
            ((java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse>)cache_rsps).add(__var_6);
        }
        this.rsps = (java.util.ArrayList<com.qq.jce.WCS.ModifyClientUpdateInfoResponse>) _is.read(cache_rsps, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(rsps, "rsps");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(rsps, false);
    }

}

