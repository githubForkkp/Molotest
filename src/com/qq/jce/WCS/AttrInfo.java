// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/dock.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AttrInfo extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AttrInfo";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AttrInfo";
    }

    public String sName = "";

    public String sValue = "";

    public int nDefault = 0;

    public String getSName()
    {
        return sName;
    }

    public void  setSName(String sName)
    {
        this.sName = sName;
    }

    public String getSValue()
    {
        return sValue;
    }

    public void  setSValue(String sValue)
    {
        this.sValue = sValue;
    }

    public int getNDefault()
    {
        return nDefault;
    }

    public void  setNDefault(int nDefault)
    {
        this.nDefault = nDefault;
    }

    public AttrInfo()
    {
    }

    public AttrInfo(String sName, String sValue, int nDefault)
    {
        this.sName = sName;
        this.sValue = sValue;
        this.nDefault = nDefault;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AttrInfo t = (AttrInfo) o;
        return (
            com.qq.taf.jce.JceUtil.equals(sName, t.sName) && 
            com.qq.taf.jce.JceUtil.equals(sValue, t.sValue) && 
            com.qq.taf.jce.JceUtil.equals(nDefault, t.nDefault) );
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
        _os.write(sValue, 1);
        _os.write(nDefault, 2);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.sName =  _is.readString(0, true);
        this.sValue =  _is.readString(1, true);
        this.nDefault = (int) _is.read(nDefault, 2, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(sName, "sName");
        _ds.display(sValue, "sValue");
        _ds.display(nDefault, "nDefault");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(sName, true);
        _ds.displaySimple(sValue, true);
        _ds.displaySimple(nDefault, false);
    }

}

