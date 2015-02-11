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

public class GetPCRecomAppTest extends WebHttpBase {
	
	/**
	 * http://ws.sj.qq.com/webservices/getPCHRecommendApp.do
	 * PC首页每日推荐
	 * 
	 * */
//	@Test
	public void getPCHRecomApp(){
		
		String url = WS_URL + "/getPCHRecommendApp.do";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			//每日推荐分两块：必显的4个，随机显示的40个
//			JSONArray objArry_nec = (JSONArray) obj.get("necApps");
			JSONArray objArry_non = (JSONArray) obj.get("nonApps");

//			Assert.assertTrue(objArry_nec.length() > 0);

			Assert.assertTrue(objArry_non.length() > 0);
		
			Assert.assertFalse(obj.get("nonApps").equals("") || obj.get("nonApps") == null);
//			Assert.assertFalse(obj.get("necApps").equals("") || obj.get("necApps") == null);
			
			//必显的4个应用
//            for(int i=0;i<4;i++){
//				
//				JSONObject site = (JSONObject) objArry_nec.get(i);
//		    
//			    Assert.assertFalse(site.get("apkName").equals(""));
//			    Assert.assertTrue(site.get("alBum") != "");
//			    Assert.assertTrue(site.get("name") != "");
//			    Assert.assertTrue(site.get("apkCode") != "");
//			    Assert.assertTrue(site.get("downurl") != "");
//			}
            //随机显示的挑前10个校验
            for(int j=0;j<10;j++){
				
       				JSONObject site = (JSONObject) objArry_non.get(j);
       		    
       				Assert.assertFalse(site.get("apkName").equals(""));
       				Assert.assertTrue(site.get("alBum") != "");
       				Assert.assertTrue(site.get("name") != "");
       				Assert.assertTrue(site.get("apkCode") != "");
       				Assert.assertTrue(site.get("downurl") != "");

       			}

			
		} catch (JSONException e) {
			PrintFail(re, e);

		}
	
	}
	
	
}
