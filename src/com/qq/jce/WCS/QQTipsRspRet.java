// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/joycefang/QQTipsjce-web.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class QQTipsRspRet implements java.io.Serializable
{
    private static QQTipsRspRet[] __values = new QQTipsRspRet[13];
    private int __value;
    private String __T = new String();

    public static final int _E_QQTIPS_RSP_OK = 0;
    public static final QQTipsRspRet E_QQTIPS_RSP_OK = new QQTipsRspRet(0,_E_QQTIPS_RSP_OK,"E_QQTIPS_RSP_OK");
    public static final int _E_QQTIPS_RSP_FAILED = 1;
    public static final QQTipsRspRet E_QQTIPS_RSP_FAILED = new QQTipsRspRet(1,_E_QQTIPS_RSP_FAILED,"E_QQTIPS_RSP_FAILED");
    public static final int _E_QQTIPS_RSP_SET_NOT_ALLOWED = 2;
    public static final QQTipsRspRet E_QQTIPS_RSP_SET_NOT_ALLOWED = new QQTipsRspRet(2,_E_QQTIPS_RSP_SET_NOT_ALLOWED,"E_QQTIPS_RSP_SET_NOT_ALLOWED");
    public static final int _E_QQTIPS_RSP_SET_UNKONWN = 3;
    public static final QQTipsRspRet E_QQTIPS_RSP_SET_UNKONWN = new QQTipsRspRet(3,_E_QQTIPS_RSP_SET_UNKONWN,"E_QQTIPS_RSP_SET_UNKONWN");
    public static final int _E_QQTIPS_RSP_ADD_SPECIFY_IDX = 4;
    public static final QQTipsRspRet E_QQTIPS_RSP_ADD_SPECIFY_IDX = new QQTipsRspRet(4,_E_QQTIPS_RSP_ADD_SPECIFY_IDX,"E_QQTIPS_RSP_ADD_SPECIFY_IDX");
    public static final int _E_QQTIPS_RSP_ADD_SUCC = 5;
    public static final QQTipsRspRet E_QQTIPS_RSP_ADD_SUCC = new QQTipsRspRet(5,_E_QQTIPS_RSP_ADD_SUCC,"E_QQTIPS_RSP_ADD_SUCC");
    public static final int _E_QQTIPS_RSP_ADD_FAILED = 6;
    public static final QQTipsRspRet E_QQTIPS_RSP_ADD_FAILED = new QQTipsRspRet(6,_E_QQTIPS_RSP_ADD_FAILED,"E_QQTIPS_RSP_ADD_FAILED");
    public static final int _E_QQTIPS_RSP_DEL_NOT_FOUND = 7;
    public static final QQTipsRspRet E_QQTIPS_RSP_DEL_NOT_FOUND = new QQTipsRspRet(7,_E_QQTIPS_RSP_DEL_NOT_FOUND,"E_QQTIPS_RSP_DEL_NOT_FOUND");
    public static final int _E_QQTIPS_RSP_DEL_SUCC = 8;
    public static final QQTipsRspRet E_QQTIPS_RSP_DEL_SUCC = new QQTipsRspRet(8,_E_QQTIPS_RSP_DEL_SUCC,"E_QQTIPS_RSP_DEL_SUCC");
    public static final int _E_QQTIPS_RSP_DEL_FAILED = 9;
    public static final QQTipsRspRet E_QQTIPS_RSP_DEL_FAILED = new QQTipsRspRet(9,_E_QQTIPS_RSP_DEL_FAILED,"E_QQTIPS_RSP_DEL_FAILED");
    public static final int _E_QQTIPS_RSP_UPDATE_NOT_FOUND = 10;
    public static final QQTipsRspRet E_QQTIPS_RSP_UPDATE_NOT_FOUND = new QQTipsRspRet(10,_E_QQTIPS_RSP_UPDATE_NOT_FOUND,"E_QQTIPS_RSP_UPDATE_NOT_FOUND");
    public static final int _E_QQTIPS_RSP_UPDATE_SUCC = 11;
    public static final QQTipsRspRet E_QQTIPS_RSP_UPDATE_SUCC = new QQTipsRspRet(11,_E_QQTIPS_RSP_UPDATE_SUCC,"E_QQTIPS_RSP_UPDATE_SUCC");
    public static final int _E_QQTIPS_RSP_UPDATE_FAILED = 12;
    public static final QQTipsRspRet E_QQTIPS_RSP_UPDATE_FAILED = new QQTipsRspRet(12,_E_QQTIPS_RSP_UPDATE_FAILED,"E_QQTIPS_RSP_UPDATE_FAILED");

    public static QQTipsRspRet convert(int val)
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

    public static QQTipsRspRet convert(String val)
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

    private QQTipsRspRet(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}
