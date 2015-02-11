// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/deviceIdentify.jce'
// **********************************************************************

package com.qq.jce.DEVICE_IDENTIFY_SVR;

public final class DeviceIdentifyUnit extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit";
    }

    public String fullClassName()
    {
        return "com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyUnit";
    }

    public boolean bAndroidDevice = true;

    public boolean bStrictedMatched = true;

    public String sProductID = "";

    public boolean getBAndroidDevice()
    {
        return bAndroidDevice;
    }

    public void  setBAndroidDevice(boolean bAndroidDevice)
    {
        this.bAndroidDevice = bAndroidDevice;
    }

    public boolean getBStrictedMatched()
    {
        return bStrictedMatched;
    }

    public void  setBStrictedMatched(boolean bStrictedMatched)
    {
        this.bStrictedMatched = bStrictedMatched;
    }

    public String getSProductID()
    {
        return sProductID;
    }

    public void  setSProductID(String sProductID)
    {
        this.sProductID = sProductID;
    }

    public DeviceIdentifyUnit()
    {
    }

    public DeviceIdentifyUnit(boolean bAndroidDevice, boolean bStrictedMatched, String sProductID)
    {
        this.bAndroidDevice = bAndroidDevice;
        this.bStrictedMatched = bStrictedMatched;
        this.sProductID = sProductID;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        DeviceIdentifyUnit t = (DeviceIdentifyUnit) o;
        return (
            com.qq.taf.jce.JceUtil.equals(bAndroidDevice, t.bAndroidDevice) && 
            com.qq.taf.jce.JceUtil.equals(bStrictedMatched, t.bStrictedMatched) && 
            com.qq.taf.jce.JceUtil.equals(sProductID, t.sProductID) );
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
        _os.write(bAndroidDevice, 0);
        _os.write(bStrictedMatched, 1);
        if (null != sProductID)
        {
            _os.write(sProductID, 2);
        }
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.bAndroidDevice = (boolean) _is.read(bAndroidDevice, 0, true);
        this.bStrictedMatched = (boolean) _is.read(bStrictedMatched, 1, true);
        this.sProductID =  _is.readString(2, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(bAndroidDevice, "bAndroidDevice");
        _ds.display(bStrictedMatched, "bStrictedMatched");
        _ds.display(sProductID, "sProductID");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(bAndroidDevice, true);
        _ds.displaySimple(bStrictedMatched, true);
        _ds.displaySimple(sProductID, false);
    }

}
