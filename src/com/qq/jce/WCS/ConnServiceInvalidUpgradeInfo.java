// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/connServiceInvalid.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class ConnServiceInvalidUpgradeInfo extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.ConnServiceInvalidUpgradeInfo";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo";
    }

    public String sVersion = "";

    public String sUrl = "";

    public String sMd5 = "";

    public String getSVersion()
    {
        return sVersion;
    }

    public void  setSVersion(String sVersion)
    {
        this.sVersion = sVersion;
    }

    public String getSUrl()
    {
        return sUrl;
    }

    public void  setSUrl(String sUrl)
    {
        this.sUrl = sUrl;
    }

    public String getSMd5()
    {
        return sMd5;
    }

    public void  setSMd5(String sMd5)
    {
        this.sMd5 = sMd5;
    }

    public ConnServiceInvalidUpgradeInfo()
    {
    }

    public ConnServiceInvalidUpgradeInfo(String sVersion, String sUrl, String sMd5)
    {
        this.sVersion = sVersion;
        this.sUrl = sUrl;
        this.sMd5 = sMd5;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ConnServiceInvalidUpgradeInfo t = (ConnServiceInvalidUpgradeInfo) o;
        return (
            com.qq.taf.jce.JceUtil.equals(sVersion, t.sVersion) && 
            com.qq.taf.jce.JceUtil.equals(sUrl, t.sUrl) && 
            com.qq.taf.jce.JceUtil.equals(sMd5, t.sMd5) );
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
        _os.write(sVersion, 0);
        _os.write(sUrl, 1);
        _os.write(sMd5, 2);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.sVersion =  _is.readString(0, true);
        this.sUrl =  _is.readString(1, true);
        this.sMd5 =  _is.readString(2, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(sVersion, "sVersion");
        _ds.display(sUrl, "sUrl");
        _ds.display(sMd5, "sMd5");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(sVersion, true);
        _ds.displaySimple(sUrl, true);
        _ds.displaySimple(sMd5, false);
    }

}

