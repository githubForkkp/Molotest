// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class GetAppListReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.GetAppListReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.GetAppListReq";
    }

    public int listType = 0;

    public int pageSize = 0;

    public byte [] contextData = null;

    public int categoryId = 0;

    public long cpId = 0;

    public String pkgName = "";

    public String imei = "";

    public String macAddr = "";

    public int columnId = 0;

    public long authorId = 0;

    public int getListType()
    {
        return listType;
    }

    public void  setListType(int listType)
    {
        this.listType = listType;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void  setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public byte [] getContextData()
    {
        return contextData;
    }

    public void  setContextData(byte [] contextData)
    {
        this.contextData = contextData;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void  setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public long getCpId()
    {
        return cpId;
    }

    public void  setCpId(long cpId)
    {
        this.cpId = cpId;
    }

    public String getPkgName()
    {
        return pkgName;
    }

    public void  setPkgName(String pkgName)
    {
        this.pkgName = pkgName;
    }

    public String getImei()
    {
        return imei;
    }

    public void  setImei(String imei)
    {
        this.imei = imei;
    }

    public String getMacAddr()
    {
        return macAddr;
    }

    public void  setMacAddr(String macAddr)
    {
        this.macAddr = macAddr;
    }

    public int getColumnId()
    {
        return columnId;
    }

    public void  setColumnId(int columnId)
    {
        this.columnId = columnId;
    }

    public long getAuthorId()
    {
        return authorId;
    }

    public void  setAuthorId(long authorId)
    {
        this.authorId = authorId;
    }

    public GetAppListReq()
    {
    }

    public GetAppListReq(int listType, int pageSize, byte [] contextData, int categoryId, long cpId, String pkgName, String imei, String macAddr, int columnId, long authorId)
    {
        this.listType = listType;
        this.pageSize = pageSize;
        this.contextData = contextData;
        this.categoryId = categoryId;
        this.cpId = cpId;
        this.pkgName = pkgName;
        this.imei = imei;
        this.macAddr = macAddr;
        this.columnId = columnId;
        this.authorId = authorId;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetAppListReq t = (GetAppListReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(listType, t.listType) && 
            com.qq.taf.jce.JceUtil.equals(pageSize, t.pageSize) && 
            com.qq.taf.jce.JceUtil.equals(contextData, t.contextData) && 
            com.qq.taf.jce.JceUtil.equals(categoryId, t.categoryId) && 
            com.qq.taf.jce.JceUtil.equals(cpId, t.cpId) && 
            com.qq.taf.jce.JceUtil.equals(pkgName, t.pkgName) && 
            com.qq.taf.jce.JceUtil.equals(imei, t.imei) && 
            com.qq.taf.jce.JceUtil.equals(macAddr, t.macAddr) && 
            com.qq.taf.jce.JceUtil.equals(columnId, t.columnId) && 
            com.qq.taf.jce.JceUtil.equals(authorId, t.authorId) );
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
        _os.write(listType, 0);
        _os.write(pageSize, 1);
        _os.write(contextData, 2);
        _os.write(categoryId, 3);
        _os.write(cpId, 4);
        if (null != pkgName)
        {
            _os.write(pkgName, 5);
        }
        if (null != imei)
        {
            _os.write(imei, 6);
        }
        if (null != macAddr)
        {
            _os.write(macAddr, 7);
        }
        _os.write(columnId, 8);
        _os.write(authorId, 9);
    }

    static byte [] cache_contextData;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.listType = (int) _is.read(listType, 0, true);
        this.pageSize = (int) _is.read(pageSize, 1, true);
        if(null == cache_contextData)
        {
            cache_contextData = (byte[]) new byte[1];
            byte __var_9 = 0;
            ((byte[])cache_contextData)[0] = __var_9;
        }
        this.contextData = (byte []) _is.read(cache_contextData, 2, true);
        this.categoryId = (int) _is.read(categoryId, 3, false);
        this.cpId = (long) _is.read(cpId, 4, false);
        this.pkgName =  _is.readString(5, false);
        this.imei =  _is.readString(6, false);
        this.macAddr =  _is.readString(7, false);
        this.columnId = (int) _is.read(columnId, 8, false);
        this.authorId = (long) _is.read(authorId, 9, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(listType, "listType");
        _ds.display(pageSize, "pageSize");
        _ds.display(contextData, "contextData");
        _ds.display(categoryId, "categoryId");
        _ds.display(cpId, "cpId");
        _ds.display(pkgName, "pkgName");
        _ds.display(imei, "imei");
        _ds.display(macAddr, "macAddr");
        _ds.display(columnId, "columnId");
        _ds.display(authorId, "authorId");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(listType, true);
        _ds.displaySimple(pageSize, true);
        _ds.displaySimple(contextData, true);
        _ds.displaySimple(categoryId, true);
        _ds.displaySimple(cpId, true);
        _ds.displaySimple(pkgName, true);
        _ds.displaySimple(imei, true);
        _ds.displaySimple(macAddr, true);
        _ds.displaySimple(columnId, true);
        _ds.displaySimple(authorId, false);
    }

}

