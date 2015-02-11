// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/mainProgram.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class ModifyClientUpdateInfoRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.ModifyClientUpdateInfoRequest";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.ModifyClientUpdateInfoRequest";
    }

    public java.util.Map<String, java.util.ArrayList<String>> mapUnit = null;

    public com.qq.jce.WCS.AdminRequest stAdminRequestInfo = null;

    public String sDownloadUrl = "";

    public String sUpdateVersion = "";

    public String sInstallParam = "";

    public String sRegKey = "";

    public int eUpdateType = 0;

    public String sReleaseNoteUrl = "";

    public String sMd5 = "";

    public int ePackType = 0;

    public String sAlias = "";

    public long lReleaseTime = 0;

    public java.util.Map<String, java.util.ArrayList<String>> getMapUnit()
    {
        return mapUnit;
    }

    public void  setMapUnit(java.util.Map<String, java.util.ArrayList<String>> mapUnit)
    {
        this.mapUnit = mapUnit;
    }

    public com.qq.jce.WCS.AdminRequest getStAdminRequestInfo()
    {
        return stAdminRequestInfo;
    }

    public void  setStAdminRequestInfo(com.qq.jce.WCS.AdminRequest stAdminRequestInfo)
    {
        this.stAdminRequestInfo = stAdminRequestInfo;
    }

    public String getSDownloadUrl()
    {
        return sDownloadUrl;
    }

    public void  setSDownloadUrl(String sDownloadUrl)
    {
        this.sDownloadUrl = sDownloadUrl;
    }

    public String getSUpdateVersion()
    {
        return sUpdateVersion;
    }

    public void  setSUpdateVersion(String sUpdateVersion)
    {
        this.sUpdateVersion = sUpdateVersion;
    }

    public String getSInstallParam()
    {
        return sInstallParam;
    }

    public void  setSInstallParam(String sInstallParam)
    {
        this.sInstallParam = sInstallParam;
    }

    public String getSRegKey()
    {
        return sRegKey;
    }

    public void  setSRegKey(String sRegKey)
    {
        this.sRegKey = sRegKey;
    }

    public int getEUpdateType()
    {
        return eUpdateType;
    }

    public void  setEUpdateType(int eUpdateType)
    {
        this.eUpdateType = eUpdateType;
    }

    public String getSReleaseNoteUrl()
    {
        return sReleaseNoteUrl;
    }

    public void  setSReleaseNoteUrl(String sReleaseNoteUrl)
    {
        this.sReleaseNoteUrl = sReleaseNoteUrl;
    }

    public String getSMd5()
    {
        return sMd5;
    }

    public void  setSMd5(String sMd5)
    {
        this.sMd5 = sMd5;
    }

    public int getEPackType()
    {
        return ePackType;
    }

    public void  setEPackType(int ePackType)
    {
        this.ePackType = ePackType;
    }

    public String getSAlias()
    {
        return sAlias;
    }

    public void  setSAlias(String sAlias)
    {
        this.sAlias = sAlias;
    }

    public long getLReleaseTime()
    {
        return lReleaseTime;
    }

    public void  setLReleaseTime(long lReleaseTime)
    {
        this.lReleaseTime = lReleaseTime;
    }

    public ModifyClientUpdateInfoRequest()
    {
    }

    public ModifyClientUpdateInfoRequest(java.util.Map<String, java.util.ArrayList<String>> mapUnit, com.qq.jce.WCS.AdminRequest stAdminRequestInfo, String sDownloadUrl, String sUpdateVersion, String sInstallParam, String sRegKey, int eUpdateType, String sReleaseNoteUrl, String sMd5, int ePackType, String sAlias, long lReleaseTime)
    {
        this.mapUnit = mapUnit;
        this.stAdminRequestInfo = stAdminRequestInfo;
        this.sDownloadUrl = sDownloadUrl;
        this.sUpdateVersion = sUpdateVersion;
        this.sInstallParam = sInstallParam;
        this.sRegKey = sRegKey;
        this.eUpdateType = eUpdateType;
        this.sReleaseNoteUrl = sReleaseNoteUrl;
        this.sMd5 = sMd5;
        this.ePackType = ePackType;
        this.sAlias = sAlias;
        this.lReleaseTime = lReleaseTime;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ModifyClientUpdateInfoRequest t = (ModifyClientUpdateInfoRequest) o;
        return (
            com.qq.taf.jce.JceUtil.equals(mapUnit, t.mapUnit) && 
            com.qq.taf.jce.JceUtil.equals(stAdminRequestInfo, t.stAdminRequestInfo) && 
            com.qq.taf.jce.JceUtil.equals(sDownloadUrl, t.sDownloadUrl) && 
            com.qq.taf.jce.JceUtil.equals(sUpdateVersion, t.sUpdateVersion) && 
            com.qq.taf.jce.JceUtil.equals(sInstallParam, t.sInstallParam) && 
            com.qq.taf.jce.JceUtil.equals(sRegKey, t.sRegKey) && 
            com.qq.taf.jce.JceUtil.equals(eUpdateType, t.eUpdateType) && 
            com.qq.taf.jce.JceUtil.equals(sReleaseNoteUrl, t.sReleaseNoteUrl) && 
            com.qq.taf.jce.JceUtil.equals(sMd5, t.sMd5) && 
            com.qq.taf.jce.JceUtil.equals(ePackType, t.ePackType) && 
            com.qq.taf.jce.JceUtil.equals(sAlias, t.sAlias) && 
            com.qq.taf.jce.JceUtil.equals(lReleaseTime, t.lReleaseTime) );
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
        _os.write(stAdminRequestInfo, 1);
        _os.write(sDownloadUrl, 2);
        _os.write(sUpdateVersion, 3);
        _os.write(sInstallParam, 4);
        _os.write(sRegKey, 5);
        _os.write(eUpdateType, 6);
        _os.write(sReleaseNoteUrl, 7);
        _os.write(sMd5, 8);
        _os.write(ePackType, 9);
        _os.write(sAlias, 10);
        _os.write(lReleaseTime, 11);
    }

    static java.util.Map<String, java.util.ArrayList<String>> cache_mapUnit;
    static com.qq.jce.WCS.AdminRequest cache_stAdminRequestInfo;
    static int cache_eUpdateType;
    static int cache_ePackType;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_mapUnit)
        {
            cache_mapUnit = new java.util.HashMap<String, java.util.ArrayList<String>>();
            String __var_2 = "";
            java.util.ArrayList<String> __var_3 = new java.util.ArrayList<String>();
            String __var_4 = "";
            ((java.util.ArrayList<String>)__var_3).add(__var_4);
            cache_mapUnit.put(__var_2, __var_3);
        }
        this.mapUnit = (java.util.Map<String, java.util.ArrayList<String>>) _is.read(cache_mapUnit, 0, true);
        if(null == cache_stAdminRequestInfo)
        {
            cache_stAdminRequestInfo = new com.qq.jce.WCS.AdminRequest();
        }
        this.stAdminRequestInfo = (com.qq.jce.WCS.AdminRequest) _is.read(cache_stAdminRequestInfo, 1, true);
        this.sDownloadUrl =  _is.readString(2, true);
        this.sUpdateVersion =  _is.readString(3, true);
        this.sInstallParam =  _is.readString(4, true);
        this.sRegKey =  _is.readString(5, true);
        this.eUpdateType = (int) _is.read(eUpdateType, 6, true);
        this.sReleaseNoteUrl =  _is.readString(7, true);
        this.sMd5 =  _is.readString(8, true);
        this.ePackType = (int) _is.read(ePackType, 9, true);
        this.sAlias =  _is.readString(10, true);
        this.lReleaseTime = (long) _is.read(lReleaseTime, 11, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(mapUnit, "mapUnit");
        _ds.display(stAdminRequestInfo, "stAdminRequestInfo");
        _ds.display(sDownloadUrl, "sDownloadUrl");
        _ds.display(sUpdateVersion, "sUpdateVersion");
        _ds.display(sInstallParam, "sInstallParam");
        _ds.display(sRegKey, "sRegKey");
        _ds.display(eUpdateType, "eUpdateType");
        _ds.display(sReleaseNoteUrl, "sReleaseNoteUrl");
        _ds.display(sMd5, "sMd5");
        _ds.display(ePackType, "ePackType");
        _ds.display(sAlias, "sAlias");
        _ds.display(lReleaseTime, "lReleaseTime");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(mapUnit, true);
        _ds.displaySimple(stAdminRequestInfo, true);
        _ds.displaySimple(sDownloadUrl, true);
        _ds.displaySimple(sUpdateVersion, true);
        _ds.displaySimple(sInstallParam, true);
        _ds.displaySimple(sRegKey, true);
        _ds.displaySimple(eUpdateType, true);
        _ds.displaySimple(sReleaseNoteUrl, true);
        _ds.displaySimple(sMd5, true);
        _ds.displaySimple(ePackType, true);
        _ds.displaySimple(sAlias, true);
        _ds.displaySimple(lReleaseTime, false);
    }

}
