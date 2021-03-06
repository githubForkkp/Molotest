// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/connServiceInvalid.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class ModifyConnServiceInvalidRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.ModifyConnServiceInvalidRequest";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.ModifyConnServiceInvalidRequest";
    }

    public com.qq.jce.WCS.AdminRequest stAdminRequestInfo = null;

    public java.util.Map<String, java.util.ArrayList<String>> mapUnit = null;

    public int eInvalidStatus = 0;

    public com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo stUpgradeInfo = null;

    public long lReleaseTime = 0;

    public long lReqCountLimit = 0;

    public int nEnablePeriod = 0;

    public com.qq.jce.WCS.AdminRequest getStAdminRequestInfo()
    {
        return stAdminRequestInfo;
    }

    public void  setStAdminRequestInfo(com.qq.jce.WCS.AdminRequest stAdminRequestInfo)
    {
        this.stAdminRequestInfo = stAdminRequestInfo;
    }

    public java.util.Map<String, java.util.ArrayList<String>> getMapUnit()
    {
        return mapUnit;
    }

    public void  setMapUnit(java.util.Map<String, java.util.ArrayList<String>> mapUnit)
    {
        this.mapUnit = mapUnit;
    }

    public int getEInvalidStatus()
    {
        return eInvalidStatus;
    }

    public void  setEInvalidStatus(int eInvalidStatus)
    {
        this.eInvalidStatus = eInvalidStatus;
    }

    public com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo getStUpgradeInfo()
    {
        return stUpgradeInfo;
    }

    public void  setStUpgradeInfo(com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo stUpgradeInfo)
    {
        this.stUpgradeInfo = stUpgradeInfo;
    }

    public long getLReleaseTime()
    {
        return lReleaseTime;
    }

    public void  setLReleaseTime(long lReleaseTime)
    {
        this.lReleaseTime = lReleaseTime;
    }

    public long getLReqCountLimit()
    {
        return lReqCountLimit;
    }

    public void  setLReqCountLimit(long lReqCountLimit)
    {
        this.lReqCountLimit = lReqCountLimit;
    }

    public int getNEnablePeriod()
    {
        return nEnablePeriod;
    }

    public void  setNEnablePeriod(int nEnablePeriod)
    {
        this.nEnablePeriod = nEnablePeriod;
    }

    public ModifyConnServiceInvalidRequest()
    {
    }

    public ModifyConnServiceInvalidRequest(com.qq.jce.WCS.AdminRequest stAdminRequestInfo, java.util.Map<String, java.util.ArrayList<String>> mapUnit, int eInvalidStatus, com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo stUpgradeInfo, long lReleaseTime, long lReqCountLimit, int nEnablePeriod)
    {
        this.stAdminRequestInfo = stAdminRequestInfo;
        this.mapUnit = mapUnit;
        this.eInvalidStatus = eInvalidStatus;
        this.stUpgradeInfo = stUpgradeInfo;
        this.lReleaseTime = lReleaseTime;
        this.lReqCountLimit = lReqCountLimit;
        this.nEnablePeriod = nEnablePeriod;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ModifyConnServiceInvalidRequest t = (ModifyConnServiceInvalidRequest) o;
        return (
            com.qq.taf.jce.JceUtil.equals(stAdminRequestInfo, t.stAdminRequestInfo) && 
            com.qq.taf.jce.JceUtil.equals(mapUnit, t.mapUnit) && 
            com.qq.taf.jce.JceUtil.equals(eInvalidStatus, t.eInvalidStatus) && 
            com.qq.taf.jce.JceUtil.equals(stUpgradeInfo, t.stUpgradeInfo) && 
            com.qq.taf.jce.JceUtil.equals(lReleaseTime, t.lReleaseTime) && 
            com.qq.taf.jce.JceUtil.equals(lReqCountLimit, t.lReqCountLimit) && 
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
        _os.write(stAdminRequestInfo, 0);
        _os.write(mapUnit, 1);
        _os.write(eInvalidStatus, 2);
        if (null != stUpgradeInfo)
        {
            _os.write(stUpgradeInfo, 3);
        }
        _os.write(lReleaseTime, 4);
        _os.write(lReqCountLimit, 5);
        _os.write(nEnablePeriod, 6);
    }

    static com.qq.jce.WCS.AdminRequest cache_stAdminRequestInfo;
    static java.util.Map<String, java.util.ArrayList<String>> cache_mapUnit;
    static int cache_eInvalidStatus;
    static com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo cache_stUpgradeInfo;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_stAdminRequestInfo)
        {
            cache_stAdminRequestInfo = new com.qq.jce.WCS.AdminRequest();
        }
        this.stAdminRequestInfo = (com.qq.jce.WCS.AdminRequest) _is.read(cache_stAdminRequestInfo, 0, true);
        if(null == cache_mapUnit)
        {
            cache_mapUnit = new java.util.HashMap<String, java.util.ArrayList<String>>();
            String __var_44 = "";
            java.util.ArrayList<String> __var_45 = new java.util.ArrayList<String>();
            String __var_46 = "";
            ((java.util.ArrayList<String>)__var_45).add(__var_46);
            cache_mapUnit.put(__var_44, __var_45);
        }
        this.mapUnit = (java.util.Map<String, java.util.ArrayList<String>>) _is.read(cache_mapUnit, 1, true);
        this.eInvalidStatus = (int) _is.read(eInvalidStatus, 2, true);
        if(null == cache_stUpgradeInfo)
        {
            cache_stUpgradeInfo = new com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo();
        }
        this.stUpgradeInfo = (com.qq.jce.WCS.ConnServiceInvalidUpgradeInfo) _is.read(cache_stUpgradeInfo, 3, false);
        this.lReleaseTime = (long) _is.read(lReleaseTime, 4, false);
        this.lReqCountLimit = (long) _is.read(lReqCountLimit, 5, false);
        this.nEnablePeriod = (int) _is.read(nEnablePeriod, 6, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(stAdminRequestInfo, "stAdminRequestInfo");
        _ds.display(mapUnit, "mapUnit");
        _ds.display(eInvalidStatus, "eInvalidStatus");
        _ds.display(stUpgradeInfo, "stUpgradeInfo");
        _ds.display(lReleaseTime, "lReleaseTime");
        _ds.display(lReqCountLimit, "lReqCountLimit");
        _ds.display(nEnablePeriod, "nEnablePeriod");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(stAdminRequestInfo, true);
        _ds.displaySimple(mapUnit, true);
        _ds.displaySimple(eInvalidStatus, true);
        _ds.displaySimple(stUpgradeInfo, true);
        _ds.displaySimple(lReleaseTime, true);
        _ds.displaySimple(lReqCountLimit, true);
        _ds.displaySimple(nEnablePeriod, false);
    }

}

