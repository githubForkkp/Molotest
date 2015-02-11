// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/deviceIdentify.jce'
// **********************************************************************

package com.qq.jce.DEVICE_IDENTIFY_SVR;

public final class DeviceIdentifyResult extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "DEVICE_IDENTIFY_SVR.DeviceIdentifyResult";
    }

    public String fullClassName()
    {
        return "com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyResult";
    }

    public String sDeviceAllKey = "";

    public com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit stUnit = null;

    public String getSDeviceAllKey()
    {
        return sDeviceAllKey;
    }

    public void  setSDeviceAllKey(String sDeviceAllKey)
    {
        this.sDeviceAllKey = sDeviceAllKey;
    }

    public com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit getStUnit()
    {
        return stUnit;
    }

    public void  setStUnit(com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit stUnit)
    {
        this.stUnit = stUnit;
    }

    public DeviceIdentifyResult()
    {
    }

    public DeviceIdentifyResult(String sDeviceAllKey, com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit stUnit)
    {
        this.sDeviceAllKey = sDeviceAllKey;
        this.stUnit = stUnit;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DeviceIdentifyResult t = (DeviceIdentifyResult) o;
        return (
            com.qq.taf.jce.JceUtil.equals(sDeviceAllKey, t.sDeviceAllKey) && 
            com.qq.taf.jce.JceUtil.equals(stUnit, t.stUnit) );
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
        _os.write(sDeviceAllKey, 0);
        _os.write(stUnit, 1);
    }

    static com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit cache_stUnit;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.sDeviceAllKey =  _is.readString(0, true);
        if(null == cache_stUnit)
        {
            cache_stUnit = new com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit();
        }
        this.stUnit = (com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit) _is.read(cache_stUnit, 1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(sDeviceAllKey, "sDeviceAllKey");
        _ds.display(stUnit, "stUnit");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(sDeviceAllKey, true);
        _ds.displaySimple(stUnit, false);
    }

}

