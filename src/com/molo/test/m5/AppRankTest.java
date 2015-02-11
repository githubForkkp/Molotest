package com.molo.test.m5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.test.WebHttpBase;

public class AppRankTest extends WebHttpBase {
	
	/**
	 * http://m5.qq.com/rank/types.htm?orgame=1
	 * 排行类别校验
	 * */
	@Test
	public void appRankTypesTest(){

		String url = M5_URL + "/rank/types.htm?orgame=1";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(), 4);

            for(int i=0;i<objArry.length();i++){
				JSONObject site = (JSONObject) objArry.get(i);
		    
			    Assert.assertTrue(site.get("title") != "");
			    Assert.assertTrue(site.get("leftTitle") != "");
			    Assert.assertTrue(site.get("rightTitle") != "");
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	
	
	/**
	 * http://m5.qq.com/rank/apps.htm?cateId=-1&limit=20&orgame=1&rankType=1&start=0
	 * 周排行榜列表校验
	 * */
	@Test
	public void weekRankListTest(){

		String url = M5_URL + "/rank/apps.htm?cateId=-1&limit=20&orgame=1&rankType=1&start=0";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(),20);
			Assert.assertTrue(obj.get("msg").equals("success"), "获取应用列表失败");

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
	 * http://m5.qq.com/rank/apps.htm?cateId=-1&limit=20&orgame=1&rankType=2&start=0
	 * 总排行榜列表校验
	 * */
	@Test
	public void totalRankListTest(){

		String url = M5_URL + "/rank/apps.htm?cateId=-1&limit=20&orgame=1&rankType=2&start=0";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(),20);
			Assert.assertTrue(obj.get("msg").equals("success"), "获取应用列表失败");

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
