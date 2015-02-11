package com.molo.test.m4;

import java.io.FileNotFoundException;

import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.test.WebHttpBase;

public class FrameIndexTest extends WebHttpBase{
	
	/**
	 * getSearchResult_newJson
	 * 校验搜索结果不为0;结果为50条;第一个appName相等
	 * 
	 * */
	
	@Test
	public void getSearchResult_newJson_not0(){
		
		//搜索关键词
		String keyword = "qq";
		String url = M4_URL + "/search/getSearchResult_newJson.htm?keyWord="+ keyword +"&p=undefined";
		String result = getHttpResponse4Get(url);
		try {
			if(result != ""){
				JSONObject re = new JSONObject(result);
				
				JSONArray app = re.getJSONArray("appDetails");
				
				Assert.assertTrue(app.length() !=0, "搜索结果为0！！");
				
				Assert.assertTrue(app.length() <= 50 && app.length() > 20,"搜索qq关键字结果集长度为："+app.length());
				
				JSONObject Firest_app = app.getJSONObject(0);
				
				JSONObject other_app = app.getJSONObject(5);
//				for(int i=0;i<=app.length()-1;i++){
//					JSONObject o = (JSONObject) app.get(i);
//					System.out.println(o.getString("appName"));
//				}
				
				Assert.assertEquals(Firest_app.get("appName"), "QQ");
				
				Assert.assertTrue(((String)other_app.get("appName")).contains("QQ"),"搜索qq，但当前appname:"+((String)other_app.get("appName")));
				
			}else{
				Assert.fail("搜索结果为空！！");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getSearchResult_newJson
	 * 校验中文搜索成功
	 * 
	 * */
	@Test(dependsOnMethods="getSearchResult_newJson_not0")
	public void getSearchResult_newJson_chinese() throws UnsupportedEncodingException{
		
		//关键词
		String keyword = "天天爱消除";
		String url =  M4_URL + "/search/getSearchResult_newJson.htm?keyWord="+urlencode(keyword)+"&p=undefined";
		String result = getHttpResponse4Get(url);
		try {
			if(result != ""){
				JSONObject re = new JSONObject(result);
				JSONArray app = re.getJSONArray("appDetails");
				Assert.assertTrue(app.length() !=0, "搜索结果为0！！");
				
				JSONObject Firest_app = app.getJSONObject(0);
				Assert.assertEquals(Firest_app.get("appName"), keyword);
				
			}else{
				Assert.fail("搜索结果为空！！");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getSearchResult_newJson
	 * 校验中文+数字搜索成功
	 * 
	 * */
	@Test
	public void getSearchResult_newJson_chineseAddNum() throws UnsupportedEncodingException{
		
		//关键词
		String keyword = "梦幻西游2";
		String url =  M4_URL + "/search/getSearchResult_newJson.htm?keyWord="+urlencode(keyword)+"&p=undefined";
		String result = getHttpResponse4Get(url);
		try {
			if(result != ""){
				JSONObject re = new JSONObject(result);
				JSONArray app = re.getJSONArray("appDetails");
				
				Assert.assertTrue(app.length() !=0, "搜索结果为0！！");
				
				JSONObject Firest_app = app.getJSONObject(0);
				Assert.assertEquals(Firest_app.get("appName"), keyword);
				
			}else{
				Assert.fail("搜索结果为空！！");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getHover.htm
	 * 类型post
	 * 校验接口是ok的
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void gethover_isOk(){
		//post方法入参有两个
		String url = M4_URL + "/gamePage/getHover.htm";
		String apkname = "org.funship.findsomething.QQ";
		//接口只传一个参数
		List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		postParameters.add(new BasicNameValuePair("apkName",apkname));
		
		String result = getHttpResponse4Post(url, postParameters);
		JSONObject re;
		try {
			re = toJson(result);
			Assert.assertTrue(re.getBoolean("success"));
			Assert.assertTrue(re.getJSONObject("obj") !=null);
		} catch (JSONException e) {
			PrintFail(result, e);
		}
		
		
	}
	/**
	 * getHover.htm
	 * 校验数据正确性
	 * @throws JSONException 
	 * 
	 * */
	@Test(dependsOnMethods="gethover_isOk")
	public void gerhover_isRight()  {
		String url = M4_URL + "/gamePage/getHover.htm";
		String apkname = "com.tencent.pao";
		
		List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		postParameters.add(new BasicNameValuePair("apkName",apkname));
		
		String result = getHttpResponse4Post(url, postParameters);
		JSONObject re;
		try {
			re = toJson(result);
			JSONObject obj = re.getJSONObject("obj");
			
			Assert.assertEquals(obj.getString("appName"), "天天酷跑");
		} catch (JSONException e) {
			PrintFail(result, e);
		}
		
	}
	/**
	 * getHotAppAjax.htm
	 * 首页排行榜
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void getHotAppAjax_isOk()  {
		//应用排行
		String url1 = M4_URL + "/app/getHotAppAjax.htm?orgame=1&containerId=J_RankAppDefList&templateId=J_RankListTmpl";
		//游戏排行
		String url2 = M4_URL + "/app/getHotAppAjax.htm?orgame=2&containerId=J_RankAppDefList&templateId=J_RankListTmpl";
		
		String re1 = getHttpResponse4Get(url1);
		String re2 = getHttpResponse4Get(url2);
		
		JSONObject obj1;
		try {
			obj1 = toJson(re1);
			JSONObject obj2 = toJson(re2);
			
			JSONArray arr1 = obj1.getJSONArray("obj");
			JSONArray arr2 = obj2.getJSONArray("obj");
			
			Assert.assertTrue(arr1.length() >= 10,"应用排行app小于10个");
			Assert.assertTrue(arr2.length() >= 10,"游戏排行app小于10个");
		} catch (JSONException e) {
			PrintFail(re1 + "++++++++++++" + re2, e);
		}
		
	}
	/**
	 * getFriendNum.htm
	 * 好友在玩
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void getFriendNum_isOk()  {
		String apkNames="com.qqgame.happymj";
		String url = M4_URL + "/app/getFriendNum.htm?apkNames=" + apkNames;
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
//		Assert.assertTrue(obj.getBoolean("success"));
		
	}
	/**
	 * catApps.htm
	 * 分类模块
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void catApps_isOk()  {
		String url = M4_URL + "/app/catApps.htm?containerId=J_CategoryApps&templateId=J_CardBoxCategoryListTmpl_m";
		String re = getHttpResponse4Get(url);
		
		JSONObject obj;
		try {
			obj = toJson(re);
			JSONArray arr = obj.getJSONArray("obj");
			
			Assert.assertEquals(arr.length(), 4);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	/**
	 * getBussiness.htm
	 * 小红花广告模块
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void getBussiness_isOk()  {
		String url = M4_URL + "/app/getBussiness.htm?containerId=J_SpreadCon&templateId=J_SpreadTmp";
		String re = getHttpResponse4Get(url);
		
		
		JSONObject obj;
		try {
			obj = toJson(re);
			JSONArray arr = obj.getJSONArray("obj");
			
			Assert.assertEquals(arr.length(), 4);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
		
	}
	/**
	 * getGathAjax.htm
	 * 合集模块
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void getGathAjax_isOk()  {
		// 小合集
		String url1 = M4_URL + "/app/getGathAjax.htm?p=2&containerId=J_CollectionBig&templateId=J_CollectionBigTmpl";
		// 合集下应用列表
		String url2 = M4_URL + "/app/getGathAjax.htm?p=1&containerId=J_CollectionBig&templateId=J_CollectionBigTmpl";
		
		String re1 = getHttpResponse4Get(url1);
		String re2 = getHttpResponse4Get(url2);
		
		JSONObject obj1;
		try {
			obj1 = toJson(re1);
			JSONObject obj2 = toJson(re2);
			
			JSONArray arr1 = obj1.getJSONArray("obj");
			JSONArray arr2 = obj2.getJSONArray("obj");
			
			Assert.assertEquals(arr1.length(), 4,"小合集数目获取有误！！");
			Assert.assertEquals(arr2.length(), 2,"应该获取男生女生两个list！！");
			Assert.assertEquals(arr2.getJSONObject(0).getJSONArray("appDetails").length(), 10,"第一个list数目不对！！");
			Assert.assertEquals(arr2.getJSONObject(1).getJSONArray("appDetails").length(), 10,"第二个list数码不对！！");
		} catch (JSONException e) {
			PrintFail(re1 + "++++++++++++" + re2, e);
		}
		
	}
	/**
	 * getRecommendAjax.htm
	 * 小编推荐模块
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void getRecommendAjax_isOk() {
		String url = M4_URL + "/app/getRecommendAjax.htm?containerId=J_RecommendApps&templateId=J_CardBoxCompactListTmpl_m&p=1";
        String re = getHttpResponse4Get(url);
		
		JSONObject obj;
		try {
			obj = toJson(re);
			JSONArray arr = obj.getJSONArray("obj");
			
			Assert.assertEquals(arr.length(), 12);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	/**
	 * getCates.htm
	 * 页尾分类模块
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void getCates_isOk()  {
		String url = M4_URL + "/app/getCates.htm?containerId=J_CateList&templateId=J_CateListTmpl";
		String re = getHttpResponse4Get(url);
		
		JSONObject object;
		try {
			object = toJson(re);
			JSONObject  obj = object.getJSONObject("obj");
			
			Assert.assertTrue(obj.getJSONArray("1").length()>0);
			Assert.assertTrue(obj.getJSONArray("2").length()>0);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
		
	}
	/**
	 * getAppid.htm
	 * 发送到手机接口
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void getAppid_isOk()  {
		//下载app包名
		String apkName="com.qqgame.happymj";
		String url = M4_URL + "/each/getAppid.htm?apkName=" + apkName;
		
		String re = getHttpResponse4Get(url);

		JSONObject obj;
		try {
			obj = toJson(re);

			Assert.assertTrue(obj.getBoolean("success"));
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
	}
	/**
	 * rankGame.htm
	 * 游戏首页排行榜
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void rankGame_isOk()  {
		//日榜
		String type1 = "yestodayHot";
		//总下载榜
		String type2 = "downloadMax";
		
		String url1 = M4_URL + "/gamePage/rankGame.htm?p=1&type=" + type1;
		String url2 = M4_URL + "/gamePage/rankGame.htm?p=1&type=" + type2;
		
		String re1 = getHttpResponse4Get(url1);
		String re2 = getHttpResponse4Get(url2);
		
		JSONObject obj1;
		try {
			obj1 = toJson(re1);
			JSONObject obj2 = toJson(re2);
			
			JSONArray arr1 = obj1.getJSONArray("obj");
			JSONArray arr2 = obj2.getJSONArray("obj");
			
			Assert.assertTrue(arr1.length() >= 10,"日榜app小于10个");
			Assert.assertTrue(arr2.length() >= 10,"总下载榜app小于10个");
		} catch (JSONException e) {
			PrintFail("日榜："+re1 + "+++++++++++" + "总榜：" + re2, e); 
		}
		
	}
	/**
	 * ajaxGameGuessUlike.htm
	 * 游戏首页猜你喜欢
	 * @throws FileNotFoundException 
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void ajaxGameGuessUlike_isOk(){
		String url = M4_URL + "/gamePage/ajaxGameGuessUlike.htm?guessid=22";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject object = toJson(re);
			JSONArray  detail = object.getJSONArray("appDetails");
			
			Assert.assertTrue(detail.length()>0);
		} catch (JSONException e) {
//			StringWriter sw = new StringWriter();
//			sw.write(re);
//	        PrintWriter pw = new PrintWriter(sw);
//			e.printStackTrace(pw);
			PrintFail(re, e);
		}
		
		
		
	}
	/**
	 * appComment.htm
	 * 详情页评论
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void appComment_isOk()  {
		String apkName="com.qqgame.happymj";
		String url = M4_URL + "/comment/appComment.htm?apkName=" + apkName;
		
		String re = getHttpResponse4Get(url);
		
		JSONObject obj;
		try {
			obj = toJson(re);
			JSONArray commentDetails = obj.getJSONArray("commentDetails");
			
			Assert.assertTrue(obj.getInt("total") > 0);
			Assert.assertTrue(commentDetails.length() > 0);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
		
		
	}
}