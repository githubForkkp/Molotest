// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/dock.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class ModifyDockInfoBatchRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.ModifyDockInfoBatchRequest";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.ModifyDockInfoBatchRequest";
    }

    public java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest> reqs = null;

    public java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest> getReqs()
    {
        return reqs;
    }

    public void  setReqs(java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest> reqs)
    {
        this.reqs = reqs;
    }

    public ModifyDockInfoBatchRequest()
    {
    }

    public ModifyDockInfoBatchRequest(java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest> reqs)
    {
        this.reqs = reqs;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ModifyDockInfoBatchRequest t = (ModifyDockInfoBatchRequest) o;
        return (
            com.qq.taf.jce.JceUtil.equals(reqs, t.reqs) );
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
        _os.write(reqs, 0);
    }

    static java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest> cache_reqs;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_reqs)
        {
            cache_reqs = new java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest>();
            com.qq.jce.WCS.ModifyDockInfoRequest __var_7 = new com.qq.jce.WCS.ModifyDockInfoRequest();
            ((java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest>)cache_reqs).add(__var_7);
        }
        this.reqs = (java.util.ArrayList<com.qq.jce.WCS.ModifyDockInfoRequest>) _is.read(cache_reqs, 0, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(reqs, "reqs");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(reqs, false);
    }

}

