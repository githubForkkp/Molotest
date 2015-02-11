// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/ws.jce'
// **********************************************************************

package com.qq.jce.ws;

public final class RatingInfo extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "ws.RatingInfo";
    }

    public String fullClassName()
    {
        return "com.qq.jce.ws.RatingInfo";
    }

    public long ratingCount = 0;

    public double averageRating = 0;

    public java.util.Map<Integer, Long> ratingDistribution = null;

    public long getRatingCount()
    {
        return ratingCount;
    }

    public void  setRatingCount(long ratingCount)
    {
        this.ratingCount = ratingCount;
    }

    public double getAverageRating()
    {
        return averageRating;
    }

    public void  setAverageRating(double averageRating)
    {
        this.averageRating = averageRating;
    }

    public java.util.Map<Integer, Long> getRatingDistribution()
    {
        return ratingDistribution;
    }

    public void  setRatingDistribution(java.util.Map<Integer, Long> ratingDistribution)
    {
        this.ratingDistribution = ratingDistribution;
    }

    public RatingInfo()
    {
    }

    public RatingInfo(long ratingCount, double averageRating, java.util.Map<Integer, Long> ratingDistribution)
    {
        this.ratingCount = ratingCount;
        this.averageRating = averageRating;
        this.ratingDistribution = ratingDistribution;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        RatingInfo t = (RatingInfo) o;
        return (
            com.qq.taf.jce.JceUtil.equals(ratingCount, t.ratingCount) && 
            com.qq.taf.jce.JceUtil.equals(averageRating, t.averageRating) && 
            com.qq.taf.jce.JceUtil.equals(ratingDistribution, t.ratingDistribution) );
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
        _os.write(ratingCount, 0);
        _os.write(averageRating, 1);
        _os.write(ratingDistribution, 2);
    }

    static java.util.Map<Integer, Long> cache_ratingDistribution;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.ratingCount = (long) _is.read(ratingCount, 0, true);
        this.averageRating = (double) _is.read(averageRating, 1, true);
        if(null == cache_ratingDistribution)
        {
            cache_ratingDistribution = new java.util.HashMap<Integer, Long>();
            Integer __var_1 = 0;
            Long __var_2 = 0L;
            cache_ratingDistribution.put(__var_1, __var_2);
        }
        this.ratingDistribution = (java.util.Map<Integer, Long>) _is.read(cache_ratingDistribution, 2, true);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(ratingCount, "ratingCount");
        _ds.display(averageRating, "averageRating");
        _ds.display(ratingDistribution, "ratingDistribution");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(ratingCount, true);
        _ds.displaySimple(averageRating, true);
        _ds.displaySimple(ratingDistribution, false);
    }

}

