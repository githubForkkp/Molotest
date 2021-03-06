// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/connServiceInvalid.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AdminComponentInfoResult extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AdminComponentInfoResult";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AdminComponentInfoResult";
    }

    public java.util.Map<String, java.util.ArrayList<String>> mapUnit = null;

    public com.qq.jce.WCS.QueryComponentInfoResponse stRule = null;

    public long uiRuleIndex = 0;

    public int eStatus = 0;

    public java.util.Map<String, java.util.ArrayList<String>> getMapUnit()
    {
        return mapUnit;
    }

    public void  setMapUnit(java.util.Map<String, java.util.ArrayList<String>> mapUnit)
    {
        this.mapUnit = mapUnit;
    }

    public com.qq.jce.WCS.QueryComponentInfoResponse getStRule()
    {
        return stRule;
    }

    public void  setStRule(com.qq.jce.WCS.QueryComponentInfoResponse stRule)
    {
        this.stRule = stRule;
    }

    public long getUiRuleIndex()
    {
        return uiRuleIndex;
    }

    public void  setUiRuleIndex(long uiRuleIndex)
    {
        this.uiRuleIndex = uiRuleIndex;
    }

    public int getEStatus()
    {
        return eStatus;
    }

    public void  setEStatus(int eStatus)
    {
        this.eStatus = eStatus;
    }

    public AdminComponentInfoResult()
    {
    }

    public AdminComponentInfoResult(java.util.Map<String, java.util.ArrayList<String>> mapUnit, com.qq.jce.WCS.QueryComponentInfoResponse stRule, long uiRuleIndex, int eStatus)
    {
        this.mapUnit = mapUnit;
        this.stRule = stRule;
        this.uiRuleIndex = uiRuleIndex;
        this.eStatus = eStatus;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AdminComponentInfoResult t = (AdminComponentInfoResult) o;
        return (
            com.qq.taf.jce.JceUtil.equals(mapUnit, t.mapUnit) && 
            com.qq.taf.jce.JceUtil.equals(stRule, t.stRule) && 
            com.qq.taf.jce.JceUtil.equals(uiRuleIndex, t.uiRuleIndex) && 
            com.qq.taf.jce.JceUtil.equals(eStatus, t.eStatus) );
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
        _os.write(mapUnit, 0);
        _os.write(stRule, 1);
        _os.write(uiRuleIndex, 2);
        _os.write(eStatus, 3);
    }

    static java.util.Map<String, java.util.ArrayList<String>> cache_mapUnit;
    static com.qq.jce.WCS.QueryComponentInfoResponse cache_stRule;
    static int cache_eStatus;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_mapUnit)
        {
            cache_mapUnit = new java.util.HashMap<String, java.util.ArrayList<String>>();
            String __var_31 = "";
            java.util.ArrayList<String> __var_32 = new java.util.ArrayList<String>();
            String __var_33 = "";
            ((java.util.ArrayList<String>)__var_32).add(__var_33);
            cache_mapUnit.put(__var_31, __var_32);
        }
        this.mapUnit = (java.util.Map<String, java.util.ArrayList<String>>) _is.read(cache_mapUnit, 0, true);
        if(null == cache_stRule)
        {
            cache_stRule = new com.qq.jce.WCS.QueryComponentInfoResponse();
        }
        this.stRule = (com.qq.jce.WCS.QueryComponentInfoResponse) _is.read(cache_stRule, 1, true);
        this.uiRuleIndex = (long) _is.read(uiRuleIndex, 2, true);
        this.eStatus = (int) _is.read(eStatus, 3, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(mapUnit, "mapUnit");
        _ds.display(stRule, "stRule");
        _ds.display(uiRuleIndex, "uiRuleIndex");
        _ds.display(eStatus, "eStatus");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(mapUnit, true);
        _ds.displaySimple(stRule, true);
        _ds.displaySimple(uiRuleIndex, true);
        _ds.displaySimple(eStatus, false);
    }

}

