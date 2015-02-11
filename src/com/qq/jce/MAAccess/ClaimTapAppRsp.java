// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class ClaimTapAppRsp extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.ClaimTapAppRsp";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.ClaimTapAppRsp";
    }

    public int ret = 0;

    public long lConTapcpid = 0;

    public int getRet()
    {
        return ret;
    }

    public void  setRet(int ret)
    {
        this.ret = ret;
    }

    public long getLConTapcpid()
    {
        return lConTapcpid;
    }

    public void  setLConTapcpid(long lConTapcpid)
    {
        this.lConTapcpid = lConTapcpid;
    }

    public ClaimTapAppRsp()
    {
    }

    public ClaimTapAppRsp(int ret, long lConTapcpid)
    {
        this.ret = ret;
        this.lConTapcpid = lConTapcpid;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ClaimTapAppRsp t = (ClaimTapAppRsp) o;
        return (
            com.qq.taf.jce.JceUtil.equals(ret, t.ret) && 
            com.qq.taf.jce.JceUtil.equals(lConTapcpid, t.lConTapcpid) );
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
        _os.write(ret, 0);
        _os.write(lConTapcpid, 1);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.ret = (int) _is.read(ret, 0, true);
        this.lConTapcpid = (long) _is.read(lConTapcpid, 1, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(ret, "ret");
        _ds.display(lConTapcpid, "lConTapcpid");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(ret, true);
        _ds.displaySimple(lConTapcpid, false);
    }

}

