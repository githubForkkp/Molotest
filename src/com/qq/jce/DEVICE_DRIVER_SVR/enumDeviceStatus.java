// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/deviceDriver.jce'
// **********************************************************************

package com.qq.jce.DEVICE_DRIVER_SVR;

public final class enumDeviceStatus implements java.io.Serializable
{
    private static enumDeviceStatus[] __values = new enumDeviceStatus[2];
    private int __value;
    private String __T = new String();

    public static final int _DEVICE_STATUS_INACTIVE = 0;
    public static final enumDeviceStatus DEVICE_STATUS_INACTIVE = new enumDeviceStatus(0,_DEVICE_STATUS_INACTIVE,"DEVICE_STATUS_INACTIVE");
    public static final int _DEVICE_STATUS_ACTIVE = 1;
    public static final enumDeviceStatus DEVICE_STATUS_ACTIVE = new enumDeviceStatus(1,_DEVICE_STATUS_ACTIVE,"DEVICE_STATUS_ACTIVE");

    public static enumDeviceStatus convert(int val)
    {
        for(int __i = 0; __i < __values.length; ++__i)
        {
            if(__values[__i].value() == val)
            {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public static enumDeviceStatus convert(String val)
    {
        for(int __i = 0; __i < __values.length; ++__i)
        {
            if(__values[__i].toString().equals(val))
            {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public int value()
    {
        return __value;
    }

    public String toString()
    {
        return __T;
    }

    private enumDeviceStatus(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}
