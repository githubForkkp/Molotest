// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class SetWhiteListReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.SetWhiteListReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.SetWhiteListReq";
    }

    public String pkgName = "";

    public byte verifyType = 0;

    public byte authPlatform = 0;

    public String verifyCode = "";

    public String appId = "";

    public String getPkgName()
    {
        return pkgName;
    }

    public void  setPkgName(String pkgName)
    {
        this.pkgName = pkgName;
    }

    public byte getVerifyType()
    {
        return verifyType;
    }

    public void  setVerifyType(byte verifyType)
    {
        this.verifyType = verifyType;
    }

    public byte getAuthPlatform()
    {
        return authPlatform;
    }

    public void  setAuthPlatform(byte authPlatform)
    {
        this.authPlatform = authPlatform;
    }

    public String getVerifyCode()
    {
        return verifyCode;
    }

    public void  setVerifyCode(String verifyCode)
    {
        this.verifyCode = verifyCode;
    }

    public String getAppId()
    {
        return appId;
    }

    public void  setAppId(String appId)
    {
        this.appId = appId;
    }

    public SetWhiteListReq()
    {
    }

    public SetWhiteListReq(String pkgName, byte verifyType, byte authPlatform, String verifyCode, String appId)
    {
        this.pkgName = pkgName;
        this.verifyType = verifyType;
        this.authPlatform = authPlatform;
        this.verifyCode = verifyCode;
        this.appId = appId;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        SetWhiteListReq t = (SetWhiteListReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(pkgName, t.pkgName) && 
            com.qq.taf.jce.JceUtil.equals(verifyType, t.verifyType) && 
            com.qq.taf.jce.JceUtil.equals(authPlatform, t.authPlatform) && 
            com.qq.taf.jce.JceUtil.equals(verifyCode, t.verifyCode) && 
            com.qq.taf.jce.JceUtil.equals(appId, t.appId) );
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
        if (null != pkgName)
        {
            _os.write(pkgName, 0);
        }
        _os.write(verifyType, 1);
        _os.write(authPlatform, 2);
        if (null != verifyCode)
        {
            _os.write(verifyCode, 3);
        }
        if (null != appId)
        {
            _os.write(appId, 4);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.pkgName =  _is.readString(0, false);
        this.verifyType = (byte) _is.read(verifyType, 1, true);
        this.authPlatform = (byte) _is.read(authPlatform, 2, false);
        this.verifyCode =  _is.readString(3, false);
        this.appId =  _is.readString(4, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(pkgName, "pkgName");
        _ds.display(verifyType, "verifyType");
        _ds.display(authPlatform, "authPlatform");
        _ds.display(verifyCode, "verifyCode");
        _ds.display(appId, "appId");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(pkgName, true);
        _ds.displaySimple(verifyType, true);
        _ds.displaySimple(authPlatform, true);
        _ds.displaySimple(verifyCode, true);
        _ds.displaySimple(appId, false);
    }

}

