// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/dock.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class enumAdminOperatingType implements java.io.Serializable
{
    private static enumAdminOperatingType[] __values = new enumAdminOperatingType[4];
    private int __value;
    private String __T = new String();

    public static final int _ADMIN_OPERATING_TYPE_DISABLE = 0;
    public static final enumAdminOperatingType ADMIN_OPERATING_TYPE_DISABLE = new enumAdminOperatingType(0,_ADMIN_OPERATING_TYPE_DISABLE,"ADMIN_OPERATING_TYPE_DISABLE");
    public static final int _ADMIN_OPERATING_TYPE_ENALBE = 1;
    public static final enumAdminOperatingType ADMIN_OPERATING_TYPE_ENALBE = new enumAdminOperatingType(1,_ADMIN_OPERATING_TYPE_ENALBE,"ADMIN_OPERATING_TYPE_ENALBE");
    public static final int _ADMIN_OPERATING_TYPE_REMOVE = 2;
    public static final enumAdminOperatingType ADMIN_OPERATING_TYPE_REMOVE = new enumAdminOperatingType(2,_ADMIN_OPERATING_TYPE_REMOVE,"ADMIN_OPERATING_TYPE_REMOVE");
    public static final int _ADMIN_OPERATING_TYPE_UNAVALIABLE = 3;
    public static final enumAdminOperatingType ADMIN_OPERATING_TYPE_UNAVALIABLE = new enumAdminOperatingType(3,_ADMIN_OPERATING_TYPE_UNAVALIABLE,"ADMIN_OPERATING_TYPE_UNAVALIABLE");

    public static enumAdminOperatingType convert(int val)
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

    public static enumAdminOperatingType convert(String val)
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

    private enumAdminOperatingType(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}