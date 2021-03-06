// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class AppHotWord extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.AppHotWord";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.AppHotWord";
    }

    public String word = "";

    public int rankDelta = 0;

    public String getWord()
    {
        return word;
    }

    public void  setWord(String word)
    {
        this.word = word;
    }

    public int getRankDelta()
    {
        return rankDelta;
    }

    public void  setRankDelta(int rankDelta)
    {
        this.rankDelta = rankDelta;
    }

    public AppHotWord()
    {
    }

    public AppHotWord(String word, int rankDelta)
    {
        this.word = word;
        this.rankDelta = rankDelta;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AppHotWord t = (AppHotWord) o;
        return (
            com.qq.taf.jce.JceUtil.equals(word, t.word) && 
            com.qq.taf.jce.JceUtil.equals(rankDelta, t.rankDelta) );
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
        if (null != word)
        {
            _os.write(word, 0);
        }
        _os.write(rankDelta, 1);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.word =  _is.readString(0, false);
        this.rankDelta = (int) _is.read(rankDelta, 1, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(word, "word");
        _ds.display(rankDelta, "rankDelta");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(word, true);
        _ds.displaySimple(rankDelta, false);
    }

}

