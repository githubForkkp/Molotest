package com.molo.UItest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.molo.UItest.ModuleTestMethod.HotestAppModuleTest;
import com.molo.UItest.ModuleTestMethod.RankListModuleTest;
import com.molo.Utils.AppUtils;
import com.molo.Utils.UItestBase;
import com.molo.dagger.BrowserEmulator;

public class M4FrameIndexTest extends UItestBase {

	BrowserEmulator be;

	@BeforeTest
	public void Before() {
		be = new BrowserEmulator();
		be.open("http://m4.qq.com/app/frameIndex.htm");
	}
	
	/*
	 * m4首页：精品游戏
	 */
	public void hotestGame_Test() {
		
		HotestAppModuleTest hotestListTest = new HotestAppModuleTest();
		hotestListTest.maincon_selector = "#J_HotestGame";
		hotestListTest.list_selector = "li";
		hotestListTest.detail_selector = "div/a";
		hotestListTest.count = 24;			
		hotestListTest.Test(be.getBrowserCore());
	}

	/*
	 * m4首页：游戏排行榜
	 */
	@Test
	public void gameRankList_Test() {
		
		RankListModuleTest ranklistTest = new RankListModuleTest();
		ranklistTest.maincon_selector = "#J_RankGameDefList";
		ranklistTest.list_selector = "li";
		ranklistTest.detail_selector = "a";
		ranklistTest.count = 10;			
		ranklistTest.Test(be.getBrowserCore());
	}
	
	/*
	 * m4首页：应用排行榜
	 */
	@Test
	public void appRankList_Test() {
		
		//滚动2000px后加载出应用周排行
		JavascriptExecutor webdriver = (JavascriptExecutor) be.getBrowserCore();
		webdriver.executeScript("$.fn.verticalScrollBar.scrollTo(2000)"); 
		Sleeper.sleepTightInSeconds(3);
		RankListModuleTest ranklistTest = new RankListModuleTest();
		//查找软件周下载模块
		ranklistTest.maincon_selector = "#J_RankAppDefList";
		ranklistTest.list_selector = "li";
		ranklistTest.detail_selector = "a";
		ranklistTest.count = 10;			
		ranklistTest.Test(be.getBrowserCore());
	}
		


	/*
	 * 打开m4游戏主页
	 */
	@Test
	public void openM4game_Test() {
		be.open("http://m4.qq.com/gamePage/index.htm");
		AppUtils.isEleExsit(be, ".rank.J_Mod");
	}

	@AfterTest
	public void After() {
		be.quit();
	}
}


