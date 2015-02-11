// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 3.0.0.34 by WSRD Tencent.
// Generated from `/usr/local/resin_system.mqq.com/webapps/communication/taf/upload/noahyang/you.jce'
// **********************************************************************

package com.qq.jce.MAAccess;

public final class AppDetail extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "MAAccess.AppDetail";
    }

    public String fullClassName()
    {
        return "com.qq.jce.MAAccess.AppDetail";
    }

    public String pkgName = "";

    public String appName = "";

    public String iconUrl = "";

    public String apkUrl = "";

    public long fileSize = 0;

    public int versionCode = 0;

    public String versionName = "";

    public long appDownCount = 0;

    public com.qq.jce.MAAccess.RatingInfo appRating = null;

    public com.qq.jce.MAAccess.RatingInfo apkRating = null;

    public long flag = 0;

    public int minSdkVersion = 0;

    public long appId = 0;

    public String description = "";

    public String newFeature = "";

    public java.util.ArrayList<String> permissions = null;

    public String editorIntro = "";

    public java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic> snapshotsUrl = null;

    public java.util.ArrayList<com.qq.jce.MAAccess.Video> videoList = null;

    public long apkId = 0;

    public long authorId = 0;

    public String authorName = "";

    public long apkPublishTime = 0;

    public long categoryId = 0;

    public String categoryName = "";

    public String englishName = "";

    public String signatureMd5 = "";

    public String getPkgName()
    {
        return pkgName;
    }

    public void  setPkgName(String pkgName)
    {
        this.pkgName = pkgName;
    }

    public String getAppName()
    {
        return appName;
    }

    public void  setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getIconUrl()
    {
        return iconUrl;
    }

    public void  setIconUrl(String iconUrl)
    {
        this.iconUrl = iconUrl;
    }

    public String getApkUrl()
    {
        return apkUrl;
    }

    public void  setApkUrl(String apkUrl)
    {
        this.apkUrl = apkUrl;
    }

    public long getFileSize()
    {
        return fileSize;
    }

    public void  setFileSize(long fileSize)
    {
        this.fileSize = fileSize;
    }

    public int getVersionCode()
    {
        return versionCode;
    }

    public void  setVersionCode(int versionCode)
    {
        this.versionCode = versionCode;
    }

    public String getVersionName()
    {
        return versionName;
    }

    public void  setVersionName(String versionName)
    {
        this.versionName = versionName;
    }

    public long getAppDownCount()
    {
        return appDownCount;
    }

    public void  setAppDownCount(long appDownCount)
    {
        this.appDownCount = appDownCount;
    }

    public com.qq.jce.MAAccess.RatingInfo getAppRating()
    {
        return appRating;
    }

    public void  setAppRating(com.qq.jce.MAAccess.RatingInfo appRating)
    {
        this.appRating = appRating;
    }

    public com.qq.jce.MAAccess.RatingInfo getApkRating()
    {
        return apkRating;
    }

    public void  setApkRating(com.qq.jce.MAAccess.RatingInfo apkRating)
    {
        this.apkRating = apkRating;
    }

    public long getFlag()
    {
        return flag;
    }

    public void  setFlag(long flag)
    {
        this.flag = flag;
    }

    public int getMinSdkVersion()
    {
        return minSdkVersion;
    }

    public void  setMinSdkVersion(int minSdkVersion)
    {
        this.minSdkVersion = minSdkVersion;
    }

    public long getAppId()
    {
        return appId;
    }

    public void  setAppId(long appId)
    {
        this.appId = appId;
    }

    public String getDescription()
    {
        return description;
    }

    public void  setDescription(String description)
    {
        this.description = description;
    }

    public String getNewFeature()
    {
        return newFeature;
    }

    public void  setNewFeature(String newFeature)
    {
        this.newFeature = newFeature;
    }

    public java.util.ArrayList<String> getPermissions()
    {
        return permissions;
    }

    public void  setPermissions(java.util.ArrayList<String> permissions)
    {
        this.permissions = permissions;
    }

    public String getEditorIntro()
    {
        return editorIntro;
    }

    public void  setEditorIntro(String editorIntro)
    {
        this.editorIntro = editorIntro;
    }

    public java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic> getSnapshotsUrl()
    {
        return snapshotsUrl;
    }

    public void  setSnapshotsUrl(java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic> snapshotsUrl)
    {
        this.snapshotsUrl = snapshotsUrl;
    }

    public java.util.ArrayList<com.qq.jce.MAAccess.Video> getVideoList()
    {
        return videoList;
    }

    public void  setVideoList(java.util.ArrayList<com.qq.jce.MAAccess.Video> videoList)
    {
        this.videoList = videoList;
    }

    public long getApkId()
    {
        return apkId;
    }

    public void  setApkId(long apkId)
    {
        this.apkId = apkId;
    }

    public long getAuthorId()
    {
        return authorId;
    }

    public void  setAuthorId(long authorId)
    {
        this.authorId = authorId;
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public void  setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    public long getApkPublishTime()
    {
        return apkPublishTime;
    }

    public void  setApkPublishTime(long apkPublishTime)
    {
        this.apkPublishTime = apkPublishTime;
    }

    public long getCategoryId()
    {
        return categoryId;
    }

    public void  setCategoryId(long categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void  setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getEnglishName()
    {
        return englishName;
    }

    public void  setEnglishName(String englishName)
    {
        this.englishName = englishName;
    }

    public String getSignatureMd5()
    {
        return signatureMd5;
    }

    public void  setSignatureMd5(String signatureMd5)
    {
        this.signatureMd5 = signatureMd5;
    }

    public AppDetail()
    {
    }

    public AppDetail(String pkgName, String appName, String iconUrl, String apkUrl, long fileSize, int versionCode, String versionName, long appDownCount, com.qq.jce.MAAccess.RatingInfo appRating, com.qq.jce.MAAccess.RatingInfo apkRating, long flag, int minSdkVersion, long appId, String description, String newFeature, java.util.ArrayList<String> permissions, String editorIntro, java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic> snapshotsUrl, java.util.ArrayList<com.qq.jce.MAAccess.Video> videoList, long apkId, long authorId, String authorName, long apkPublishTime, long categoryId, String categoryName, String englishName, String signatureMd5)
    {
        this.pkgName = pkgName;
        this.appName = appName;
        this.iconUrl = iconUrl;
        this.apkUrl = apkUrl;
        this.fileSize = fileSize;
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.appDownCount = appDownCount;
        this.appRating = appRating;
        this.apkRating = apkRating;
        this.flag = flag;
        this.minSdkVersion = minSdkVersion;
        this.appId = appId;
        this.description = description;
        this.newFeature = newFeature;
        this.permissions = permissions;
        this.editorIntro = editorIntro;
        this.snapshotsUrl = snapshotsUrl;
        this.videoList = videoList;
        this.apkId = apkId;
        this.authorId = authorId;
        this.authorName = authorName;
        this.apkPublishTime = apkPublishTime;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.englishName = englishName;
        this.signatureMd5 = signatureMd5;
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AppDetail t = (AppDetail) o;
        return (
            com.qq.taf.jce.JceUtil.equals(pkgName, t.pkgName) && 
            com.qq.taf.jce.JceUtil.equals(appName, t.appName) && 
            com.qq.taf.jce.JceUtil.equals(iconUrl, t.iconUrl) && 
            com.qq.taf.jce.JceUtil.equals(apkUrl, t.apkUrl) && 
            com.qq.taf.jce.JceUtil.equals(fileSize, t.fileSize) && 
            com.qq.taf.jce.JceUtil.equals(versionCode, t.versionCode) && 
            com.qq.taf.jce.JceUtil.equals(versionName, t.versionName) && 
            com.qq.taf.jce.JceUtil.equals(appDownCount, t.appDownCount) && 
            com.qq.taf.jce.JceUtil.equals(appRating, t.appRating) && 
            com.qq.taf.jce.JceUtil.equals(apkRating, t.apkRating) && 
            com.qq.taf.jce.JceUtil.equals(flag, t.flag) && 
            com.qq.taf.jce.JceUtil.equals(minSdkVersion, t.minSdkVersion) && 
            com.qq.taf.jce.JceUtil.equals(appId, t.appId) && 
            com.qq.taf.jce.JceUtil.equals(description, t.description) && 
            com.qq.taf.jce.JceUtil.equals(newFeature, t.newFeature) && 
            com.qq.taf.jce.JceUtil.equals(permissions, t.permissions) && 
            com.qq.taf.jce.JceUtil.equals(editorIntro, t.editorIntro) && 
            com.qq.taf.jce.JceUtil.equals(snapshotsUrl, t.snapshotsUrl) && 
            com.qq.taf.jce.JceUtil.equals(videoList, t.videoList) && 
            com.qq.taf.jce.JceUtil.equals(apkId, t.apkId) && 
            com.qq.taf.jce.JceUtil.equals(authorId, t.authorId) && 
            com.qq.taf.jce.JceUtil.equals(authorName, t.authorName) && 
            com.qq.taf.jce.JceUtil.equals(apkPublishTime, t.apkPublishTime) && 
            com.qq.taf.jce.JceUtil.equals(categoryId, t.categoryId) && 
            com.qq.taf.jce.JceUtil.equals(categoryName, t.categoryName) && 
            com.qq.taf.jce.JceUtil.equals(englishName, t.englishName) && 
            com.qq.taf.jce.JceUtil.equals(signatureMd5, t.signatureMd5) );
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
        _os.write(pkgName, 0);
        _os.write(appName, 1);
        _os.write(iconUrl, 2);
        _os.write(apkUrl, 3);
        _os.write(fileSize, 4);
        _os.write(versionCode, 5);
        _os.write(versionName, 6);
        _os.write(appDownCount, 7);
        _os.write(appRating, 8);
        _os.write(apkRating, 9);
        _os.write(flag, 10);
        _os.write(minSdkVersion, 11);
        _os.write(appId, 12);
        _os.write(description, 13);
        _os.write(newFeature, 14);
        _os.write(permissions, 15);
        _os.write(editorIntro, 16);
        _os.write(snapshotsUrl, 17);
        _os.write(videoList, 18);
        _os.write(apkId, 19);
        _os.write(authorId, 20);
        if (null != authorName)
        {
            _os.write(authorName, 21);
        }
        _os.write(apkPublishTime, 22);
        _os.write(categoryId, 23);
        if (null != categoryName)
        {
            _os.write(categoryName, 24);
        }
        if (null != englishName)
        {
            _os.write(englishName, 25);
        }
        if (null != signatureMd5)
        {
            _os.write(signatureMd5, 26);
        }
    }

    static com.qq.jce.MAAccess.RatingInfo cache_appRating;
    static com.qq.jce.MAAccess.RatingInfo cache_apkRating;
    static java.util.ArrayList<String> cache_permissions;
    static java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic> cache_snapshotsUrl;
    static java.util.ArrayList<com.qq.jce.MAAccess.Video> cache_videoList;

    public void readFrom(com.qq.taf.jce.JceInputStream _is)
    {
        this.pkgName =  _is.readString(0, true);
        this.appName =  _is.readString(1, true);
        this.iconUrl =  _is.readString(2, true);
        this.apkUrl =  _is.readString(3, true);
        this.fileSize = (long) _is.read(fileSize, 4, true);
        this.versionCode = (int) _is.read(versionCode, 5, true);
        this.versionName =  _is.readString(6, true);
        this.appDownCount = (long) _is.read(appDownCount, 7, true);
        if(null == cache_appRating)
        {
            cache_appRating = new com.qq.jce.MAAccess.RatingInfo();
        }
        this.appRating = (com.qq.jce.MAAccess.RatingInfo) _is.read(cache_appRating, 8, true);
        if(null == cache_apkRating)
        {
            cache_apkRating = new com.qq.jce.MAAccess.RatingInfo();
        }
        this.apkRating = (com.qq.jce.MAAccess.RatingInfo) _is.read(cache_apkRating, 9, true);
        this.flag = (long) _is.read(flag, 10, true);
        this.minSdkVersion = (int) _is.read(minSdkVersion, 11, true);
        this.appId = (long) _is.read(appId, 12, true);
        this.description =  _is.readString(13, true);
        this.newFeature =  _is.readString(14, true);
        if(null == cache_permissions)
        {
            cache_permissions = new java.util.ArrayList<String>();
            String __var_3 = "";
            ((java.util.ArrayList<String>)cache_permissions).add(__var_3);
        }
        this.permissions = (java.util.ArrayList<String>) _is.read(cache_permissions, 15, true);
        this.editorIntro =  _is.readString(16, true);
        if(null == cache_snapshotsUrl)
        {
            cache_snapshotsUrl = new java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic>();
            com.qq.jce.MAAccess.SnapshotsPic __var_4 = new com.qq.jce.MAAccess.SnapshotsPic();
            ((java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic>)cache_snapshotsUrl).add(__var_4);
        }
        this.snapshotsUrl = (java.util.ArrayList<com.qq.jce.MAAccess.SnapshotsPic>) _is.read(cache_snapshotsUrl, 17, true);
        if(null == cache_videoList)
        {
            cache_videoList = new java.util.ArrayList<com.qq.jce.MAAccess.Video>();
            com.qq.jce.MAAccess.Video __var_5 = new com.qq.jce.MAAccess.Video();
            ((java.util.ArrayList<com.qq.jce.MAAccess.Video>)cache_videoList).add(__var_5);
        }
        this.videoList = (java.util.ArrayList<com.qq.jce.MAAccess.Video>) _is.read(cache_videoList, 18, true);
        this.apkId = (long) _is.read(apkId, 19, false);
        this.authorId = (long) _is.read(authorId, 20, false);
        this.authorName =  _is.readString(21, false);
        this.apkPublishTime = (long) _is.read(apkPublishTime, 22, false);
        this.categoryId = (long) _is.read(categoryId, 23, false);
        this.categoryName =  _is.readString(24, false);
        this.englishName =  _is.readString(25, false);
        this.signatureMd5 =  _is.readString(26, false);
    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.display(pkgName, "pkgName");
        _ds.display(appName, "appName");
        _ds.display(iconUrl, "iconUrl");
        _ds.display(apkUrl, "apkUrl");
        _ds.display(fileSize, "fileSize");
        _ds.display(versionCode, "versionCode");
        _ds.display(versionName, "versionName");
        _ds.display(appDownCount, "appDownCount");
        _ds.display(appRating, "appRating");
        _ds.display(apkRating, "apkRating");
        _ds.display(flag, "flag");
        _ds.display(minSdkVersion, "minSdkVersion");
        _ds.display(appId, "appId");
        _ds.display(description, "description");
        _ds.display(newFeature, "newFeature");
        _ds.display(permissions, "permissions");
        _ds.display(editorIntro, "editorIntro");
        _ds.display(snapshotsUrl, "snapshotsUrl");
        _ds.display(videoList, "videoList");
        _ds.display(apkId, "apkId");
        _ds.display(authorId, "authorId");
        _ds.display(authorName, "authorName");
        _ds.display(apkPublishTime, "apkPublishTime");
        _ds.display(categoryId, "categoryId");
        _ds.display(categoryName, "categoryName");
        _ds.display(englishName, "englishName");
        _ds.display(signatureMd5, "signatureMd5");
    }

    public void displaySimple(java.lang.StringBuilder _os, int _level)
    {
        com.qq.taf.jce.JceDisplayer _ds = new com.qq.taf.jce.JceDisplayer(_os, _level);
        _ds.displaySimple(pkgName, true);
        _ds.displaySimple(appName, true);
        _ds.displaySimple(iconUrl, true);
        _ds.displaySimple(apkUrl, true);
        _ds.displaySimple(fileSize, true);
        _ds.displaySimple(versionCode, true);
        _ds.displaySimple(versionName, true);
        _ds.displaySimple(appDownCount, true);
        _ds.displaySimple(appRating, true);
        _ds.displaySimple(apkRating, true);
        _ds.displaySimple(flag, true);
        _ds.displaySimple(minSdkVersion, true);
        _ds.displaySimple(appId, true);
        _ds.displaySimple(description, true);
        _ds.displaySimple(newFeature, true);
        _ds.displaySimple(permissions, true);
        _ds.displaySimple(editorIntro, true);
        _ds.displaySimple(snapshotsUrl, true);
        _ds.displaySimple(videoList, true);
        _ds.displaySimple(apkId, true);
        _ds.displaySimple(authorId, true);
        _ds.displaySimple(authorName, true);
        _ds.displaySimple(apkPublishTime, true);
        _ds.displaySimple(categoryId, true);
        _ds.displaySimple(categoryName, true);
        _ds.displaySimple(englishName, true);
        _ds.displaySimple(signatureMd5, false);
    }

}
