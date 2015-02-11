/**
 * @author joycefang
 *
 */
package com.molo.test.webservices;

import org.apache.tools.ant.filters.StringInputStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.Assert;
import org.testng.annotations.Test;
 




import com.molo.test.WebHttpBase;
import com.molo.Utils.EncodeUtil;

public class VersionUpdateTest extends WebHttpBase {
	
	/**
	 * http://ws.sj.qq.com/webservices/versionUpdate.do
	 * PC端版本升级请求
	 * 
	 * */
	@Test
	public void versionUpdate(){
		
		
		String param = "q=wPeJhEKAEOre7zr%2bFNJxKnr%2bGYJij5Nh%2b%2f1JZPobsMjFD%2fxsOm32Mxk%2fsJ%2b2l1mZLWxhGswidsF%2fLnspQgeihNNy4tBXbRDzJmWmbIi%2bFqa0ejcmb2hyacpLZMbkkBZ2yU4jxt5PtcD737ATKTsCw4k68NlopbEKkCA4JAKWwLvJT6SQ0RszP2%2bRllb%2fQVZYybGJ%2fCpPj7o%3d";
		String url = WS_URL + "/versionUpdate.do?" + param;
		
		String result = getHttpResponse4Get(url);
		String  str = EncodeUtil.dencype(result);
//		System.out.println(str);
		SAXReader reader = new SAXReader();
		
		try{
			    Document doc = reader.read(new StringInputStream(str,"UTF-8"));
			    Element root = doc.getRootElement();
			    //ret=0 update=1表示需要升级
			    Element ret = root.element("ret"); 
			    Element update = root.element("update"); 
//				System.out.println(ret.getName());
			    Assert.assertEquals(ret.getText(), "0");
				Assert.assertEquals(update.getText(), "1");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
}
