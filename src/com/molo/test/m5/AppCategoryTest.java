package com.molo.test.m5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.test.WebHttpBase;

public class AppCategoryTest extends WebHttpBase {
	
	/**
	 * http://m5.qq.com/cate/cates.htm?orgame=1
	 * 应用二级分类校验
	 * */
	@Test
	public void appCatesTest(){

		String url = M5_URL + "/cate/cates.htm?orgame=1";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));

            for(int i=0;i<objArry.length();i++){
				JSONObject site = (JSONObject) objArry.get(i);
		    
			    Assert.assertEquals(site.getInt("orgame"),1);
			    Assert.assertTrue(site.get("cateId") != "");
			    Assert.assertTrue(site.get("cateName") != "");
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	
	
	/**
	 * http://m5.qq.com/cate/tags.htm?cateId=106
	 * 应用分类标签
	 * 
	 * */
	@Test
	public void appCateTagsTest(){
		
		//社交分类106
		String url = M5_URL + "/cate/tags.htm?cateId=106";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			Assert.assertTrue(obj.get("msg").equals(""), "社交分类下标签为空");

            for(int i=0;i<objArry.length();i++){
				JSONObject site = (JSONObject) objArry.get(i);
		    
			    Assert.assertTrue(site.get("name") != "");
			    Assert.assertTrue(site.get("id") != "");
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}

	}
	
	/**
	 * http://m5.qq.com/cate/appList.htm?categoryId=-1&orgame=1&pageSize=80
	 * 全部应用列表校验
	 * */
	@Test
	public void cateAppListTest(){

		String url = M5_URL + "/cate/appList.htm?categoryId=-1&orgame=1&pageSize=80";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
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
	 * http://m5.qq.com/cate/tag/appList.htm?pageSize=80&tagId=10601
	 * 标签“聊天” 应用列表校验
	 * */
	@Test
	public void tagAppListTest(){

		String url = M5_URL + "/cate/tag/appList.htm?pageSize=80&tagId=10601";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");

			Assert.assertFalse(objArry.equals("") || objArry == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
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
