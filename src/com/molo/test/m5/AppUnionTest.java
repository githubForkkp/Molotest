package com.molo.test.m5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.test.WebHttpBase;

public class AppUnionTest extends WebHttpBase {
	
	/**
	 * http://m5.qq.com/union/type.htm?orgame=1
	 * 应用合集类别校验
	 * */
	@Test
	public void appUnionTypesTest(){

		String url = M5_URL + "/union/type.htm?orgame=1";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(), 8);

            for(int i=0;i<objArry.length();i++){
				JSONObject site = (JSONObject) objArry.get(i);		    
			    Assert.assertTrue(site.get("name") != "");
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	
	
	/**
	 * http://m5.qq.com/union/unions.htm?orgame=1&page=1&typeId=0
	 * 合集列表校验
	 * */
	@Test
	public void unionListTest(){

		String url = M5_URL + "/union/unions.htm?orgame=1&page=1&typeId=0";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(),20);

            for(int i=0;i<objArry.length();i++){
				JSONObject site = (JSONObject) objArry.get(i);
		    
			    Assert.assertTrue(site.get("appDetails") != "");
			    Assert.assertTrue(site.get("union_title") != "");
			    AppUtils.UrlCheck(site.getString("frontpicurl"));
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	

}

