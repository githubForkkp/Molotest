// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class SearchAppRsp extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.SearchAppRsp";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.SearchAppRsp";
    }

    public int ret = 0;

    public byte [] contextData = null;

    public java.util.ArrayList<String> pkgNameList = null;

    public int correctIndex = -1;

    public java.util.ArrayList<String> correctList = null;

    public byte hasNext = 0;

    public long searchId = 0;

    public int getRet()
    {
        return ret;
    }

    public void  setRet(int ret)
    {
        this.ret = ret;
    }

    public byte [] getContextData()
    {
        return contextData;
    }

    public void  setContextData(byte [] contextData)
    {
        this.contextData = contextData;
    }

    public java.util.ArrayList<String> getPkgNameList()
    {
        return pkgNameList;
    }

    public void  setPkgNameList(java.util.ArrayList<String> pkgNameList)
    {
        this.pkgNameList = pkgNameList;
    }

    public int getCorrectIndex()
    {
        return correctIndex;
    }

    public void  setCorrectIndex(int correctIndex)
    {
        this.correctIndex = correctIndex;
    }

    public java.util.ArrayList<String> getCorrectList()
    {
        return correctList;
    }

    public void  setCorrectList(java.util.ArrayList<String> correctList)
    {
        this.correctList = correctList;
    }

    public byte getHasNext()
    {
        return hasNext;
    }

    public void  setHasNext(byte hasNext)
    {
        this.hasNext = hasNext;
    }

    public long getSearchId()
    {
        return searchId;
    }

    public void  setSearchId(long searchId)
    {
        this.searchId = searchId;
    }

    public SearchAppRsp()
    {
    }

    public SearchAppRsp(int ret, byte [] contextData, java.util.ArrayList<String> pkgNameList, int correctIndex, java.util.ArrayList<String> correctList, byte hasNext, long searchId)
    {
        this.ret = ret;
        this.contextData = contextData;
        this.pkgNameList = pkgNameList;
        this.correctIndex = correctIndex;
        this.correctList = correctList;
        this.hasNext = hasNext;
        this.searchId = searchId;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        SearchAppRsp t = (SearchAppRsp) o;
        return (
            com.qq.taf.jce.JceUtil.equals(ret, t.ret) && 
            com.qq.taf.jce.JceUtil.equals(contextData, t.contextData) && 
            com.qq.taf.jce.JceUtil.equals(pkgNameList, t.pkgNameList) && 
            com.qq.taf.jce.JceUtil.equals(correctIndex, t.correctIndex) && 
            com.qq.taf.jce.JceUtil.equals(correctList, t.correctList) && 
            com.qq.taf.jce.JceUtil.equals(hasNext, t.hasNext) && 
            com.qq.taf.jce.JceUtil.equals(searchId, t.searchId) );
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
        if (null != contextData)
        {
            _os.write(contextData, 1);
        }
        if (null != pkgNameList)
        {
            _os.write(pkgNameList, 2);
        }
        _os.write(correctIndex, 3);
        _os.write(correctList, 4);
        _os.write(hasNext, 5);
        _os.write(searchId, 6);
    }

    static byte [] cache_contextData;
    static java.util.ArrayList<String> cache_pkgNameList;
    static java.util.ArrayList<String> cache_correctList;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.ret = (int) _is.read(ret, 0, true);
        if(null == cache_contextData)
        {
            cache_contextData = (byte[]) new byte[1];
            byte __var_28 = 0;
            ((byte[])cache_contextData)[0] = __var_28;
        }
        this.contextData = (byte []) _is.read(cache_contextData, 1, false);
        if(null == cache_pkgNameList)
        {
            cache_pkgNameList = new java.util.ArrayList<String>();
            String __var_29 = "";
            ((java.util.ArrayList<String>)cache_pkgNameList).add(__var_29);
        }
        this.pkgNameList = (java.util.ArrayList<String>) _is.read(cache_pkgNameList, 2, false);
        this.correctIndex = (int) _is.read(correctIndex, 3, true);
        if(null == cache_correctList)
        {
            cache_correctList = new java.util.ArrayList<String>();
            String __var_30 = "";
            ((java.util.ArrayList<String>)cache_correctList).add(__var_30);
        }
        this.correctList = (java.util.ArrayList<String>) _is.read(cache_correctList, 4, true);
        this.hasNext = (byte) _is.read(hasNext, 5, false);
        this.searchId = (long) _is.read(searchId, 6, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(ret, "ret");
        _ds.display(contextData, "contextData");
        _ds.display(pkgNameList, "pkgNameList");
        _ds.display(correctIndex, "correctIndex");
        _ds.display(correctList, "correctList");
        _ds.display(hasNext, "hasNext");
        _ds.display(searchId, "searchId");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(ret, true);
        _ds.displaySimple(contextData, true);
        _ds.displaySimple(pkgNameList, true);
        _ds.displaySimple(correctIndex, true);
        _ds.displaySimple(correctList, true);
        _ds.displaySimple(hasNext, true);
        _ds.displaySimple(searchId, false);
    }

}
