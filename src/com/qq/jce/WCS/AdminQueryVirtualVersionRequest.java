// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wirelessConn.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AdminQueryVirtualVersionRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AdminQueryVirtualVersionRequest";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AdminQueryVirtualVersionRequest";
    }

    public com.qq.jce.WCS.QueryVirtualVersionRequest stReq = null;

    public com.qq.jce.WCS.QueryVirtualVersionRequest getStReq()
    {
        return stReq;
    }

    public void  setStReq(com.qq.jce.WCS.QueryVirtualVersionRequest stReq)
    {
        this.stReq = stReq;
    }

    public AdminQueryVirtualVersionRequest()
    {
    }

    public AdminQueryVirtualVersionRequest(com.qq.jce.WCS.QueryVirtualVersionRequest stReq)
    {
        this.stReq = stReq;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AdminQueryVirtualVersionRequest t = (AdminQueryVirtualVersionRequest) o;
        return (
            com.qq.taf.jce.JceUtil.equals(stReq, t.stReq) );
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
        _os.write(stReq, 0);
    }

    static com.qq.jce.WCS.QueryVirtualVersionRequest cache_stReq;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_stReq)
        {
            cache_stReq = new com.qq.jce.WCS.QueryVirtualVersionRequest();
        }
        this.stReq = (com.qq.jce.WCS.QueryVirtualVersionRequest) _is.read(cache_stReq, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(stReq, "stReq");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(stReq, false);
    }

}

