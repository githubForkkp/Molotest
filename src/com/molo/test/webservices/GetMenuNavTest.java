/**
 * @author joycefang
 *
 */
package com.molo.test.webservices;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.test.WebHttpBase;

public class GetMenuNavTest extends WebHttpBase {
	
	/**
	 * http://ws.sj.qq.com/webservices/getMenuNavigation.do?v=1
	 * 市场4菜单导航条
	 * 
	 * */
	@Test
	public void getMenuNav4(){
		
		String url = WS_URL + "/getMenuNavigation.do?v=1";
		String result = getHttpResponse4Get(url);

		try {
			JSONObject obj = toJson(result);
			//一级导航校验
			JSONArray objArry = (JSONArray) obj.get("subMenuNavigationList");
			Assert.assertTrue(objArry.length() > 0);		
			Assert.assertFalse(obj.get("subMenuNavigationList").equals("") || obj.get("subMenuNavigationList") == null);

			JSONObject menu_one = (JSONObject) objArry.get(0);
			Assert.assertTrue(menu_one.getBoolean("show"));

			//二级导航校验			
			JSONArray objArry_sub = objArry.getJSONObject(0).getJSONArray("subMenuNavigationList");
//			System.out.println("*************");
			for(int i=0;i<2;i++){
				
				JSONObject menu_two = (JSONObject) objArry_sub.get(i);
//				System.out.println(menu_two.toString());
			    Assert.assertFalse(menu_two.get("menuurl").equals("")|| menu_two.get("menuurl") == null);
			    Assert.assertFalse(menu_two.get("menuname").equals("")|| menu_two.get("menuname") == null);
			    Assert.assertTrue(menu_one.getBoolean("show"));

			}
			
		} catch (JSONException e) {
			PrintFail(result, e);

		}
	
	}
	
	/**
	 * http://ws.sj.qq.com/webservices/getMenuNavigation.do?type=mini
	 * mini版菜单导航条
	 * 
	 * */
	
	@Test
	public void getMenuNav_mini(){
		
		String url = WS_URL + "/getMenuNavigation.do?type=mini";
		String result = getHttpResponse4Get(url);

		try {
			JSONObject obj = toJson(result);
			//一级导航校验
			JSONArray objArry = (JSONArray) obj.get("subMenuNavigationList");
			Assert.assertTrue(objArry.length() > 0);		
			Assert.assertFalse(obj.get("subMenuNavigationList").equals("") || obj.get("subMenuNavigationList") == null);

			JSONObject menu_one = (JSONObject) objArry.get(0);
			Assert.assertTrue(menu_one.getBoolean("show"));

			//二级导航校验			
			JSONArray objArry_sub = objArry.getJSONObject(0).getJSONArray("subMenuNavigationList");
			for(int i=0;i<2;i++){
				
				JSONObject menu_two = (JSONObject) objArry_sub.get(i);
			    Assert.assertFalse(menu_two.get("menuurl").equals("")|| menu_two.get("menuurl") == null);
			    Assert.assertFalse(menu_two.get("menuname").equals("")|| menu_two.get("menuname") == null);
			    Assert.assertTrue(menu_one.getBoolean("show"));

			}
			
		} catch (JSONException e) {
			PrintFail(result, e);

		}
	
	}
	
}
