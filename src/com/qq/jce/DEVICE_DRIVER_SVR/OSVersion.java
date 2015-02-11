// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/deviceDriver.jce'
// **********************************************************************

package com.qq.jce.DEVICE_DRIVER_SVR;

public final class OSVersion implements java.io.Serializable
{
    private static OSVersion[] __values = new OSVersion[3];
    private int __value;
    private String __T = new String();

    public static final int _OV_COMMON = 0;
    public static final OSVersion OV_COMMON = new OSVersion(0,_OV_COMMON,"OV_COMMON");
    public static final int _OV_XP = 1;
    public static final OSVersion OV_XP = new OSVersion(1,_OV_XP,"OV_XP");
    public static final int _OV_WIN7 = 3;
    public static final OSVersion OV_WIN7 = new OSVersion(2,_OV_WIN7,"OV_WIN7");

    public static OSVersion convert(int val)
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

    public static OSVersion convert(String val)
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

    private OSVersion(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}