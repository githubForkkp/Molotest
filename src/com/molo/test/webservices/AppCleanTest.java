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

public class AppCleanTest extends WebHttpBase {
	
	/**
	 * http://ws.sj.qq.com/webservices/appClear.do
	 * PC端山寨应用查杀(已废弃)
	 * 
	 * */
//	@Test
	public void appClean(){
		
		String url = WS_URL + "/appClear.do";
        String param = "Fkg5R5LJ9gRHcvfj53lAlhVzVi6zPfwcWd/SSl4nIwTkJGmDxQhUJpSgvyvTtlspOiB+xpd59hAWLehumBHskDpUUKV7mZ0B";
//		String param = "StRsO5OcsmsWSDlHksn2BK4diBmcOEj1NBD3/CZy5krBsxOlaQzNAH3aBfOHvQOt2XpievFxAPCVX6nDr49CFpIplFS/P9hHtm2Fe13yY1kZgpOMuhOC6Mre9q6b2FKkkNiJtXICCa2bj/ULTuL+mHRUGhCvTWFbGuYfIfF9W+ziItVnlNGXhy8Zu38M8v5aIpezlXZE0RkM5GU4nzjtBAhgxsffg7WqhxJNj0+cwtvSkp9dl2zFUj5cyawU7EC+R2yPhEE3Ah/rBarWMLr0nCubcGk9FKX49X4awt/bsyDdTQK0qny9hjZUk9NuVvQ/hgLowJhqprO1p3EzCU6ZnzxAZsPD4iM6GkPcimH7V/wkUm7vxlZlAmvVhtOUkzGz4+lVT5CAlcPdQLyzkiR0RtpwKkCiAYTiCc3V5i2ahxFMPnoTUCIpFdl6YnrxcQDwn/x8wZDPoec3snbvel68eoG+x0Hgo3Juhp4gTqQmJMvBE9EHUAhziJDYibVyAgmtkxsnd4DAwnGrhfLtFc12/ThzEgEEMjqK7PMOJPYDErl6p0mzfo6z8QT+zSEnZSB76a6nXGfxhVQil7OVdkTRGWG4wTfZe+1B82pwrZLIloLPSAcAJpo1ahhMfOgAhUR6hJMbWb2B75JHbI+EQTcCH/d5zNp9lcPyxcGhkSAAb05kBNqOhrjVxuIi1WeU0ZeHiAa+t6R+NzA2VJPTblb0P4YC6MCYaqaztadxMwlOmZ88QGbDw+IjOhpD3Iph+1f8JFJu78ZWZQJr1YbTlJMxs9ylDidMJ+KaWxF5ArndYhX+e74RwZKVXPV+GsLf27MgGP+VX7oQRdo9HYEzMrQvLQQcO4zIxMiUZ2dM5UtPbwLTg8LfZQX55K9CnonVukTYzyy9Wl+eVU2074Eo38vNWeQkaYPFCFQmlKC/K9O2Wyk6IH7Gl3n2EPV+GsLf27MgBUEW7lOikwAEb2uz3UrJIojKAgKlxPDXO25S2oyVlLEuGDiyX3KaGtuuYty1/AiOmK7c3qbs9RGBvmZh9zl5jq5iW2ugypRrv9SOETv1aJy73VWFot2siF0xMeytHLRwOtiq5CCBIyHFMGhucW/JsrSz+TLOYpDu7NJBSQ8V74J754tY/vLSGpzMgRt0crRbRN6MJkOhLwG3c73fAxdhaImj29ZlNkQh+eJYsM8R6WrW+Ctqp8N4PfgUY4uRUwrJxTBobnFvybKbFzyf0gAm7CxpgGO1r0DD//Etl1JMkfnC3ElvW1J1s/8KbGMd9p8s9n/ubk5PeSRkQxsn+heroZR/hDYuJ3Zpa829Blgq9RoFWJ1ShZblWA==";
		String result = httpPost(url, param);

		String  str = EncodeUtil.dencype(result);
		System.out.print(str);


		
		try {
			JSONObject obj = toJson(str);

			JSONArray objArry = (JSONArray) obj.get("result");
			Assert.assertFalse(obj.get("result").equals("") || obj.get("result") == null);
			Assert.assertTrue(obj.get("message").equals("success"));
			//该post请求中包含3个山寨应用
			Assert.assertTrue(objArry.length() > 2);
			//校验第一条
            int i=0;
		    JSONObject site = (JSONObject) objArry.get(i);
		    Assert.assertFalse(site.get("packageName").equals("")|| site.get("packageName") == null);
			Assert.assertTrue(site.get("apkFileMd5") != ""|| site.get("apkFileMd5") != null);
			Assert.assertTrue(site.get("appName") != ""|| site.get("appName") != null);
			Assert.assertTrue(site.get("apkUrl") != ""|| site.get("apkUrl") != null);

			
		} catch (JSONException e) {
			PrintFail(str, e);
		}
	
	}
	
	
}
