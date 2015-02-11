// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class GetDockFacePlateMsgReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.GetDockFacePlateMsgReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.GetDockFacePlateMsgReq";
    }

    public String dockVersion = "";

    public String yybPcVersion = "";

    public String pcid = "";

    public String reserved = "";

    public String getDockVersion()
    {
        return dockVersion;
    }

    public void  setDockVersion(String dockVersion)
    {
        this.dockVersion = dockVersion;
    }

    public String getYybPcVersion()
    {
        return yybPcVersion;
    }

    public void  setYybPcVersion(String yybPcVersion)
    {
        this.yybPcVersion = yybPcVersion;
    }

    public String getPcid()
    {
        return pcid;
    }

    public void  setPcid(String pcid)
    {
        this.pcid = pcid;
    }

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public GetDockFacePlateMsgReq()
    {
    }

    public GetDockFacePlateMsgReq(String dockVersion, String yybPcVersion, String pcid, String reserved)
    {
        this.dockVersion = dockVersion;
        this.yybPcVersion = yybPcVersion;
        this.pcid = pcid;
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetDockFacePlateMsgReq t = (GetDockFacePlateMsgReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(dockVersion, t.dockVersion) && 
            com.qq.taf.jce.JceUtil.equals(yybPcVersion, t.yybPcVersion) && 
            com.qq.taf.jce.JceUtil.equals(pcid, t.pcid) && 
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
        _os.write(dockVersion, 0);
        if (null != yybPcVersion)
        {
            _os.write(yybPcVersion, 1);
        }
        _os.write(pcid, 2);
        if (null != reserved)
        {
            _os.write(reserved, 3);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.dockVersion =  _is.readString(0, true);
        this.yybPcVersion =  _is.readString(1, false);
        this.pcid =  _is.readString(2, true);
        this.reserved =  _is.readString(3, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(dockVersion, "dockVersion");
        _ds.display(yybPcVersion, "yybPcVersion");
        _ds.display(pcid, "pcid");
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(dockVersion, true);
        _ds.displaySimple(yybPcVersion, true);
        _ds.displaySimple(pcid, true);
        _ds.displaySimple(reserved, false);
    }

}

