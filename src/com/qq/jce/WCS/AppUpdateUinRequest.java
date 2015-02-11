// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AppUpdateUinRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AppUpdateUinRequest";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AppUpdateUinRequest";
    }

    public long lUin = 0;

    public long getLUin()
    {
        return lUin;
    }

    public void  setLUin(long lUin)
    {
        this.lUin = lUin;
    }

    public AppUpdateUinRequest()
    {
    }

    public AppUpdateUinRequest(long lUin)
    {
        this.lUin = lUin;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AppUpdateUinRequest t = (AppUpdateUinRequest) o;
        return (
            com.qq.taf.jce.JceUtil.equals(lUin, t.lUin) );
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
        _os.write(lUin, 0);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.lUin = (long) _is.read(lUin, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(lUin, "lUin");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(lUin, false);
    }

}
