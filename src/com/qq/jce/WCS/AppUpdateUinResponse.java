// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AppUpdateUinResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AppUpdateUinResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AppUpdateUinResponse";
    }

    public int eResultCode = 0;

    public String sDeviceName = "";

    public java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo> vApps = null;

    public int getEResultCode()
    {
        return eResultCode;
    }

    public void  setEResultCode(int eResultCode)
    {
        this.eResultCode = eResultCode;
    }

    public String getSDeviceName()
    {
        return sDeviceName;
    }

    public void  setSDeviceName(String sDeviceName)
    {
        this.sDeviceName = sDeviceName;
    }

    public java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo> getVApps()
    {
        return vApps;
    }

    public void  setVApps(java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo> vApps)
    {
        this.vApps = vApps;
    }

    public AppUpdateUinResponse()
    {
    }

    public AppUpdateUinResponse(int eResultCode, String sDeviceName, java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo> vApps)
    {
        this.eResultCode = eResultCode;
        this.sDeviceName = sDeviceName;
        this.vApps = vApps;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AppUpdateUinResponse t = (AppUpdateUinResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(eResultCode, t.eResultCode) && 
            com.qq.taf.jce.JceUtil.equals(sDeviceName, t.sDeviceName) && 
            com.qq.taf.jce.JceUtil.equals(vApps, t.vApps) );
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
        _os.write(eResultCode, 0);
        _os.write(sDeviceName, 1);
        _os.write(vApps, 2);
    }

    static int cache_eResultCode;
    static java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo> cache_vApps;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.eResultCode = (int) _is.read(eResultCode, 0, true);
        this.sDeviceName =  _is.readString(1, true);
        if(null == cache_vApps)
        {
            cache_vApps = new java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo>();
            com.qq.jce.WCS.AppUpdateInfo __var_41 = new com.qq.jce.WCS.AppUpdateInfo();
            ((java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo>)cache_vApps).add(__var_41);
        }
        this.vApps = (java.util.ArrayList<com.qq.jce.WCS.AppUpdateInfo>) _is.read(cache_vApps, 2, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(eResultCode, "eResultCode");
        _ds.display(sDeviceName, "sDeviceName");
        _ds.display(vApps, "vApps");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(eResultCode, true);
        _ds.displaySimple(sDeviceName, true);
        _ds.displaySimple(vApps, false);
    }

}

