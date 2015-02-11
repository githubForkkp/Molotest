// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class SnapshotsPic extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.SnapshotsPic";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.SnapshotsPic";
    }

    public String originalUrl = "";

    public String size550Url = "";

    public String size330Url = "";

    public String getOriginalUrl()
    {
        return originalUrl;
    }

    public void  setOriginalUrl(String originalUrl)
    {
        this.originalUrl = originalUrl;
    }

    public String getSize550Url()
    {
        return size550Url;
    }

    public void  setSize550Url(String size550Url)
    {
        this.size550Url = size550Url;
    }

    public String getSize330Url()
    {
        return size330Url;
    }

    public void  setSize330Url(String size330Url)
    {
        this.size330Url = size330Url;
    }

    public SnapshotsPic()
    {
    }

    public SnapshotsPic(String originalUrl, String size550Url, String size330Url)
    {
        this.originalUrl = originalUrl;
        this.size550Url = size550Url;
        this.size330Url = size330Url;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        SnapshotsPic t = (SnapshotsPic) o;
        return (
            com.qq.taf.jce.JceUtil.equals(originalUrl, t.originalUrl) && 
            com.qq.taf.jce.JceUtil.equals(size550Url, t.size550Url) && 
            com.qq.taf.jce.JceUtil.equals(size330Url, t.size330Url) );
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
        if (null != originalUrl)
        {
            _os.write(originalUrl, 0);
        }
        if (null != size550Url)
        {
            _os.write(size550Url, 1);
        }
        if (null != size330Url)
        {
            _os.write(size330Url, 2);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.originalUrl =  _is.readString(0, false);
        this.size550Url =  _is.readString(1, false);
        this.size330Url =  _is.readString(2, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(originalUrl, "originalUrl");
        _ds.display(size550Url, "size550Url");
        _ds.display(size330Url, "size330Url");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(originalUrl, true);
        _ds.displaySimple(size550Url, true);
        _ds.displaySimple(size330Url, false);
    }

}

