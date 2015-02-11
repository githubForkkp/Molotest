package com.molo.test.search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.test.WebHttpBase;

public class GetDefaultHotWordTest extends WebHttpBase {
	
	/**
	 * http://m5.qq.com/app/searchhot.htm
	 * 搜索热词
	 * 
	 * */
	@Test
	public void getDefaultHotWord(){

		String url = M5_URL + "/app/searchhot.htm";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.getJSONArray("obj");			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			//校验搜索热词不为空
			for(int i=0;i<=objArry.length()-1;i++){
				JSONArray item = (JSONArray) objArry.get(i);
				JSONObject  oo = item.getJSONObject(0);
				Assert.assertFalse(oo.get("word").equals("") || oo.get("word") == null);
			}
			Assert.assertEquals(obj.get("success"),true);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	
	
}
