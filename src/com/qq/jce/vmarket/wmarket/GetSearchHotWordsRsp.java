// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/wmarket.jce'
// **********************************************************************

package com.qq.jce.vmarket.wmarket;

public final class GetSearchHotWordsRsp extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "wmarket.GetSearchHotWordsRsp";
    }

    public String fullClassName()
    {
        return "com.qq.jce.vmarket.wmarket.GetSearchHotWordsRsp";
    }

    public int ret = 0;

    public String msg = "";

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord> hotWords = null;

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

    public java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord> getHotWords()
    {
        return hotWords;
    }

    public void  setHotWords(java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord> hotWords)
    {
        this.hotWords = hotWords;
    }

    public GetSearchHotWordsRsp()
    {
    }

    public GetSearchHotWordsRsp(int ret, String msg, java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord> hotWords)
    {
        this.ret = ret;
        this.msg = msg;
        this.hotWords = hotWords;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetSearchHotWordsRsp t = (GetSearchHotWordsRsp) o;
        return (
            com.qq.taf.jce.JceUtil.equals(ret, t.ret) && 
            com.qq.taf.jce.JceUtil.equals(msg, t.msg) && 
            com.qq.taf.jce.JceUtil.equals(hotWords, t.hotWords) );
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
        if (null != hotWords)
        {
            _os.write(hotWords, 2);
        }
    }

    static java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord> cache_hotWords;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.ret = (int) _is.read(ret, 0, true);
        this.msg =  _is.readString(1, false);
        if(null == cache_hotWords)
        {
            cache_hotWords = new java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord>();
            com.qq.jce.vmarket.wmarket.HotWord __var_27 = new com.qq.jce.vmarket.wmarket.HotWord();
            ((java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord>)cache_hotWords).add(__var_27);
        }
        this.hotWords = (java.util.ArrayList<com.qq.jce.vmarket.wmarket.HotWord>) _is.read(cache_hotWords, 2, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(ret, "ret");
        _ds.display(msg, "msg");
        _ds.display(hotWords, "hotWords");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(ret, true);
        _ds.displaySimple(msg, true);
        _ds.displaySimple(hotWords, false);
    }

}

