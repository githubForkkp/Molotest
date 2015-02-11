// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/deviceDriver.jce'
// **********************************************************************

package com.qq.jce.DEVICE_DRIVER_SVR;

public final class DeviceType implements java.io.Serializable
{
    private static DeviceType[] __values = new DeviceType[4];
    private int __value;
    private String __T = new String();

    public static final int _DEVICE_TYPE_UNKNOWN = 0;
    public static final DeviceType DEVICE_TYPE_UNKNOWN = new DeviceType(0,_DEVICE_TYPE_UNKNOWN,"DEVICE_TYPE_UNKNOWN");
    public static final int _DEVICE_TYPE_PC = 1;
    public static final DeviceType DEVICE_TYPE_PC = new DeviceType(1,_DEVICE_TYPE_PC,"DEVICE_TYPE_PC");
    public static final int _DEVICE_TYPE_ANDROID = 2;
    public static final DeviceType DEVICE_TYPE_ANDROID = new DeviceType(2,_DEVICE_TYPE_ANDROID,"DEVICE_TYPE_ANDROID");
    public static final int _DEVICE_TYPE_WEB = 3;
    public static final DeviceType DEVICE_TYPE_WEB = new DeviceType(3,_DEVICE_TYPE_WEB,"DEVICE_TYPE_WEB");

    public static DeviceType convert(int val)
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

    public static DeviceType convert(String val)
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

    private DeviceType(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}