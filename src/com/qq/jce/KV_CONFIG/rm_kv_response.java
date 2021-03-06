// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/kvConfig.jce'
// **********************************************************************

package com.qq.jce.KV_CONFIG;

public final class rm_kv_response extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "KV_CONFIG.rm_kv_response";
    }

    public String fullClassName()
    {
        return "com.qq.jce.KV_CONFIG.rm_kv_response";
    }

    public int ret_code = 0;

    public String err_msg = "";

    public int getRet_code()
    {
        return ret_code;
    }

    public void  setRet_code(int ret_code)
    {
        this.ret_code = ret_code;
    }

    public String getErr_msg()
    {
        return err_msg;
    }

    public void  setErr_msg(String err_msg)
    {
        this.err_msg = err_msg;
    }

    public rm_kv_response()
    {
    }

    public rm_kv_response(int ret_code, String err_msg)
    {
        this.ret_code = ret_code;
        this.err_msg = err_msg;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        rm_kv_response t = (rm_kv_response) o;
        return (
            com.qq.taf.jce.JceUtil.equals(ret_code, t.ret_code) && 
            com.qq.taf.jce.JceUtil.equals(err_msg, t.err_msg) );
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
        _os.write(ret_code, 0);
        if (null != err_msg)
        {
            _os.write(err_msg, 1);
        }
    }

    static int cache_ret_code;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.ret_code = (int) _is.read(ret_code, 0, true);
        this.err_msg =  _is.readString(1, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(ret_code, "ret_code");
        _ds.display(err_msg, "err_msg");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(ret_code, true);
        _ds.displaySimple(err_msg, false);
    }

}

