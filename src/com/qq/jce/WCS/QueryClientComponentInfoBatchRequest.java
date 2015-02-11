// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/mainProgram.jce'
// **********************************************************************

package com.qq.jce.WCS;

public final class QueryClientComponentInfoBatchRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "WCS.QueryClientComponentInfoBatchRequest";
    }

    public String fullClassName()
    {
        return "com.qq.jce.WCS.QueryClientComponentInfoBatchRequest";
    }

    public java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest> reqs = null;

    public java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest> getReqs()
    {
        return reqs;
    }

    public void  setReqs(java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest> reqs)
    {
        this.reqs = reqs;
    }

    public QueryClientComponentInfoBatchRequest()
    {
    }

    public QueryClientComponentInfoBatchRequest(java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest> reqs)
    {
        this.reqs = reqs;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        QueryClientComponentInfoBatchRequest t = (QueryClientComponentInfoBatchRequest) o;
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

    static java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest> cache_reqs;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        if(null == cache_reqs)
        {
            cache_reqs = new java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest>();
            com.qq.jce.WCS.QueryClientComponentInfoRequest __var_12 = new com.qq.jce.WCS.QueryClientComponentInfoRequest();
            ((java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest>)cache_reqs).add(__var_12);
        }
        this.reqs = (java.util.ArrayList<com.qq.jce.WCS.QueryClientComponentInfoRequest>) _is.read(cache_reqs, 0, true);
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

