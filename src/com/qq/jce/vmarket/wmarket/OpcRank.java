// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class OpcRank extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.OpcRank";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.OpcRank";
    }

    public int id = 0;

    public int rankType = 0;

    public String title = "";

    public String icon = "";

    public String description = "";

    public int opcType = 0;

    public int order = 0;

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> appList = null;

    public int getId()
    {
        return id;
    }

    public void  setId(int id)
    {
        this.id = id;
    }

    public int getRankType()
    {
        return rankType;
    }

    public void  setRankType(int rankType)
    {
        this.rankType = rankType;
    }

    public String getTitle()
    {
        return title;
    }

    public void  setTitle(String title)
    {
        this.title = title;
    }

    public String getIcon()
    {
        return icon;
    }

    public void  setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getDescription()
    {
        return description;
    }

    public void  setDescription(String description)
    {
        this.description = description;
    }

    public int getOpcType()
    {
        return opcType;
    }

    public void  setOpcType(int opcType)
    {
        this.opcType = opcType;
    }

    public int getOrder()
    {
        return order;
    }

    public void  setOrder(int order)
    {
        this.order = order;
    }

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> getAppList()
    {
        return appList;
    }

    public void  setAppList(java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> appList)
    {
        this.appList = appList;
    }

    public OpcRank()
    {
    }

    public OpcRank(int id, int rankType, String title, String icon, String description, int opcType, int order, java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> appList)
    {
        this.id = id;
        this.rankType = rankType;
        this.title = title;
        this.icon = icon;
        this.description = description;
        this.opcType = opcType;
        this.order = order;
        this.appList = appList;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        OpcRank t = (OpcRank) o;
        return (
            com.qq.taf.jce.JceUtil.equals(id, t.id) && 
            com.qq.taf.jce.JceUtil.equals(rankType, t.rankType) && 
            com.qq.taf.jce.JceUtil.equals(title, t.title) && 
            com.qq.taf.jce.JceUtil.equals(icon, t.icon) && 
            com.qq.taf.jce.JceUtil.equals(description, t.description) && 
            com.qq.taf.jce.JceUtil.equals(opcType, t.opcType) && 
            com.qq.taf.jce.JceUtil.equals(order, t.order) && 
            com.qq.taf.jce.JceUtil.equals(appList, t.appList) );
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
        _os.write(id, 0);
        _os.write(rankType, 1);
        if (null != title)
        {
            _os.write(title, 2);
        }
        if (null != icon)
        {
            _os.write(icon, 3);
        }
        if (null != description)
        {
            _os.write(description, 4);
        }
        _os.write(opcType, 5);
        _os.write(order, 6);
        if (null != appList)
        {
            _os.write(appList, 7);
        }
    }

    static java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail> cache_appList;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.id = (int) _is.read(id, 0, true);
        this.rankType = (int) _is.read(rankType, 1, true);
        this.title =  _is.readString(2, false);
        this.icon =  _is.readString(3, false);
        this.description =  _is.readString(4, false);
        this.opcType = (int) _is.read(opcType, 5, false);
        this.order = (int) _is.read(order, 6, false);
        if(null == cache_appList)
        {
            cache_appList = new java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail>();
            com.qq.jce.vmarket.wmarket.AppDetail __var_42 = new com.qq.jce.vmarket.wmarket.AppDetail();
            ((java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail>)cache_appList).add(__var_42);
        }
        this.appList = (java.util.ArrayList<com.qq.jce.vmarket.wmarket.AppDetail>) _is.read(cache_appList, 7, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(id, "id");
        _ds.display(rankType, "rankType");
        _ds.display(title, "title");
        _ds.display(icon, "icon");
        _ds.display(description, "description");
        _ds.display(opcType, "opcType");
        _ds.display(order, "order");
        _ds.display(appList, "appList");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(id, true);
        _ds.displaySimple(rankType, true);
        _ds.displaySimple(title, true);
        _ds.displaySimple(icon, true);
        _ds.displaySimple(description, true);
        _ds.displaySimple(opcType, true);
        _ds.displaySimple(order, true);
        _ds.displaySimple(appList, false);
    }

}
