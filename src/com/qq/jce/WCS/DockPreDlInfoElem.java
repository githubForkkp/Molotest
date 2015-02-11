// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/dock.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class DockPreDlInfoElem extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.DockPreDlInfoElem";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.DockPreDlInfoElem";
    }

    public int nSupportType = 0;

    public String sUrl = "";

    public String sMd5 = "";

    public String sVersion = "";

    public String sClientOper = "";

    public int nForceDownload = 0;

    public java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem> vThreshold = null;

    public int getNSupportType()
    {
        return nSupportType;
    }

    public void  setNSupportType(int nSupportType)
    {
        this.nSupportType = nSupportType;
    }

    public String getSUrl()
    {
        return sUrl;
    }

    public void  setSUrl(String sUrl)
    {
        this.sUrl = sUrl;
    }

    public String getSMd5()
    {
        return sMd5;
    }

    public void  setSMd5(String sMd5)
    {
        this.sMd5 = sMd5;
    }

    public String getSVersion()
    {
        return sVersion;
    }

    public void  setSVersion(String sVersion)
    {
        this.sVersion = sVersion;
    }

    public String getSClientOper()
    {
        return sClientOper;
    }

    public void  setSClientOper(String sClientOper)
    {
        this.sClientOper = sClientOper;
    }

    public int getNForceDownload()
    {
        return nForceDownload;
    }

    public void  setNForceDownload(int nForceDownload)
    {
        this.nForceDownload = nForceDownload;
    }

    public java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem> getVThreshold()
    {
        return vThreshold;
    }

    public void  setVThreshold(java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem> vThreshold)
    {
        this.vThreshold = vThreshold;
    }

    public DockPreDlInfoElem()
    {
    }

    public DockPreDlInfoElem(int nSupportType, String sUrl, String sMd5, String sVersion, String sClientOper, int nForceDownload, java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem> vThreshold)
    {
        this.nSupportType = nSupportType;
        this.sUrl = sUrl;
        this.sMd5 = sMd5;
        this.sVersion = sVersion;
        this.sClientOper = sClientOper;
        this.nForceDownload = nForceDownload;
        this.vThreshold = vThreshold;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DockPreDlInfoElem t = (DockPreDlInfoElem) o;
        return (
            com.qq.taf.jce.JceUtil.equals(nSupportType, t.nSupportType) && 
            com.qq.taf.jce.JceUtil.equals(sUrl, t.sUrl) && 
            com.qq.taf.jce.JceUtil.equals(sMd5, t.sMd5) && 
            com.qq.taf.jce.JceUtil.equals(sVersion, t.sVersion) && 
            com.qq.taf.jce.JceUtil.equals(sClientOper, t.sClientOper) && 
            com.qq.taf.jce.JceUtil.equals(nForceDownload, t.nForceDownload) && 
            com.qq.taf.jce.JceUtil.equals(vThreshold, t.vThreshold) );
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
        _os.write(nSupportType, 0);
        _os.write(sUrl, 1);
        _os.write(sMd5, 2);
        _os.write(sVersion, 3);
        _os.write(sClientOper, 4);
        _os.write(nForceDownload, 5);
        _os.write(vThreshold, 6);
    }

    static java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem> cache_vThreshold;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.nSupportType = (int) _is.read(nSupportType, 0, true);
        this.sUrl =  _is.readString(1, true);
        this.sMd5 =  _is.readString(2, true);
        this.sVersion =  _is.readString(3, true);
        this.sClientOper =  _is.readString(4, true);
        this.nForceDownload = (int) _is.read(nForceDownload, 5, true);
        if(null == cache_vThreshold)
        {
            cache_vThreshold = new java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem>();
            com.qq.jce.WCS.FlowThresholdElem __var_13 = new com.qq.jce.WCS.FlowThresholdElem();
            ((java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem>)cache_vThreshold).add(__var_13);
        }
        this.vThreshold = (java.util.ArrayList<com.qq.jce.WCS.FlowThresholdElem>) _is.read(cache_vThreshold, 6, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(nSupportType, "nSupportType");
        _ds.display(sUrl, "sUrl");
        _ds.display(sMd5, "sMd5");
        _ds.display(sVersion, "sVersion");
        _ds.display(sClientOper, "sClientOper");
        _ds.display(nForceDownload, "nForceDownload");
        _ds.display(vThreshold, "vThreshold");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(nSupportType, true);
        _ds.displaySimple(sUrl, true);
        _ds.displaySimple(sMd5, true);
        _ds.displaySimple(sVersion, true);
        _ds.displaySimple(sClientOper, true);
        _ds.displaySimple(nForceDownload, true);
        _ds.displaySimple(vThreshold, false);
    }

}

