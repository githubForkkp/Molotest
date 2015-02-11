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
import com.molo.Utils.EncodeUtil;

public class SoftUpdateTest extends WebHttpBase {
	
	/**
	 * http://ws.sj.qq.com/webservices/softUpdate.do
	 * PC端软件升级
	 * 
	 * */
	@Test
	public void softUpdate(){
		
		String url = WS_URL + "/versionUpdate.do";
        String param = "wPeJhEKAEOq4FQFjGQuT81miuBDpsgPAP%2B%2F5P%2Bm%2BOfoSgueKR%2F02qJMiFI9sF4bsOtQ9MJYWUPpUF8BI4IgHBgwW82poo5oq5iu4c0e34bioO5i8RG36mv66iiuaelsCoPZFCgowMUkr9GVIlGB2T8ZHuIrcklyLYvBGYR%2FQ0wB9zNZiDoZlvmKcqMZhTX92cjbT%2FiKYfpY%3D";
		String result = httpPost(url, param);
        
		String  str = EncodeUtil.dencype(result);
//		System.out.print(str);



//		try {
//			JSONObject obj = toJson(str);
//
//			JSONArray objArry = (JSONArray) obj.get("obj");
//			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
//			Assert.assertTrue(objArry.length() > 0);
//			//校验第一条
//            int i=0;
//		    JSONObject site = (JSONObject) objArry.get(i);
//		    Assert.assertFalse(site.get("apkName").equals("")|| site.get("apkName") == null);
//			Assert.assertTrue(site.get("version") != ""|| site.get("version") != null);
//			Assert.assertTrue(site.get("name") != ""|| site.get("name") != null);
//			Assert.assertTrue(site.get("verCode") != ""|| site.get("verCode") != null);
//			Assert.assertTrue(site.get("downurl") != ""|| site.get("downurl") != null);

			
//		} catch (JSONException e) {
//			PrintFail(str);
//			e.printStackTrace();
//		}
	
	}
	
	
}
