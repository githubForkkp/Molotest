// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/dock.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class DockInfoElem extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.DockInfoElem";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.DockInfoElem";
    }

    public String sName = "";

    public byte bZip = 0;

    public String sMd5 = "";

    public String sUrl = "";

    public String getSName()
    {
        return sName;
    }

    public void  setSName(String sName)
    {
        this.sName = sName;
    }

    public byte getBZip()
    {
        return bZip;
    }

    public void  setBZip(byte bZip)
    {
        this.bZip = bZip;
    }

    public String getSMd5()
    {
        return sMd5;
    }

    public void  setSMd5(String sMd5)
    {
        this.sMd5 = sMd5;
    }

    public String getSUrl()
    {
        return sUrl;
    }

    public void  setSUrl(String sUrl)
    {
        this.sUrl = sUrl;
    }

    public DockInfoElem()
    {
    }

    public DockInfoElem(String sName, byte bZip, String sMd5, String sUrl)
    {
        this.sName = sName;
        this.bZip = bZip;
        this.sMd5 = sMd5;
        this.sUrl = sUrl;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DockInfoElem t = (DockInfoElem) o;
        return (
            com.qq.taf.jce.JceUtil.equals(sName, t.sName) && 
            com.qq.taf.jce.JceUtil.equals(bZip, t.bZip) && 
            com.qq.taf.jce.JceUtil.equals(sMd5, t.sMd5) && 
            com.qq.taf.jce.JceUtil.equals(sUrl, t.sUrl) );
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
        _os.write(sName, 0);
        _os.write(bZip, 1);
        _os.write(sMd5, 2);
        _os.write(sUrl, 3);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.sName =  _is.readString(0, true);
        this.bZip = (byte) _is.read(bZip, 1, true);
        this.sMd5 =  _is.readString(2, true);
        this.sUrl =  _is.readString(3, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(sName, "sName");
        _ds.display(bZip, "bZip");
        _ds.display(sMd5, "sMd5");
        _ds.display(sUrl, "sUrl");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(sName, true);
        _ds.displaySimple(bZip, true);
        _ds.displaySimple(sMd5, true);
        _ds.displaySimple(sUrl, false);
    }

}
