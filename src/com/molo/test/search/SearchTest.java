package com.molo.test.search;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.test.WebHttpBase;

public class SearchTest extends WebHttpBase{

	
	/**
	 * 
	 * 从“上升最快”及“昨日最火”的【应用】各取前20个
	 * @throws UnsupportedEncodingException 
	 * 
	 * */
	@Test
	public void Search_app() throws UnsupportedEncodingException{
		String app = M4_URL + "/appRank/rankSync.htm?orgame=1&type=2&page=1";
		//获取数据量
		int n = 10;
		String re = getHttpResponse4Get(app);
	
		try {
			JSONObject obj = toJson(re);
			
			JSONArray left = obj.getJSONArray("leftRankList");
			JSONArray right = obj.getJSONArray("rightRankList");
			
			
			for(int i=1;i<=n;i++){
				
				String item_left = left.getJSONObject(i).getString("appName");
				String item_right = right.getJSONObject(i).getString("appName");
				
				System.out.println(M5_URL + "/app/search.htm?kw="
						+ urlencode(item_left));
				
				String re_le = getHttpResponse4Get(M5_URL + "/app/search.htm?kw="
						+ urlencode(item_left));
				String re_ri = getHttpResponse4Get(M5_URL + "/app/search.htm?kw="
						+ urlencode(item_right));
				
				Check_Result(re_le, item_left);
				Check_Result(re_ri, item_right);
		
			}
				
		} catch (JSONException e) {
			PrintFail(re, e);
		}
	}
	
	/**
	 * 
	 * 从“上升最快”及“昨日最火”的【游戏】各取前20个
	 * @throws UnsupportedEncodingException 
	 * 
	 * */
	@Test
	public void Search_game() throws UnsupportedEncodingException{
		String game = M4_URL + "/appRank/rankSync.htm?orgame=2&type=2&page=1";
		//获取数据量
		int n = 10;
		String re = getHttpResponse4Get(game);
				
			try {
					JSONObject obj = toJson(re);
					
					JSONArray left = obj.getJSONArray("leftRankList");
					JSONArray right = obj.getJSONArray("rightRankList");
					
					for(int i=1;i<=n;i++){
						
						String item_left = left.getJSONObject(i).getString("appName");
						String item_right = right.getJSONObject(i).getString("appName");
						
						System.out.println(M5_URL + "/app/search.htm?kw="
								+ urlencode(item_left));
						
						String re_le = getHttpResponse4Get(M5_URL + "/app/search.htm?kw="
								+ urlencode(item_left));
						String re_ri = getHttpResponse4Get(M5_URL + "/app/search.htm?kw="
								+ urlencode(item_right));
						
						Check_Result(re_le, item_left);
						Check_Result(re_ri, item_right);
						
					} 
				}catch (JSONException e) {
					PrintFail(re, e);
				}
		
	}
	
	/**
	 * 
	 * 自定义关键词扫描（目前为精确查询，会匹配第一个）
	 * 源路径：/data/items.txt
	 * @throws UnsupportedEncodingException 
	 * 
	 * */
	@Test
	public void Search_Items() throws UnsupportedEncodingException{
		
		List<String> items = AppUtils.getDatas();
		
		for(String item : items){
			String url = M5_URL + "/app/search.htm?kw=" + urlencode(item);
			
			String result = getHttpResponse4Get(url);
			
			Check_Result(result, item);
		}
	}
	
	
	/**
	 * 
	 * 检查搜索结果公用方法
	 * 
	 * */
	public void Check_Result(String result,String item){
		try {
			
			JSONObject o = toJson(result);
			JSONObject obj = (JSONObject) o.get("obj");
			JSONArray objArry = obj.getJSONArray("appDetails");
			
			JSONObject item0 = objArry.getJSONObject(0);
			
			String actual = item0.getString("appName").toUpperCase();
			String expected = item.toUpperCase();
			
			Assert.assertEquals(actual, expected);
			
		} catch (Exception e) {
			PrintFail(result, e);
		}
	}
}