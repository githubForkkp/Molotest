// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class MAccessReqHead extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.MAccessReqHead";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.MAccessReqHead";
    }

    public String businessId = "";

    public String cmd = "";

    public String getBusinessId()
    {
        return businessId;
    }

    public void  setBusinessId(String businessId)
    {
        this.businessId = businessId;
    }

    public String getCmd()
    {
        return cmd;
    }

    public void  setCmd(String cmd)
    {
        this.cmd = cmd;
    }

    public MAccessReqHead()
    {
    }

    public MAccessReqHead(String businessId, String cmd)
    {
        this.businessId = businessId;
        this.cmd = cmd;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        MAccessReqHead t = (MAccessReqHead) o;
        return (
            com.qq.taf.jce.JceUtil.equals(businessId, t.businessId) && 
            com.qq.taf.jce.JceUtil.equals(cmd, t.cmd) );
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
        _os.write(businessId, 0);
        _os.write(cmd, 1);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.businessId =  _is.readString(0, true);
        this.cmd =  _is.readString(1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(businessId, "businessId");
        _ds.display(cmd, "cmd");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(businessId, true);
        _ds.displaySimple(cmd, false);
    }

}
