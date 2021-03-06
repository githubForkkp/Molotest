// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class DockSearchHotWord extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.DockSearchHotWord";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.DockSearchHotWord";
    }

    public String searchHotWord = "";

    public String colour = "";

    public String jumpUrl = "";

    public String reserved = "";

    public String getSearchHotWord()
    {
        return searchHotWord;
    }

    public void  setSearchHotWord(String searchHotWord)
    {
        this.searchHotWord = searchHotWord;
    }

    public String getColour()
    {
        return colour;
    }

    public void  setColour(String colour)
    {
        this.colour = colour;
    }

    public String getJumpUrl()
    {
        return jumpUrl;
    }

    public void  setJumpUrl(String jumpUrl)
    {
        this.jumpUrl = jumpUrl;
    }

    public String getReserved()
    {
        return reserved;
    }

    public void  setReserved(String reserved)
    {
        this.reserved = reserved;
    }

    public DockSearchHotWord()
    {
    }

    public DockSearchHotWord(String searchHotWord, String colour, String jumpUrl, String reserved)
    {
        this.searchHotWord = searchHotWord;
        this.colour = colour;
        this.jumpUrl = jumpUrl;
        this.reserved = reserved;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DockSearchHotWord t = (DockSearchHotWord) o;
        return (
            com.qq.taf.jce.JceUtil.equals(searchHotWord, t.searchHotWord) && 
            com.qq.taf.jce.JceUtil.equals(colour, t.colour) && 
            com.qq.taf.jce.JceUtil.equals(jumpUrl, t.jumpUrl) && 
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
        _os.write(searchHotWord, 0);
        _os.write(colour, 1);
        _os.write(jumpUrl, 2);
        if (null != reserved)
        {
            _os.write(reserved, 3);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.searchHotWord =  _is.readString(0, true);
        this.colour =  _is.readString(1, true);
        this.jumpUrl =  _is.readString(2, true);
        this.reserved =  _is.readString(3, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(searchHotWord, "searchHotWord");
        _ds.display(colour, "colour");
        _ds.display(jumpUrl, "jumpUrl");
        _ds.display(reserved, "reserved");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(searchHotWord, true);
        _ds.displaySimple(colour, true);
        _ds.displaySimple(jumpUrl, true);
        _ds.displaySimple(reserved, false);
    }

}

