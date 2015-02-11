// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/deviceIdentify.jce'
// **********************************************************************

package com.qq.jce.DEVICE_IDENTIFY_SVR;

public final class DeviceIdentifyRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "DEVICE_IDENTIFY_SVR.DeviceIdentifyRequest";
    }

    public String fullClassName()
    {
        return "com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyRequest";
    }

    public String sPCID = "";

    public java.util.ArrayList<java.util.Map<String, String>> vDeviceInfos = null;

    public String getSPCID()
    {
        return sPCID;
    }

    public void  setSPCID(String sPCID)
    {
        this.sPCID = sPCID;
    }

    public java.util.ArrayList<java.util.Map<String, String>> getVDeviceInfos()
    {
        return vDeviceInfos;
    }

    public void  setVDeviceInfos(java.util.ArrayList<java.util.Map<String, String>> vDeviceInfos)
    {
        this.vDeviceInfos = vDeviceInfos;
    }

    public DeviceIdentifyRequest()
    {
    }

    public DeviceIdentifyRequest(String sPCID, java.util.ArrayList<java.util.Map<String, String>> vDeviceInfos)
    {
        this.sPCID = sPCID;
        this.vDeviceInfos = vDeviceInfos;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DeviceIdentifyRequest t = (DeviceIdentifyRequest) o;
        return (
            com.qq.taf.jce.JceUtil.equals(sPCID, t.sPCID) && 
            com.qq.taf.jce.JceUtil.equals(vDeviceInfos, t.vDeviceInfos) );
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
        _os.write(sPCID, 0);
        _os.write(vDeviceInfos, 1);
    }

    static java.util.ArrayList<java.util.Map<String, String>> cache_vDeviceInfos;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.sPCID =  _is.readString(0, true);
        if(null == cache_vDeviceInfos)
        {
            cache_vDeviceInfos = new java.util.ArrayList<java.util.Map<String, String>>();
            java.util.Map<String, String> __var_1 = new java.util.HashMap<String, String>();
            String __var_2 = "";
            String __var_3 = "";
            __var_1.put(__var_2, __var_3);
            ((java.util.ArrayList<java.util.Map<String, String>>)cache_vDeviceInfos).add(__var_1);
        }
        this.vDeviceInfos = (java.util.ArrayList<java.util.Map<String, String>>) _is.read(cache_vDeviceInfos, 1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(sPCID, "sPCID");
        _ds.display(vDeviceInfos, "vDeviceInfos");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(sPCID, true);
        _ds.displaySimple(vDeviceInfos, false);
    }

}
