// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class Video extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.Video";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.Video";
    }

    public String picUrl = "";

    public String playUrl = "";

    public String getPicUrl()
    {
        return picUrl;
    }

    public void  setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public String getPlayUrl()
    {
        return playUrl;
    }

    public void  setPlayUrl(String playUrl)
    {
        this.playUrl = playUrl;
    }

    public Video()
    {
    }

    public Video(String picUrl, String playUrl)
    {
        this.picUrl = picUrl;
        this.playUrl = playUrl;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        Video t = (Video) o;
        return (
            com.qq.taf.jce.JceUtil.equals(picUrl, t.picUrl) && 
            com.qq.taf.jce.JceUtil.equals(playUrl, t.playUrl) );
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
        _os.write(picUrl, 0);
        _os.write(playUrl, 1);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.picUrl =  _is.readString(0, true);
        this.playUrl =  _is.readString(1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(picUrl, "picUrl");
        _ds.display(playUrl, "playUrl");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(picUrl, true);
        _ds.displaySimple(playUrl, false);
    }

}
