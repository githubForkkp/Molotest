package com.molo.test.m5;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.molo.Utils.AppUtils;
import com.molo.test.WebHttpBase;

public class MainPageTest extends WebHttpBase {

	/**
	 * /mainpage/sideBanner.htm
	 * 侧边banner展示区 
	 * 
	 * */
	
	@Test
	public void sideBanner_isOk(){
		String url = M5_URL + "/mainpage/sideBanner.htm?pageId=1";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			int total = obj.getInt("total");
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), total);
			
			for(int i=0; i<=objArry.length()-1;i++){
				JSONObject item = (JSONObject) objArry.get(i);
				
				String title = item.getString("title");			
				String tourl = item.getString("toUrl");
				String picurl = item.getString("picUrl");
				int linkType = item.getInt("linkType");
				
				//检查url格式
				AppUtils.UrlCheck(tourl);
				AppUtils.UrlCheck(picurl);
				Assert.assertTrue(!title.equals(""),"title为空");				
			}
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}		
	
	/**
	 * /mainpage/hotRcmd.htm?order=0
	 * 位置1
	 * 
	 * */
	@Test
	public void hotRcmd0_isOk(){
		String url = M5_URL + "/mainpage/hotRcmd.htm?order=0";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			
			int tab = obj.getInt("count");
			JSONArray arr = obj.getJSONArray("obj");
			
			Assert.assertEquals(arr.length(), tab,"tab个数对应");
			
			for(int i=0;i<=arr.length()-1;i++){
				JSONObject item = (JSONObject) arr.get(i);
				JSONArray app = item.getJSONArray("app");
				JSONArray appDetails = item.getJSONArray("appDetails");
				
				Assert.assertTrue(!item.getString("cate_name").equals(""));
				Assert.assertTrue(app != null && app.length() != 0);
				Assert.assertTrue(appDetails != null && appDetails.length() != 0);
				Assert.assertTrue(appDetails.length() >= 16,"精品应用第"+(i+1)+"个tab页面小于16个");
				
//				AppUtils.UrlCheck(item.getString("iconUrl"));
//				AppUtils.UrlCheck(item.getString("apkUrl"));
				
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /mainpage/hotRcmd.htm?order=1
	 * 位置2
	 * 
	 * */
	@Test
	public void hotRcmd1_isOk(){
		String url = M5_URL + "/mainpage/hotRcmd.htm?order=1";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			
			int tab = obj.getInt("count");
			JSONArray arr = obj.getJSONArray("obj");
			
			Assert.assertEquals(arr.length(), tab,"tab个数对应");
			
			for(int i=0;i<=arr.length()-1;i++){
				JSONObject item = (JSONObject) arr.get(i);
				JSONArray app = item.getJSONArray("app");
				JSONArray appDetails = item.getJSONArray("appDetails");
				
				Assert.assertTrue(!item.getString("cate_name").equals(""));
				Assert.assertTrue(app != null && app.length() != 0);
				Assert.assertTrue(appDetails != null && appDetails.length() != 0);
				Assert.assertTrue(appDetails.length() >= 16,"精品游戏第"+(i+1)+"个tab页面小于16个");
//				AppUtils.UrlCheck(item.getString("iconUrl"));
//				AppUtils.UrlCheck(item.getString("apkUrl"));
				
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /m5/mainpage/cateApps.htm
	 * 分类推荐区
	 * 
	 * */
	@Ignore
	public void cateApps_isOk(){
		String url = M5_URL + "/mainpage/cateApps.htm";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			int total = obj.getInt("total");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), total);
			
			Random random = new Random();
			
			// 产生随机数
			int cate = random.nextInt(4);
			int app = random.nextInt(14);
			
			JSONObject catObj = objArry.getJSONObject(cate);
			JSONArray details =catObj.getJSONArray("appDetails");
			
			Assert.assertEquals(details.length(),catObj.getJSONArray("app").length());
			JSONObject appObj = details.getJSONObject(app);
			
			AppUtils.UrlCheck(appObj.getString("iconUrl"));
			AppUtils.UrlCheck(appObj.getString("apkUrl"));
			
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	
	
	/**
	 * /mainpage/categoryList.htm?orgame=-1
	 * 分类模块
	 * 
	 * */
	@Test
	public void categoryList_isOk(){
		String url = M5_URL + "/mainpage/categoryList.htm?orgame=-1";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.getJSONArray("obj");
			int count = obj.getInt("total");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), count);
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	/**
	 * /mainpage/cateTags.htm
	 * 热门标签
	 * 
	 * */
	@Test
	public void cateTags_isOk(){
		String url = M5_URL + "/mainpage/cateTags.htm";
		String re = getHttpResponse4Get(url);
		
		try {
			JSONObject obj = toJson(re);
			JSONObject array = obj.getJSONObject("obj");
			
			JSONArray  arr = array.getJSONArray("nodes");
			for(int i=0;i<=arr.length()-1;i++){
				JSONObject item = (JSONObject) arr.get(i);
				Assert.assertFalse(item.getString("name").equals(""));
				
				AppUtils.UrlCheck(item.getString("url"));
				
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	
	
	
	/**
	 * /mainpage/weeklyRank.htm?orgame=2
	 * 周下载排行（游戏）
	 * 
	 * */
	@Test
	public void weeklyRank2_isOk(){
		String url = M5_URL + "/mainpage/weeklyRank.htm?orgame=2";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
				AppUtils.UrlCheck(item.getString("iconUrl"));
				AppUtils.UrlCheck(item.getString("apkUrl"));
				
			}
			
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	
	
	/**
	 * /mainpage/weeklyRank.htm?orgame=2
	 * 周下载排行（应用）
	 * 
	 * */
	@Test
	public void weeklyRank1_isOk(){
		String url = M5_URL + "/mainpage/weeklyRank.htm?orgame=1";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
				AppUtils.UrlCheck(item.getString("iconUrl"));
				AppUtils.UrlCheck(item.getString("apkUrl"));
				
				
			}
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /mainpage/fastestRisingRank.htm?orgame=2
	 * 上升最快榜（游戏）
	 * 
	 * */
	@Test
	public void fastestRisingRank2_isOk(){
		String url = M5_URL + "/mainpage/fastestRisingRank.htm?orgame=2";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
				AppUtils.UrlCheck(item.getString("iconUrl"));
				AppUtils.UrlCheck(item.getString("apkUrl"));
				
				
			}
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /mainpage/fastestRisingRank.htm?orgame=1
	 * 上升最快榜（应用）
	 * 
	 * */
	@Test
	public void fastestRisingRank1_isOk(){
		String url = M5_URL + "/mainpage/fastestRisingRank.htm?orgame=1";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
				AppUtils.UrlCheck(item.getString("iconUrl"));
				AppUtils.UrlCheck(item.getString("apkUrl"));
				
				
			}
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	
	/**
	 * /mainpage/recommandApps.htm
	 * 猜你喜欢
	 * 
	 * */
	@Test
	public void recommandApps_isOk(){
		String url = M5_URL + "/mainpage/recommandApps.htm";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.getJSONArray("obj");
			int count = obj.getInt("total");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			
			Assert.assertEquals(objArry.length(), count,"应用个数");
			System.out.println(objArry.length());
			Assert.assertTrue(objArry.length() > 32,"猜你喜欢小于32");
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
                JSONObject app = item.getJSONObject("appDetail");
                
                Assert.assertTrue(app != null);
				
				
			}
			
			
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /union/m5indexUnions.htm
	 * 合集速递
	 * 
	 * */
	@Test
	public void m5indexUnions_isOk(){
		String url = M5_URL + "/union/m5indexUnions.htm";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			int  count = obj.getInt("total");
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), count);
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
                
				System.out.println(item.getJSONArray("simpleAppDetails").length());
                AppUtils.UrlCheck(item.getString("picUrl"));
                
                if(i<5){
                	Assert.assertTrue((null !=item.get("simpleAppDetails") || item.getJSONArray("simpleAppDetails").length()!=0 )&& item.getJSONArray("simpleAppDetails").length() == 5, "第"+(i + 1)+"个合集不应为空或小于5个app");
                }
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /m5/mainpage/cateRank.htm?cateId=148&orgame=2
	 * 棋牌游戏
	 * 
	 * */
	@Ignore
	public void cateRank1_isOk(){
		String url = M5_URL + "/mainpage/cateRank.htm?cateId=148&orgame=2";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
				AppUtils.UrlCheck(item.getString("iconUrl"));
				AppUtils.UrlCheck(item.getString("apkUrl"));
				
			}
			
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /m5/mainpage/cateRank.htm?cateId=144&orgame=2
	 * 动作游戏
	 * 
	 * */
	@Ignore
	public void cateRank2_isOk(){
		String url = M5_URL + "/mainpage/cateRank.htm?cateId=144&orgame=2";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
				AppUtils.UrlCheck(item.getString("iconUrl"));
				AppUtils.UrlCheck(item.getString("apkUrl"));
				
			}
		} catch (Exception e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /m5/mainpage/cateRank.htm?cateId=106&orgame=1
	 * 社交软件
	 * 
	 * */
	@Ignore
	public void cateRank3_isOk(){
		
		String url = M5_URL + "/mainpage/cateRank.htm?cateId=106&orgame=1";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject obj = toJson(re);
			JSONArray objArry = (JSONArray) obj.get("obj");
			
			
			Assert.assertFalse(obj.get("obj").equals("") || obj.get("obj") == null);
			Assert.assertEquals(objArry.length(), obj.getInt("count"));
			
			for(int i=0;i<=objArry.length()-1;i++){
                JSONObject item = (JSONObject) objArry.get(i);
				
				AppUtils.UrlCheck(item.getString("iconUrl"));
				AppUtils.UrlCheck(item.getString("apkUrl"));
				
			}
		} catch (Exception e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * /m5/mainpage/friendNums.htm?apkNames=
	 * 好友在玩功能
	 * @throws UnsupportedEncodingException 
	 * 
	 * */
	@Ignore
	public void friendNums_isOk() throws UnsupportedEncodingException{
		
		String apkNames = "com.qzone";
		String url = M5_URL + "/mainpage/friendNums.htm?apkNames=" + urlencode(apkNames);
		
		String re = getHttpResponse4Get(url);
		
		try{
			com.alibaba.fastjson.JSONObject  obj = JSON.parseObject(re);
		
			com.alibaba.fastjson.JSONObject detail = obj.getJSONObject("obj");
		
			Assert.assertTrue(detail.getInteger("com.qzone")>0,"没有获取到好友在玩数！！");
		}catch(Exception e){
			PrintFail(re, e);
		}
	}
	
	/**
	 * /mainpage/appStage.htm
	 * 礼包时间
	 * @throws JSONException 
	 * 
	 * */
	@Test
	public void appStage_isOk(){
		String url = M5_URL + "/mainpage/appStage.htm";
		String re = getHttpResponse4Get(url);
		try {
			JSONObject  obj = toJson(re);
			if(obj.getBoolean("success")){
				JSONObject Stage = obj.getJSONObject("obj");
				AppUtils.UrlCheck(Stage.getString("imgUrl"));
				Assert.assertTrue(Stage.get("taskid") != null);
				
				
				SimpleDateFormat fm = new  SimpleDateFormat("MM月-dd日");
				Date date = new Date(System.currentTimeMillis());
				// 解析礼包接口到期日期
				String taskPeriod = Stage.getString("taskPeriod");
				String[] d = taskPeriod.split(" ");
				System.out.println(taskPeriod);
				if(d.length>1){
					
					Date Ot= fm.parse(d[2]);
					
					Assert.assertTrue((Ot.getMonth()+1>=date.getMonth()+1 && Ot.getDate()>=date.getDate()),
							"礼包过期！到期时间："+ d[2]);
				}

			}
			
		} catch (Exception e) {
			PrintFail(re, e);
		}
	}
}
