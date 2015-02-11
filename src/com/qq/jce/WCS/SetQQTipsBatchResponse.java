// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/joycefang/QQTipsjce-web.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class SetQQTipsBatchResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.SetQQTipsBatchResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.SetQQTipsBatchResponse";
    }

    public java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse> vRsps = null;

    public java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse> getVRsps()
    {
        return vRsps;
    }

    public void  setVRsps(java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse> vRsps)
    {
        this.vRsps = vRsps;
    }

    public SetQQTipsBatchResponse()
    {
    }

    public SetQQTipsBatchResponse(java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse> vRsps)
    {
        this.vRsps = vRsps;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        SetQQTipsBatchResponse t = (SetQQTipsBatchResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(vRsps, t.vRsps) );
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
        _os.write(vRsps, 0);
    }

    static java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse> cache_vRsps;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_vRsps)
        {
            cache_vRsps = new java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse>();
            com.qq.jce.WCS.SetQQTipsResponse __var_4 = new com.qq.jce.WCS.SetQQTipsResponse();
            ((java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse>)cache_vRsps).add(__var_4);
        }
        this.vRsps = (java.util.ArrayList<com.qq.jce.WCS.SetQQTipsResponse>) _is.read(cache_vRsps, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(vRsps, "vRsps");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(vRsps, false);
    }

}
