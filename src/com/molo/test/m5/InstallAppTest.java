package com.molo.test.m5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.test.WebHttpBase;

public class InstallAppTest extends WebHttpBase {
	
	/**
	 * http://m5.qq.com/ib/takeApps.htm?cateId=1
	 * 装机必备应用
	 * */
	@Test
	public void InstallAppListTest(){

		String url = M5_URL + "/ib/takeApps.htm?cateId=1";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(),obj.getInt("count"));

            for(int i=0;i<objArry.length();i++){
				JSONObject site = (JSONObject) objArry.get(i);
		    
			    Assert.assertTrue(site.get("appId") != "");
			    Assert.assertTrue(site.get("appName") != "");
			    AppUtils.UrlCheck(site.getString("iconUrl"));
				AppUtils.UrlCheck(site.getString("apkUrl"));
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	
	/**
	 * http://m5.qq.com/ib/takeApps.htm?cateId=2
	 * 装机必备游戏
	 * */
	@Test
	public void InstallGameListTest(){

		String url = M5_URL + "/ib/takeApps.htm?cateId=2";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(),obj.getInt("count"));

            for(int i=0;i<objArry.length();i++){
				JSONObject site = (JSONObject) objArry.get(i);
		    
			    Assert.assertTrue(site.get("appId") != "");
			    Assert.assertTrue(site.get("appName") != "");
			    AppUtils.UrlCheck(site.getString("iconUrl"));
				AppUtils.UrlCheck(site.getString("apkUrl"));
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}

}
