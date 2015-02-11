// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/dock.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class AdminQueryDockPreDlInfoResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.AdminQueryDockPreDlInfoResponse";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.AdminQueryDockPreDlInfoResponse";
    }

    public int eResultCode = 0;

    public java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult> vecRules = null;

    public int getEResultCode()
    {
        return eResultCode;
    }

    public void  setEResultCode(int eResultCode)
    {
        this.eResultCode = eResultCode;
    }

    public java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult> getVecRules()
    {
        return vecRules;
    }

    public void  setVecRules(java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult> vecRules)
    {
        this.vecRules = vecRules;
    }

    public AdminQueryDockPreDlInfoResponse()
    {
    }

    public AdminQueryDockPreDlInfoResponse(int eResultCode, java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult> vecRules)
    {
        this.eResultCode = eResultCode;
        this.vecRules = vecRules;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AdminQueryDockPreDlInfoResponse t = (AdminQueryDockPreDlInfoResponse) o;
        return (
            com.qq.taf.jce.JceUtil.equals(eResultCode, t.eResultCode) && 
            com.qq.taf.jce.JceUtil.equals(vecRules, t.vecRules) );
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
        _os.write(vecRules, 1);
    }

    static int cache_eResultCode;
    static java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult> cache_vecRules;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.eResultCode = (int) _is.read(eResultCode, 0, true);
        if(null == cache_vecRules)
        {
            cache_vecRules = new java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult>();
            com.qq.jce.WCS.AdminDockPreDlInfoResult __var_23 = new com.qq.jce.WCS.AdminDockPreDlInfoResult();
            ((java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult>)cache_vecRules).add(__var_23);
        }
        this.vecRules = (java.util.ArrayList<com.qq.jce.WCS.AdminDockPreDlInfoResult>) _is.read(cache_vecRules, 1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(eResultCode, "eResultCode");
        _ds.display(vecRules, "vecRules");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(eResultCode, true);
        _ds.displaySimple(vecRules, false);
    }

}

