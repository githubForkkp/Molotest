// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class GetIndexUnionsReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.GetIndexUnionsReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.GetIndexUnionsReq";
    }

    public String reserved = "";

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public GetIndexUnionsReq()
    {
    }

    public GetIndexUnionsReq(String reserved)
    {
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetIndexUnionsReq t = (GetIndexUnionsReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(reserved, t.reserved) );
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
        if (null != reserved)
        {
            _os.write(reserved, 0);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.reserved =  _is.readString(0, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(reserved, false);
    }

}

