// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/connServiceInvalid.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class ModifyUpdateInfoResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.ModifyUpdateInfoResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.ModifyUpdateInfoResponse";
    }

    public int eResultCode = 0;

    public long uiRuleIndex = 0;

    public int getEResultCode()
    {
        return eResultCode;
    }

    public void  setEResultCode(int eResultCode)
    {
        this.eResultCode = eResultCode;
    }

    public long getUiRuleIndex()
    {
        return uiRuleIndex;
    }

    public void  setUiRuleIndex(long uiRuleIndex)
    {
        this.uiRuleIndex = uiRuleIndex;
    }

    public ModifyUpdateInfoResponse()
    {
    }

    public ModifyUpdateInfoResponse(int eResultCode, long uiRuleIndex)
    {
        this.eResultCode = eResultCode;
        this.uiRuleIndex = uiRuleIndex;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ModifyUpdateInfoResponse t = (ModifyUpdateInfoResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(eResultCode, t.eResultCode) && 
            com.qq.taf.jce.JceUtil.equals(uiRuleIndex, t.uiRuleIndex) );
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
        _os.write(eResultCode, 0);
        _os.write(uiRuleIndex, 1);
    }

    static int cache_eResultCode;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.eResultCode = (int) _is.read(eResultCode, 0, true);
        this.uiRuleIndex = (long) _is.read(uiRuleIndex, 1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(eResultCode, "eResultCode");
        _ds.display(uiRuleIndex, "uiRuleIndex");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(eResultCode, true);
        _ds.displaySimple(uiRuleIndex, false);
    }

}

