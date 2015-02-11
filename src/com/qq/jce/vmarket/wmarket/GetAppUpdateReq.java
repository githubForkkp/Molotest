// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class GetAppUpdateReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.GetAppUpdateReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.GetAppUpdateReq";
    }

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate> appInfoForUpdateList = null;

    public int sdkVersionCode = 0;

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate> getAppInfoForUpdateList()
    {
        return appInfoForUpdateList;
    }

    public void  setAppInfoForUpdateList(java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate> appInfoForUpdateList)
    {
        this.appInfoForUpdateList = appInfoForUpdateList;
    }

    public int getSdkVersionCode()
    {
        return sdkVersionCode;
    }

    public void  setSdkVersionCode(int sdkVersionCode)
    {
        this.sdkVersionCode = sdkVersionCode;
    }

    public GetAppUpdateReq()
    {
    }

    public GetAppUpdateReq(java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate> appInfoForUpdateList, int sdkVersionCode)
    {
        this.appInfoForUpdateList = appInfoForUpdateList;
        this.sdkVersionCode = sdkVersionCode;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetAppUpdateReq t = (GetAppUpdateReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(appInfoForUpdateList, t.appInfoForUpdateList) && 
            com.qq.taf.jce.JceUtil.equals(sdkVersionCode, t.sdkVersionCode) );
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
        _os.write(appInfoForUpdateList, 0);
        _os.write(sdkVersionCode, 1);
    }

    static java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate> cache_appInfoForUpdateList;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_appInfoForUpdateList)
        {
            cache_appInfoForUpdateList = new java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate>();
            com.qq.jce.vmarket.wmarket.AppInfoForUpdate __var_45 = new com.qq.jce.vmarket.wmarket.AppInfoForUpdate();
            ((java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate>)cache_appInfoForUpdateList).add(__var_45);
        }
        this.appInfoForUpdateList = (java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppInfoForUpdate>) _is.read(cache_appInfoForUpdateList, 0, true);
        this.sdkVersionCode = (int) _is.read(sdkVersionCode, 1, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(appInfoForUpdateList, "appInfoForUpdateList");
        _ds.display(sdkVersionCode, "sdkVersionCode");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(appInfoForUpdateList, true);
        _ds.displaySimple(sdkVersionCode, false);
    }

}

