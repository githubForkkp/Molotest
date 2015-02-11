// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class VerifySignatureReq extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.VerifySignatureReq";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.VerifySignatureReq";
    }

    public String packageName = "";

    public String signature = "";

    public String getPackageName()
    {
        return packageName;
    }

    public void  setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    public String getSignature()
    {
        return signature;
    }

    public void  setSignature(String signature)
    {
        this.signature = signature;
    }

    public VerifySignatureReq()
    {
    }

    public VerifySignatureReq(String packageName, String signature)
    {
        this.packageName = packageName;
        this.signature = signature;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        VerifySignatureReq t = (VerifySignatureReq) o;
        return (
            com.qq.taf.jce.JceUtil.equals(packageName, t.packageName) && 
            com.qq.taf.jce.JceUtil.equals(signature, t.signature) );
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
        _os.write(packageName, 0);
        _os.write(signature, 1);
    }


    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.packageName =  _is.readString(0, true);
        this.signature =  _is.readString(1, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(packageName, "packageName");
        _ds.display(signature, "signature");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(packageName, true);
        _ds.displaySimple(signature, false);
    }

}
