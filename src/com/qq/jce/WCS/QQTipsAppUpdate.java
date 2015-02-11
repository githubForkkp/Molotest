// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/joycefang/QQTipsjce-web.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class QQTipsAppUpdate extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.QQTipsAppUpdate";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.QQTipsAppUpdate";
    }

    public com.qq.jce.WCS.QQTipsStrategy strategy = null;

    public com.qq.jce.WCS.QQTipsStrategy getStrategy()
    {
        return strategy;
    }

    public void  setStrategy(com.qq.jce.WCS.QQTipsStrategy strategy)
    {
        this.strategy = strategy;
    }

    public QQTipsAppUpdate()
    {
    }

    public QQTipsAppUpdate(com.qq.jce.WCS.QQTipsStrategy strategy)
    {
        this.strategy = strategy;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        QQTipsAppUpdate t = (QQTipsAppUpdate) o;
        return (
            com.qq.taf.jce.JceUtil.equals(strategy, t.strategy) );
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
    }

    static com.qq.jce.WCS.QQTipsStrategy cache_strategy;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_strategy)
        {
            cache_strategy = new com.qq.jce.WCS.QQTipsStrategy();
        }
        this.strategy = (com.qq.jce.WCS.QQTipsStrategy) _is.read(cache_strategy, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(strategy, "strategy");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(strategy, false);
    }

}

