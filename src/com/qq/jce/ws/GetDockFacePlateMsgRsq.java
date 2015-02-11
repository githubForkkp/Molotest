// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class GetDockFacePlateMsgRsq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.GetDockFacePlateMsgRsq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.GetDockFacePlateMsgRsq";
    }

    public int ret = 0;

    public String msg = "";

    public com.qq.jce.ws.DockRecommands dockRecommands = null;

    public String reserved = "";

    public int getRet()
    {
        return ret;
    }

    public void  setRet(int ret)
    {
        this.ret = ret;
    }

    public String getMsg()
    {
        return msg;
    }

    public void  setMsg(String msg)
    {
        this.msg = msg;
    }

    public com.qq.jce.ws.DockRecommands getDockRecommands()
    {
        return dockRecommands;
    }

    public void  setDockRecommands(com.qq.jce.ws.DockRecommands dockRecommands)
    {
        this.dockRecommands = dockRecommands;
    }

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public GetDockFacePlateMsgRsq()
    {
    }

    public GetDockFacePlateMsgRsq(int ret, String msg, com.qq.jce.ws.DockRecommands dockRecommands, String reserved)
    {
        this.ret = ret;
        this.msg = msg;
        this.dockRecommands = dockRecommands;
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetDockFacePlateMsgRsq t = (GetDockFacePlateMsgRsq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(ret, t.ret) && 
            com.qq.taf.jce.JceUtil.equals(msg, t.msg) && 
            com.qq.taf.jce.JceUtil.equals(dockRecommands, t.dockRecommands) && 
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
        _os.write(ret, 0);
        if (null != msg)
        {
            _os.write(msg, 1);
        }
        if (null != dockRecommands)
        {
            _os.write(dockRecommands, 2);
        }
        if (null != reserved)
        {
            _os.write(reserved, 3);
        }
    }

    static com.qq.jce.ws.DockRecommands cache_dockRecommands;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.ret = (int) _is.read(ret, 0, true);
        this.msg =  _is.readString(1, false);
        if(null == cache_dockRecommands)
        {
            cache_dockRecommands = new com.qq.jce.ws.DockRecommands();
        }
        this.dockRecommands = (com.qq.jce.ws.DockRecommands) _is.read(cache_dockRecommands, 2, false);
        this.reserved =  _is.readString(3, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(ret, "ret");
        _ds.display(msg, "msg");
        _ds.display(dockRecommands, "dockRecommands");
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(ret, true);
        _ds.displaySimple(msg, true);
        _ds.displaySimple(dockRecommands, true);
        _ds.displaySimple(reserved, false);
    }

}

