// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class GetUnionsReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.GetUnionsReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.GetUnionsReq";
    }

    public int pageNumber = 0;

    public String type = "";

    public String reserved = "";

    public int getPageNumber()
    {
        return pageNumber;
    }

    public void  setPageNumber(int pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    public String getType()
    {
        return type;
    }

    public void  setType(String type)
    {
        this.type = type;
    }

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public GetUnionsReq()
    {
    }

    public GetUnionsReq(int pageNumber, String type, String reserved)
    {
        this.pageNumber = pageNumber;
        this.type = type;
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetUnionsReq t = (GetUnionsReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(pageNumber, t.pageNumber) && 
            com.qq.taf.jce.JceUtil.equals(type, t.type) && 
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
        _os.write(pageNumber, 0);
        _os.write(type, 1);
        if (null != reserved)
        {
            _os.write(reserved, 2);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.pageNumber = (int) _is.read(pageNumber, 0, true);
        this.type =  _is.readString(1, true);
        this.reserved =  _is.readString(2, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(pageNumber, "pageNumber");
        _ds.display(type, "type");
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(pageNumber, true);
        _ds.displaySimple(type, true);
        _ds.displaySimple(reserved, false);
    }

}

