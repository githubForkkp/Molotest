package com.molo.wmarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.taftest.TafBaseTest;
import com.qq.jce.vmarket.wmarket.AppDetail;
import com.qq.jce.vmarket.wmarket.AppInfoForUpdate;
import com.qq.jce.vmarket.wmarket.Banner;
import com.qq.jce.vmarket.wmarket.CategoryDetail;
import com.qq.jce.vmarket.wmarket.CommentDetail;
import com.qq.jce.vmarket.wmarket.GetAppDetailBatchReq;
import com.qq.jce.vmarket.wmarket.GetAppDetailBatchRsp;
import com.qq.jce.vmarket.wmarket.GetAppListReq;
import com.qq.jce.vmarket.wmarket.GetAppListRsp;
import com.qq.jce.vmarket.wmarket.GetAppUpdateReq;
import com.qq.jce.vmarket.wmarket.GetAppUpdateRsp;
import com.qq.jce.vmarket.wmarket.GetBannerReq;
import com.qq.jce.vmarket.wmarket.GetBannerRsp;
import com.qq.jce.vmarket.wmarket.GetCategoryListReq;
import com.qq.jce.vmarket.wmarket.GetCategoryListRsp;
import com.qq.jce.vmarket.wmarket.GetCommentListReq;
import com.qq.jce.vmarket.wmarket.GetCommentListRsp;
import com.qq.jce.vmarket.wmarket.GetGroupAppsReq;
import com.qq.jce.vmarket.wmarket.GetGroupAppsRsp;
import com.qq.jce.vmarket.wmarket.GetIndexUnionsReq;
import com.qq.jce.vmarket.wmarket.GetIndexUnionsRsp;
import com.qq.jce.vmarket.wmarket.GetLastCommentByUinBatchReq;
import com.qq.jce.vmarket.wmarket.GetLastCommentByUinBatchRsp;
import com.qq.jce.vmarket.wmarket.GetOpcRankListReq;
import com.qq.jce.vmarket.wmarket.GetOpcRankListRsp;
import com.qq.jce.vmarket.wmarket.GetSearchHotWordsReq;
import com.qq.jce.vmarket.wmarket.GetSearchHotWordsRsp;
import com.qq.jce.vmarket.wmarket.GetSearchSuggestReq;
import com.qq.jce.vmarket.wmarket.GetSearchSuggestRsp;
import com.qq.jce.vmarket.wmarket.GetUnionAppsReq;
import com.qq.jce.vmarket.wmarket.GetUnionAppsRsp;
import com.qq.jce.vmarket.wmarket.GetUnionsReq;
import com.qq.jce.vmarket.wmarket.GetUnionsRsp;
import com.qq.jce.vmarket.wmarket.HotWord;
import com.qq.jce.vmarket.wmarket.SearchAppReq;
import com.qq.jce.vmarket.wmarket.SearchAppRsp;
import com.qq.jce.vmarket.wmarket.SearchRspItem;
import com.qq.jce.vmarket.wmarket.Union;


public class vmarketTest extends TafBaseTest{
	
	private  static Logger logger = Logger.getLogger(vmarketTest.class);
	// Banner
	@Test
	public void GetBanner_isOk() {
		GetBannerReq req = new GetBannerReq();
		
		//首页banner:1
		//游戏顶部banner:2
		//应用顶部banner:3
		//首页4个小banner:4
		//游戏中间banner:5
		//应用中间banner:6  
		//首页底部banner:7
		req.setTypes(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7)));
		// 返回BannerRsp
		GetBannerRsp getbannerRsp = (GetBannerRsp) getTaservice("getBanner",req,new GetBannerRsp());
		
		Assert.assertTrue("首页bannner数量。",getbannerRsp.getBannerList().size()>0);
		
		for(int i=0;i<=getbannerRsp.getBannerList().size()-1;i++){
			Banner banner = getbannerRsp.getBannerList().get(i);
			AppUtils.UrlCheck(banner.getPicUrl());
			//CheckPmast(banner.getToUrl());
			Assert.assertNotNull("banner标题。第"+(i+1)+"位置title为null", banner.getTitle());
		}
    }
	
	// App列表  应用-1  游戏-2
	@Test(timeOut=15000)
	public void GetAppListGame_isOk(){
		
		GetAppListReq req = new GetAppListReq();
		int[] listtype = {0x01,0x02,0x04,0x06,0x07,0x08,0x11,0x12};
		
		for(int i=0;i<listtype.length;i++){
			
			req.setListType(listtype[i]);
			req.setPageSize(20);
			req.setContextData(new byte[0]);
			//req.setCategoryId(-2);
			//if(i == 7) req.setTagId(14702);
			
			req.setTagId(14705);
			
			GetAppListRsp rsp = (GetAppListRsp) getTaservice("getAppList", req, new GetAppListRsp());
			logger.info("listtype:"+(i+1)+":"+rsp.getAppList().size());
			//logger.info(rsp.getAppList().get(0));
			
			Assert.assertTrue("对应的类型:"+((i+1) == 7 ? "飙升榜0x11" : ""),rsp.getAppList().size()>0);
				
			for(AppDetail app : rsp.getAppList()){
				Assert.assertNotNull("热门游戏不为空。",app);
				
				//logger.info("第"+i+1+"处："+app.getAppName());
			}
		}
	}
	
	
	@Test
	public void GetAppListApp_isOk(){
		
		GetAppListReq req = new GetAppListReq();

			req.setListType(0x03);
			req.setPageSize(20);
			req.setContextData(new byte[0]);
			req.setCategoryId(-1);
			
			GetAppListRsp rsp = (GetAppListRsp) getTaservice("getAppList", req, new GetAppListRsp());
			
			//logger.info(rsp.getAppList());
			Assert.assertTrue("热门应用数量。",rsp.getAppList().size()>0);
			for(AppDetail app : rsp.getAppList()){
				Assert.assertNotNull("热门应用不为空。",app);
			}
			
		
	}
	
	// 游戏分类最新
	@Test
	public void GetGameList_isOk(){
		
		GetAppListReq req = new GetAppListReq();
		
		req.setListType(0x105);
		req.setPageSize(20);
		req.setContextData(new byte[0]);
		req.setCategoryId(-2);
			
		GetAppListRsp rsp = (GetAppListRsp) getTaservice("getAppList", req, new GetAppListRsp());
		
		Assert.assertTrue("最新游戏数量。",rsp.getAppList().size()>0);
		for(AppDetail app : rsp.getAppList()){
			Assert.assertNotNull("最新游戏不为空。",app);
		}
	}
	// 应用分类最新
	@Test
	public void GetAppList_isOk(){
		
		GetAppListReq req = new GetAppListReq();
		
		req.setListType(0x105);
		req.setPageSize(20);
		req.setContextData(new byte[0]);
		req.setCategoryId(-1);
			
		GetAppListRsp rsp = (GetAppListRsp) getTaservice("getAppList", req, new GetAppListRsp());
		
		Assert.assertTrue("最新应用数量。",rsp.getAppList().size()>0);
		for(AppDetail app : rsp.getAppList()){
			Assert.assertNotNull("最新应用不为空。",app);
		}
	}
	
	// 个性榜单
	@Test
	public void GetRankList_isOk(){
		
		GetAppListReq req = new GetAppListReq();
		
		req.setListType(0x108);
		req.setPageSize(20);
		req.setContextData(new byte[0]);
		//req.setCategoryId(-1);
			
		GetAppListRsp rsp = (GetAppListRsp) getTaservice("getAppList", req, new GetAppListRsp());
		
		Assert.assertTrue("个性榜数量。",rsp.getAppList().size()>0);
		for(AppDetail app : rsp.getAppList()){
			Assert.assertNotNull("个性榜应用不为空。",app);
		}
	}
	
	// 应用详情
	@Test
	public void GetAppDetailBatch_isOk(){
		
		GetAppDetailBatchReq req = new GetAppDetailBatchReq();
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("com.june.game.doudizhu");
		
		req.setPkgNameList(list);
		
		GetAppDetailBatchRsp rsp = (GetAppDetailBatchRsp) getTaservice("getAppDetailBatch", req, new GetAppDetailBatchRsp());
		
		Assert.assertTrue("doudizhu应用详情拉取。",rsp.getMpRes().containsKey("com.june.game.doudizhu"));
		
	}
	
	// 分类列表
	@Test
	public void GetCategoryList_isOk(){
		
		GetCategoryListReq req = new GetCategoryListReq();
		
		req.setReqType(-2);
		
		GetCategoryListRsp rsp = (GetCategoryListRsp) getTaservice("getCategoryList", req, new GetCategoryListRsp());
		
		Assert.assertTrue("分类列表数量。",rsp.getCategoryList().size()>0);
		for(CategoryDetail cate : rsp.getCategoryList()){
			Assert.assertNotNull("分类列表不为空。",cate);
		}
	}
	
	// 评论列表
	@Test
	public void GetCommentList_isOk(){
		GetCommentListReq req = new GetCommentListReq();
		
		String pkgName = "com.tencent.mobileqq";
		int pageSize = 2;
		
		req.setPkgName(pkgName);
		req.setPageSize(pageSize);
		req.setContextData(new byte[0]);
		
		
		GetCommentListRsp rsp = (GetCommentListRsp) getTaservice("getCommentList", req, new GetCommentListRsp());
		
		Assert.assertTrue(rsp.getCommentList().size() > 0);
		
		for(CommentDetail comment : rsp.getCommentList()){
			Assert.assertNotNull("评论为空。",comment);
		}
	}
	
	// 指定用户评论
	@Ignore
	public void GetLastCommentByUinBatch_isOk(){
		
		GetLastCommentByUinBatchReq req = new GetLastCommentByUinBatchReq();
		
		req.setPkgName("com.tencent.west");
		
		req.setUins(new ArrayList<Long>(Arrays.asList(41947921L)));
		
		GetLastCommentByUinBatchRsp rsp = (GetLastCommentByUinBatchRsp) getTaservice("getLastCommentByUinBatch", req, new GetLastCommentByUinBatchRsp());
		
		logger.info(rsp.getMpRes());
	}
	
	// 搜索热词
	@Test
	public void GetSearchHotWords_isOk(){
		
		GetSearchHotWordsRsp rsp = (GetSearchHotWordsRsp)getTaservice("getSearchHotWords", new GetSearchHotWordsReq(), new GetSearchHotWordsRsp());
		
		Assert.assertTrue("搜索热词。",rsp.getHotWords().size()>0);
		for(HotWord word : rsp.getHotWords()){
			Assert.assertTrue("搜索热词name。",!word.getName().equals(""));
		}
		
	}
	
	@Test
	public void GetOpcRankList_isOk(){
		GetOpcRankListReq req = new GetOpcRankListReq();
		
		GetOpcRankListRsp rsp =(GetOpcRankListRsp)getTaservice("getOpcRankList", req, new GetOpcRankListRsp());
		
		Assert.assertTrue("个性榜",rsp.getOpcRankList().size()>0);
		
		TestOpcRank(rsp,"老:");
		
		GetOpcRankListReq req1 = new GetOpcRankListReq();
		req1.setOpcType(1);
		
		GetOpcRankListRsp rsp1 =(GetOpcRankListRsp)getTaservice("getOpcRankList", req1, new GetOpcRankListRsp());
		
		
		Assert.assertTrue("个性榜",rsp1.getOpcRankList().size()>0);
		
		TestOpcRank(rsp1,"新:");
	}

	private void TestOpcRank(GetOpcRankListRsp rsp,String txt) {
		
		logger.info(txt+rsp.getOpcRankList().size());
		for (int i = 0; i < rsp.getOpcRankList().size(); i++) {
			
			Assert.assertTrue(txt+"个性榜应用",rsp.getOpcRankList().get(i).getAppList().size()>0);
			
			for (int j = 0; j < rsp.getOpcRankList().get(i).getAppList().size(); j++) {
				Assert.assertTrue(txt+"个性榜应用",!rsp.getOpcRankList().get(i).getAppList().get(j).getAppName().equals(""));
				Assert.assertTrue(txt+"个性榜应用",!rsp.getOpcRankList().get(i).getAppList().get(j).getApkUrl().equals(""));
				//System.out.println(rsp.getOpcRankList().get(i).getAppList().get(j).getAppName());
			}
			
		}
	}
	// 搜索联想
	@Test
	public void GetSearchSuggest_isOk(){
		GetSearchSuggestReq req = new GetSearchSuggestReq();
		
		req.setKeyword("腾讯");
		
		GetSearchSuggestRsp rsp = (GetSearchSuggestRsp)getTaservice("getSearchSuggest", req, new GetSearchSuggestRsp());
		
		Assert.assertTrue("联想腾讯数量。",rsp.getAppDetails().size()>0);
		for(AppDetail app : rsp.getAppDetails()){
			Assert.assertNotNull("联想appdetail。",app);
		}
	}
	
	// 搜索应用
	@Test
	public void searchApp_isOk(){
		
		SearchAppReq req = new SearchAppReq();
		
		req.setKeyword("腾讯");
		req.setPageSize(20);
		SearchAppRsp rsp = (SearchAppRsp)getTaservice("searchApp", req, new SearchAppRsp());
		
		Assert.assertTrue("搜索'腾讯'数量。",rsp.getItems().size()>0);
		for(SearchRspItem item : rsp.getItems()){
			Assert.assertNotNull("搜索appdetail。",item);
		}
	}
	
	// 获取分组（必备、最热、专题） &分类标签
	@Ignore
	public void getGroupApps_isOk(){
		GetGroupAppsReq req = new GetGroupAppsReq();
		
		req.setType(7);
		req.setCategoryId(147);
		
		GetGroupAppsRsp rsp = (GetGroupAppsRsp)getTaservice("getGroupApps", req, new GetGroupAppsRsp());
		
		logger.info("group"+rsp.getGroups());
		logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		logger.info(rsp.getTagList());
	}
	
	// 获取合集列表
	@Test
	public void getUnionsGame_isOk(){
		GetUnionsReq req = new GetUnionsReq();
		
		req.setPageNumber(1);
		req.setType("2");
		
		GetUnionsRsp rsp = (GetUnionsRsp)getTaservice("getUnions", req, new GetUnionsRsp());
		
		Assert.assertTrue("游戏合集数量。",rsp.getUnions().size()>0);
		for(Union union : rsp.getUnions()){
			Assert.assertNotNull("游戏合集.",union);
			Assert.assertTrue("游戏合集id。",union.getId()!=0);
		}
		
	}
	@Test
	public void getUnionsApp_isOk(){
		GetUnionsReq req = new GetUnionsReq();
		
		req.setPageNumber(1);
		req.setType("1");
		
		GetUnionsRsp rsp = (GetUnionsRsp)getTaservice("getUnions", req, new GetUnionsRsp());
		
		Assert.assertTrue("应用合集数量。",rsp.getUnions().size()>0);
		for(Union union : rsp.getUnions()){
			Assert.assertNotNull("应用合集.",union);
			Assert.assertTrue("应用合集id。",union.getId()!=0);
		}
		
	}
	
	// 获取合集列表
	@Test
	public void getUnionApps_isOk(){
		GetUnionAppsReq req = new GetUnionAppsReq();
		
		req.setUnionId((long)35);
		
		GetUnionAppsRsp rsp = (GetUnionAppsRsp)getTaservice("getUnionApps", req, new GetUnionAppsRsp());
		
	}
	
	// 获取首页合集列表
	@Test
	public void getIndexUnions_isOk(){
		GetIndexUnionsReq req = new GetIndexUnionsReq();
				
		GetIndexUnionsRsp rsp = (GetIndexUnionsRsp)getTaservice("getIndexUnions", req, new GetIndexUnionsRsp());
		
		Assert.assertTrue("首页合集数量。",rsp.getUnions().size()>0);
		for(Union union : rsp.getUnions()){
			Assert.assertNotNull("首页合集.",union);
			Assert.assertTrue("首页合集id。",union.getId()!=0);
		}
		
	}
	
	// 获取更新
	@Ignore
	public void getAppUpdate_isOk(){
		GetAppUpdateReq req = new GetAppUpdateReq();
		ArrayList<AppInfoForUpdate>  info = new ArrayList<AppInfoForUpdate>();
		
		AppInfoForUpdate app = new AppInfoForUpdate();
		
		app.setPackageName("com.tencent.qqappmarket.hd");
		app.setVersionCode(135);
		app.setManifestMd5("C75ED731D85817C6A50027758DC11A11");
		
		info.add(app);
		
		GetAppUpdateRsp rsp = (GetAppUpdateRsp)getTaservice("getAppUpdate", req, new GetAppUpdateRsp());
		
		logger.info(rsp.getAppUpdateInfoList());
		
	}
	
	public static void CheckPmast(String url){
		
		if("".equals(url)){
			Assert.fail("Banner对应的url为空！！");
		}
		//协议重复
 		String regx0 = "(pmast|pmast:|pmast:\\/\\/){2,}";
		String regx1 = "(pmast|pmast:|pmast:\\/\\/){1,}$";
		//头部缺少协议
		String regx2 = "^(pmast){1}";
		
		Pattern r0 = Pattern.compile(regx0);
		Pattern r1 = Pattern.compile(regx1);
		Pattern r2 = Pattern.compile(regx2);
		
		Matcher m0 = r0.matcher(url);
		Matcher m1 = r1.matcher(url);
		Matcher m2 = r2.matcher(url);
		
		
		if(m0.find()||m1.find())
		{
			logger.info("协议重复需要检查！！"+url);
			Assert.fail("协议重复需要检查！！"+url);
		}
		else if(!m2.find())
		{
			logger.info("协议缺少需要检查！！"+url);
			Assert.fail("协议缺少需要检查！！"+url);
		}
	}
	
}
