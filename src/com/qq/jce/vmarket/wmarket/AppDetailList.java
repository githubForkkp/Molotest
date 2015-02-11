// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class AppDetailList extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.AppDetailList";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.AppDetailList";
    }

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> appDetailList = null;

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> getAppDetailList()
    {
        return appDetailList;
    }

    public void  setAppDetailList(java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> appDetailList)
    {
        this.appDetailList = appDetailList;
    }

    public AppDetailList()
    {
    }

    public AppDetailList(java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> appDetailList)
    {
        this.appDetailList = appDetailList;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AppDetailList t = (AppDetailList) o;
        return (
            com.qq.taf.jce.JceUtil.equals(appDetailList, t.appDetailList) );
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
        _os.write(appDetailList, 0);
    }

    static java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> cache_appDetailList;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_appDetailList)
        {
            cache_appDetailList = new java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail>();
            com.qq.jce.vmarket.wmarket.AppDetail __var_6 = new com.qq.jce.vmarket.wmarket.AppDetail();
            ((java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail>)cache_appDetailList).add(__var_6);
        }
        this.appDetailList = (java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail>) _is.read(cache_appDetailList, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(appDetailList, "appDetailList");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(appDetailList, false);
    }

}

