// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class MAccessRspHead extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.MAccessRspHead";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.MAccessRspHead";
    }

    public int ret = 0;

    public int getRet()
    {
        return ret;
    }

    public void  setRet(int ret)
    {
        this.ret = ret;
    }

    public MAccessRspHead()
    {
    }

    public MAccessRspHead(int ret)
    {
        this.ret = ret;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        MAccessRspHead t = (MAccessRspHead) o;
        return (
            com.qq.taf.jce.JceUtil.equals(ret, t.ret) );
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
        _os.write(ret, 0);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.ret = (int) _is.read(ret, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(ret, "ret");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(ret, false);
    }

}

