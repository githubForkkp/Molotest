// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/joycefang/QQTipsjce-web.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class SetQQTipsType implements java.io.Serializable
{
    private static SetQQTipsType[] __values = new SetQQTipsType[3];
    private int __value;
    private String __T = new String();

    public static final int _E_SET_QQTIPS_TYPE_ADD = 0;
    public static final SetQQTipsType E_SET_QQTIPS_TYPE_ADD = new SetQQTipsType(0,_E_SET_QQTIPS_TYPE_ADD,"E_SET_QQTIPS_TYPE_ADD");
    public static final int _E_SET_QQTIPS_TYPE_DEL = 1;
    public static final SetQQTipsType E_SET_QQTIPS_TYPE_DEL = new SetQQTipsType(1,_E_SET_QQTIPS_TYPE_DEL,"E_SET_QQTIPS_TYPE_DEL");
    public static final int _E_SET_QQTIPS_TYPE_UPDATE = 2;
    public static final SetQQTipsType E_SET_QQTIPS_TYPE_UPDATE = new SetQQTipsType(2,_E_SET_QQTIPS_TYPE_UPDATE,"E_SET_QQTIPS_TYPE_UPDATE");

    public static SetQQTipsType convert(int val)
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

    public static SetQQTipsType convert(String val)
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

    private SetQQTipsType(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}