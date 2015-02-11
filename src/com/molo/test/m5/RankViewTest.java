package com.molo.test.m5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.test.WebHttpBase;

public class RankViewTest extends WebHttpBase {
	
	/**
	 * 
	 * 权威下载榜
	 * http://m5.qq.com/rank/apps.htm?cateId=-1&limit=20&orgame=1&rankType=2&start=0
	 * http://m5.qq.com/rank/apps.htm?cateId=-1&limit=20&orgame=2&rankType=2&start=0
	 * 
	 * */
	@Test
	public void rankApps(){
		
		String appurl = M5_URL + "/rank/apps.htm?cateId=-1&limit=20&orgame=1&rankType=2&start=0";
		String gameurl = M5_URL + "/rank/apps.htm?cateId=-1&limit=20&orgame=2&rankType=2&start=0";
		
		String re1 = getHttpResponse4Get(appurl);
		String re2 = getHttpResponse4Get(gameurl);

		try {

			JSONObject obj = toJson(re1);
			JSONArray objArry = (JSONArray) obj.getJSONArray("obj");
			
			Assert.assertEquals(objArry.length(), 20,"应用总排行数量不足20！！");
		} catch (JSONException e) {
			PrintFail(re1, e);
		}
		
		try {
			JSONObject obj = toJson(re2);
			JSONArray objArry = (JSONArray) obj.getJSONArray("obj");
			
			Assert.assertEquals(objArry.length(), 20,"游戏总排行数量不足20！！");
		} catch (JSONException e) {
			PrintFail(re2, e);
		}
	}
}
