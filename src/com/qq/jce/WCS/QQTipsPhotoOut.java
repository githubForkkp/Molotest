// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/joycefang/QQTipsjce-web.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class QQTipsPhotoOut extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.QQTipsPhotoOut";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.QQTipsPhotoOut";
    }

    public com.qq.jce.WCS.QQTipsStrategy strategy = null;

    public int threshold = 0;

    public com.qq.jce.WCS.QQTipsStrategy getStrategy()
    {
        return strategy;
    }

    public void  setStrategy(com.qq.jce.WCS.QQTipsStrategy strategy)
    {
        this.strategy = strategy;
    }

    public int getThreshold()
    {
        return threshold;
    }

    public void  setThreshold(int threshold)
    {
        this.threshold = threshold;
    }

    public QQTipsPhotoOut()
    {
    }

    public QQTipsPhotoOut(com.qq.jce.WCS.QQTipsStrategy strategy, int threshold)
    {
        this.strategy = strategy;
        this.threshold = threshold;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        QQTipsPhotoOut t = (QQTipsPhotoOut) o;
        return (
            com.qq.taf.jce.JceUtil.equals(strategy, t.strategy) && 
            com.qq.taf.jce.JceUtil.equals(threshold, t.threshold) );
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
        _os.write(strategy, 0);
        _os.write(threshold, 1);
    }

    static com.qq.jce.WCS.QQTipsStrategy cache_strategy;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_strategy)
        {
            cache_strategy = new com.qq.jce.WCS.QQTipsStrategy();
        }
        this.strategy = (com.qq.jce.WCS.QQTipsStrategy) _is.read(cache_strategy, 0, true);
        this.threshold = (int) _is.read(threshold, 1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(strategy, "strategy");
        _ds.display(threshold, "threshold");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(strategy, true);
        _ds.displaySimple(threshold, false);
    }

}

