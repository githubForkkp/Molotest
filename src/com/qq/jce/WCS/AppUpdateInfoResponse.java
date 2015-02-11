// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AppUpdateInfoResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AppUpdateInfoResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AppUpdateInfoResponse";
    }

    public int eResultCode = 0;

    public com.qq.jce.MAAccess.GetAppUpdateRsp stRsp = null;

    public java.util.Map<String, com.qq.jce.WCS.AppUpdateStatistics> mStatisticsInfo = null;

    public int getEResultCode()
    {
        return eResultCode;
    }

    public void  setEResultCode(int eResultCode)
    {
        this.eResultCode = eResultCode;
    }

    public com.qq.jce.MAAccess.GetAppUpdateRsp getStRsp()
    {
        return stRsp;
    }

    public void  setStRsp(com.qq.jce.MAAccess.GetAppUpdateRsp stRsp)
    {
        this.stRsp = stRsp;
    }

    public java.util.Map<String, com.qq.jce.WCS.AppUpdateStatistics> getMStatisticsInfo()
    {
        return mStatisticsInfo;
    }

    public void  setMStatisticsInfo(java.util.Map<String, com.qq.jce.WCS.AppUpdateStatistics> mStatisticsInfo)
    {
        this.mStatisticsInfo = mStatisticsInfo;
    }

    public AppUpdateInfoResponse()
    {
    }

    public AppUpdateInfoResponse(int eResultCode, com.qq.jce.MAAccess.GetAppUpdateRsp stRsp, java.util.Map<String, com.qq.jce.WCS.AppUpdateStatistics> mStatisticsInfo)
    {
        this.eResultCode = eResultCode;
        this.stRsp = stRsp;
        this.mStatisticsInfo = mStatisticsInfo;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AppUpdateInfoResponse t = (AppUpdateInfoResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(eResultCode, t.eResultCode) && 
            com.qq.taf.jce.JceUtil.equals(stRsp, t.stRsp) && 
            com.qq.taf.jce.JceUtil.equals(mStatisticsInfo, t.mStatisticsInfo) );
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
        _os.write(stRsp, 1);
        _os.write(mStatisticsInfo, 2);
    }

    static int cache_eResultCode;
    static com.qq.jce.MAAccess.GetAppUpdateRsp cache_stRsp;
    static java.util.Map<String, com.qq.jce.WCS.AppUpdateStatistics> cache_mStatisticsInfo;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.eResultCode = (int) _is.read(eResultCode, 0, true);
        if(null == cache_stRsp)
        {
            cache_stRsp = new com.qq.jce.MAAccess.GetAppUpdateRsp();
        }
        this.stRsp = (com.qq.jce.MAAccess.GetAppUpdateRsp) _is.read(cache_stRsp, 1, true);
        if(null == cache_mStatisticsInfo)
        {
            cache_mStatisticsInfo = new java.util.HashMap<String, com.qq.jce.WCS.AppUpdateStatistics>();
            String __var_37 = "";
            com.qq.jce.WCS.AppUpdateStatistics __var_38 = new com.qq.jce.WCS.AppUpdateStatistics();
            cache_mStatisticsInfo.put(__var_37, __var_38);
        }
        this.mStatisticsInfo = (java.util.Map<String, com.qq.jce.WCS.AppUpdateStatistics>) _is.read(cache_mStatisticsInfo, 2, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(eResultCode, "eResultCode");
        _ds.display(stRsp, "stRsp");
        _ds.display(mStatisticsInfo, "mStatisticsInfo");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(eResultCode, true);
        _ds.displaySimple(stRsp, true);
        _ds.displaySimple(mStatisticsInfo, false);
    }

}

