package com.molo.test.m5;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.test.WebHttpBase;

public class AppDatailTest extends WebHttpBase {
	
	/**
	 * /m5/app/appdetail.htm?apkName=
	 * app详情
	 * 
	 * */
	@Test
	public void appdetail_isOk(){
		String apkNames="com.meitu.meiyancamera";
		String url = M5_URL + "/app/appdetail.htm?apkName=" + apkNames;
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONObject objArry = (JSONObject) obj.get("obj");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);			
			Assert.assertTrue(objArry.get("pkgName").equals(apkNames));
			Assert.assertTrue(objArry.get("appId") != "");
			Assert.assertTrue(objArry.get("iconUrl") != "");
			Assert.assertTrue(objArry.get("versionCode") != "");
			Assert.assertTrue(objArry.get("apkUrl") != "");
			Assert.assertTrue(objArry.get("categoryId") != "");
			Assert.assertFalse(objArry.get("snapshotsUrl") == null);
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	
	
	/**
	 * /m5/app/ulikeapp.htm?apkName=
	 * 相关应用
	 * 
	 * */
	@Test
	public void ulikeapp_isOk(){
		String apkNames="com.meitu.meiyancamera";
		String url = M5_URL + "/app/ulikeapp.htm?apkName=" + apkNames;
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
//			System.out.println(obj.toString());
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			
			for(int i=0;i<4;i++){
				
				JSONObject site = (JSONObject) objArry.get(i);
		    
			    Assert.assertFalse(site.get("pkgName").equals(apkNames));
			    Assert.assertTrue(site.get("appId") != "");
			    Assert.assertTrue(site.get("iconUrl") != "");
			    Assert.assertTrue(site.get("versionCode") != "");
			    Assert.assertTrue(site.get("apkUrl") != "");
			}
			
		} catch (Exception e) {
			PrintFail(re, e);
		}
	

	
	

	}

	/**
	 * /m5/firstissue/take.htm?apkName=
	 * 同一开发者应用
	 * 
	 * */
	
	
	/**
	 * /m5/comment/take.htm?apkName=
	 * 加载评论
	 * 
	 * */
	@Test
	public void getcomment_isOk(){
		String apkNames="com.tencent.mobileqq";
		String url = M5_URL + "/comment/take.htm?apkName=" + apkNames;
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONObject objArry = (JSONObject) obj.get("obj");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);			
			Assert.assertTrue(objArry.get("total") != "");	
			Assert.assertEquals(obj.get("success"),true);	
			
		} catch (Exception e) {
			PrintFail(re, e);
		}
	
	}
	
	
	/**
	 * /app/authorapp.htm?authorId=179
	 * 同一开发者
	 * 
	 * */
	@Test
	public void authorapp_isOk(){
		int authorid = 179; //  腾讯
		String url = M5_URL + "/app/authorapp.htm?authorId=" + authorid;
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			for(int i=0;i<4;i++){
				
				JSONObject site = (JSONObject) objArry.get(i);
			    Assert.assertTrue(site.get("appId") != "");
			    Assert.assertTrue(site.get("iconUrl") != "");
			    Assert.assertTrue(site.get("appName") != "");
			    Assert.assertTrue(site.get("apkUrl") != "");
			}
			
		} catch (Exception e) {
			PrintFail(re, e);
		}
	
	}
	
	
}
