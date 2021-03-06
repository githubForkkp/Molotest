// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/connServiceInvalid.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class QueryComponentInfoResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.QueryComponentInfoResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.QueryComponentInfoResponse";
    }

    public int eResultCode = 0;

    public String sMsg = "";

    public java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo> vecComponents = null;

    public long lReleaseTime = 0;

    public String sRuleDesc = "";

    public long lUpdateLimit = 0;

    public int nEnablePeriod = 0;

    public int getEResultCode()
    {
        return eResultCode;
    }

    public void  setEResultCode(int eResultCode)
    {
        this.eResultCode = eResultCode;
    }

    public String getSMsg()
    {
        return sMsg;
    }

    public void  setSMsg(String sMsg)
    {
        this.sMsg = sMsg;
    }

    public java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo> getVecComponents()
    {
        return vecComponents;
    }

    public void  setVecComponents(java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo> vecComponents)
    {
        this.vecComponents = vecComponents;
    }

    public long getLReleaseTime()
    {
        return lReleaseTime;
    }

    public void  setLReleaseTime(long lReleaseTime)
    {
        this.lReleaseTime = lReleaseTime;
    }

    public String getSRuleDesc()
    {
        return sRuleDesc;
    }

    public void  setSRuleDesc(String sRuleDesc)
    {
        this.sRuleDesc = sRuleDesc;
    }

    public long getLUpdateLimit()
    {
        return lUpdateLimit;
    }

    public void  setLUpdateLimit(long lUpdateLimit)
    {
        this.lUpdateLimit = lUpdateLimit;
    }

    public int getNEnablePeriod()
    {
        return nEnablePeriod;
    }

    public void  setNEnablePeriod(int nEnablePeriod)
    {
        this.nEnablePeriod = nEnablePeriod;
    }

    public QueryComponentInfoResponse()
    {
    }

    public QueryComponentInfoResponse(int eResultCode, String sMsg, java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo> vecComponents, long lReleaseTime, String sRuleDesc, long lUpdateLimit, int nEnablePeriod)
    {
        this.eResultCode = eResultCode;
        this.sMsg = sMsg;
        this.vecComponents = vecComponents;
        this.lReleaseTime = lReleaseTime;
        this.sRuleDesc = sRuleDesc;
        this.lUpdateLimit = lUpdateLimit;
        this.nEnablePeriod = nEnablePeriod;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        QueryComponentInfoResponse t = (QueryComponentInfoResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(eResultCode, t.eResultCode) && 
            com.qq.taf.jce.JceUtil.equals(sMsg, t.sMsg) && 
            com.qq.taf.jce.JceUtil.equals(vecComponents, t.vecComponents) && 
            com.qq.taf.jce.JceUtil.equals(lReleaseTime, t.lReleaseTime) && 
            com.qq.taf.jce.JceUtil.equals(sRuleDesc, t.sRuleDesc) && 
            com.qq.taf.jce.JceUtil.equals(lUpdateLimit, t.lUpdateLimit) && 
            com.qq.taf.jce.JceUtil.equals(nEnablePeriod, t.nEnablePeriod) );
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
        _os.write(sMsg, 1);
        _os.write(vecComponents, 2);
        _os.write(lReleaseTime, 3);
        if (null != sRuleDesc)
        {
            _os.write(sRuleDesc, 4);
        }
        _os.write(lUpdateLimit, 5);
        _os.write(nEnablePeriod, 6);
    }

    static int cache_eResultCode;
    static java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo> cache_vecComponents;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.eResultCode = (int) _is.read(eResultCode, 0, true);
        this.sMsg =  _is.readString(1, true);
        if(null == cache_vecComponents)
        {
            cache_vecComponents = new java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo>();
            com.qq.jce.WCS.ComponentUnitInfo __var_14 = new com.qq.jce.WCS.ComponentUnitInfo();
            ((java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo>)cache_vecComponents).add(__var_14);
        }
        this.vecComponents = (java.util.ArrayList<com.qq.jce.WCS.ComponentUnitInfo>) _is.read(cache_vecComponents, 2, true);
        this.lReleaseTime = (long) _is.read(lReleaseTime, 3, false);
        this.sRuleDesc =  _is.readString(4, false);
        this.lUpdateLimit = (long) _is.read(lUpdateLimit, 5, false);
        this.nEnablePeriod = (int) _is.read(nEnablePeriod, 6, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(eResultCode, "eResultCode");
        _ds.display(sMsg, "sMsg");
        _ds.display(vecComponents, "vecComponents");
        _ds.display(lReleaseTime, "lReleaseTime");
        _ds.display(sRuleDesc, "sRuleDesc");
        _ds.display(lUpdateLimit, "lUpdateLimit");
        _ds.display(nEnablePeriod, "nEnablePeriod");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(eResultCode, true);
        _ds.displaySimple(sMsg, true);
        _ds.displaySimple(vecComponents, true);
        _ds.displaySimple(lReleaseTime, true);
        _ds.displaySimple(sRuleDesc, true);
        _ds.displaySimple(lUpdateLimit, true);
        _ds.displaySimple(nEnablePeriod, false);
    }

}

