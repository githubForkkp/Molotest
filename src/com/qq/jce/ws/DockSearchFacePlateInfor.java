// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class DockSearchFacePlateInfor extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.DockSearchFacePlateInfor";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.DockSearchFacePlateInfor";
    }

    public com.qq.jce.ws.DockSearchBox dockSearchBox = null;

    public java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup> dockSearchHotWordGroups = null;

    public String reserved = "";

    public com.qq.jce.ws.DockSearchBox getDockSearchBox()
    {
        return dockSearchBox;
    }

    public void  setDockSearchBox(com.qq.jce.ws.DockSearchBox dockSearchBox)
    {
        this.dockSearchBox = dockSearchBox;
    }

    public java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup> getDockSearchHotWordGroups()
    {
        return dockSearchHotWordGroups;
    }

    public void  setDockSearchHotWordGroups(java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup> dockSearchHotWordGroups)
    {
        this.dockSearchHotWordGroups = dockSearchHotWordGroups;
    }

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public DockSearchFacePlateInfor()
    {
    }

    public DockSearchFacePlateInfor(com.qq.jce.ws.DockSearchBox dockSearchBox, java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup> dockSearchHotWordGroups, String reserved)
    {
        this.dockSearchBox = dockSearchBox;
        this.dockSearchHotWordGroups = dockSearchHotWordGroups;
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DockSearchFacePlateInfor t = (DockSearchFacePlateInfor) o;
        return (
            com.qq.taf.jce.JceUtil.equals(dockSearchBox, t.dockSearchBox) && 
            com.qq.taf.jce.JceUtil.equals(dockSearchHotWordGroups, t.dockSearchHotWordGroups) && 
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
        _os.write(dockSearchBox, 0);
        _os.write(dockSearchHotWordGroups, 1);
        if (null != reserved)
        {
            _os.write(reserved, 2);
        }
    }

    static com.qq.jce.ws.DockSearchBox cache_dockSearchBox;
    static java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup> cache_dockSearchHotWordGroups;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_dockSearchBox)
        {
            cache_dockSearchBox = new com.qq.jce.ws.DockSearchBox();
        }
        this.dockSearchBox = (com.qq.jce.ws.DockSearchBox) _is.read(cache_dockSearchBox, 0, true);
        if(null == cache_dockSearchHotWordGroups)
        {
            cache_dockSearchHotWordGroups = new java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup>();
            com.qq.jce.ws.DockSearchHotWordGroup __var_8 = new com.qq.jce.ws.DockSearchHotWordGroup();
            ((java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup>)cache_dockSearchHotWordGroups).add(__var_8);
        }
        this.dockSearchHotWordGroups = (java.util.ArrayList<com.qq.jce.ws.DockSearchHotWordGroup>) _is.read(cache_dockSearchHotWordGroups, 1, true);
        this.reserved =  _is.readString(2, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(dockSearchBox, "dockSearchBox");
        _ds.display(dockSearchHotWordGroups, "dockSearchHotWordGroups");
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(dockSearchBox, true);
        _ds.displaySimple(dockSearchHotWordGroups, true);
        _ds.displaySimple(reserved, false);
    }

}

