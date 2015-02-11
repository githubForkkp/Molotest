// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class GiftBag extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.GiftBag";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.GiftBag";
    }

    public String picUrl = "";

    public String jumpAddress = "";

    public String jumpType = "";

    public String reserved = "";

    public String getPicUrl()
    {
        return picUrl;
    }

    public void  setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public String getJumpAddress()
    {
        return jumpAddress;
    }

    public void  setJumpAddress(String jumpAddress)
    {
        this.jumpAddress = jumpAddress;
    }

    public String getJumpType()
    {
        return jumpType;
    }

    public void  setJumpType(String jumpType)
    {
        this.jumpType = jumpType;
    }

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public GiftBag()
    {
    }

    public GiftBag(String picUrl, String jumpAddress, String jumpType, String reserved)
    {
        this.picUrl = picUrl;
        this.jumpAddress = jumpAddress;
        this.jumpType = jumpType;
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GiftBag t = (GiftBag) o;
        return (
            com.qq.taf.jce.JceUtil.equals(picUrl, t.picUrl) && 
            com.qq.taf.jce.JceUtil.equals(jumpAddress, t.jumpAddress) && 
            com.qq.taf.jce.JceUtil.equals(jumpType, t.jumpType) && 
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
        _os.write(picUrl, 0);
        _os.write(jumpAddress, 1);
        _os.write(jumpType, 2);
        if (null != reserved)
        {
            _os.write(reserved, 3);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.picUrl =  _is.readString(0, true);
        this.jumpAddress =  _is.readString(1, true);
        this.jumpType =  _is.readString(2, true);
        this.reserved =  _is.readString(3, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(picUrl, "picUrl");
        _ds.display(jumpAddress, "jumpAddress");
        _ds.display(jumpType, "jumpType");
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(picUrl, true);
        _ds.displaySimple(jumpAddress, true);
        _ds.displaySimple(jumpType, true);
        _ds.displaySimple(reserved, false);
    }

}

