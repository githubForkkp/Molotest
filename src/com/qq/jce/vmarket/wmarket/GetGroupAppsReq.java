// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class GetGroupAppsReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.GetGroupAppsReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.GetGroupAppsReq";
    }

    public int type = 0;

    public byte [] contextData = null;

    public int pageSize = 0;

    public int categoryId = 0;

    public int getType()
    {
        return type;
    }

    public void  setType(int type)
    {
        this.type = type;
    }

    public byte [] getContextData()
    {
        return contextData;
    }

    public void  setContextData(byte [] contextData)
    {
        this.contextData = contextData;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void  setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void  setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public GetGroupAppsReq()
    {
    }

    public GetGroupAppsReq(int type, byte [] contextData, int pageSize, int categoryId)
    {
        this.type = type;
        this.contextData = contextData;
        this.pageSize = pageSize;
        this.categoryId = categoryId;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetGroupAppsReq t = (GetGroupAppsReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(type, t.type) && 
            com.qq.taf.jce.JceUtil.equals(contextData, t.contextData) && 
            com.qq.taf.jce.JceUtil.equals(pageSize, t.pageSize) && 
            com.qq.taf.jce.JceUtil.equals(categoryId, t.categoryId) );
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
        _os.write(type, 0);
        if (null != contextData)
        {
            _os.write(contextData, 1);
        }
        _os.write(pageSize, 2);
        _os.write(categoryId, 3);
    }

    static byte [] cache_contextData;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.type = (int) _is.read(type, 0, true);
        if(null == cache_contextData)
        {
            cache_contextData = (byte[]) new byte[1];
            byte __var_38 = 0;
            ((byte[])cache_contextData)[0] = __var_38;
        }
        this.contextData = (byte []) _is.read(cache_contextData, 1, false);
        this.pageSize = (int) _is.read(pageSize, 2, false);
        this.categoryId = (int) _is.read(categoryId, 3, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(type, "type");
        _ds.display(contextData, "contextData");
        _ds.display(pageSize, "pageSize");
        _ds.display(categoryId, "categoryId");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(type, true);
        _ds.displaySimple(contextData, true);
        _ds.displaySimple(pageSize, true);
        _ds.displaySimple(categoryId, false);
    }

}

