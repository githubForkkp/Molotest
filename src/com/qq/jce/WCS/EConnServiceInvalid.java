// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/connServiceInvalid.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class EConnServiceInvalid implements java.io.Serializable
{
    private static EConnServiceInvalid[] __values = new EConnServiceInvalid[2];
    private int __value;
    private String __T = new String();

    public static final int _E_CONN_SERVICE_INVALIDE = 0;
    public static final EConnServiceInvalid E_CONN_SERVICE_INVALIDE = new EConnServiceInvalid(0,_E_CONN_SERVICE_INVALIDE,"E_CONN_SERVICE_INVALIDE");
    public static final int _E_CONN_SERVICE_UPGRADE = 1;
    public static final EConnServiceInvalid E_CONN_SERVICE_UPGRADE = new EConnServiceInvalid(1,_E_CONN_SERVICE_UPGRADE,"E_CONN_SERVICE_UPGRADE");

    public static EConnServiceInvalid convert(int val)
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

    public static EConnServiceInvalid convert(String val)
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

    private EConnServiceInvalid(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}
