// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class DockShowQuantity extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.DockShowQuantity";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.DockShowQuantity";
    }

    public String business = "";

    public String quantity = "";

    public String reserved = "";

    public String getBusiness()
    {
        return business;
    }

    public void  setBusiness(String business)
    {
        this.business = business;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void  setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public DockShowQuantity()
    {
    }

    public DockShowQuantity(String business, String quantity, String reserved)
    {
        this.business = business;
        this.quantity = quantity;
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DockShowQuantity t = (DockShowQuantity) o;
        return (
            com.qq.taf.jce.JceUtil.equals(business, t.business) && 
            com.qq.taf.jce.JceUtil.equals(quantity, t.quantity) && 
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
        _os.write(business, 0);
        _os.write(quantity, 1);
        if (null != reserved)
        {
            _os.write(reserved, 2);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.business =  _is.readString(0, true);
        this.quantity =  _is.readString(1, true);
        this.reserved =  _is.readString(2, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(business, "business");
        _ds.display(quantity, "quantity");
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(business, true);
        _ds.displaySimple(quantity, true);
        _ds.displaySimple(reserved, false);
    }

}

