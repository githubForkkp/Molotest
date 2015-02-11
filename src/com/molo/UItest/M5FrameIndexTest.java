package com.molo.UItest;

import org.openqa.selenium.By;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.molo.UItest.ModuleTestMethod.M5HotestAppModuleTest;
import com.molo.UItest.ModuleTestMethod.RankListModuleTest;
import com.molo.Utils.UItestBase;
import com.molo.Utils.AppUtils;
import com.molo.dagger.BrowserEmulator;

public class M5FrameIndexTest extends UItestBase{
	BrowserEmulator be;
	RankListModuleTest ranklistTest;

	@BeforeTest
	public void Before() {
		be = new BrowserEmulator();
		be.open("http://m5.qq.com/");
		Sleeper.sleepTightInSeconds(1);
	}

	@Test
	public void rankTestBase(){
	    ranklistTest = new RankListModuleTest();
		ranklistTest.detail_selector = "rankapp/div/a";
		ranklistTest.count = 10;	
	}

	@Test
	public void openM5app_Test() {
//		be.open("http://m5.qq.com/");
		AppUtils.isEleExsit(be, ".container.ng-scope");
	}
	
	@Test(dependsOnMethods="openM5app_Test")
	public void openM5detail_Test(){
//		be.open("http://m5.qq.com/");
		waitUntilElementExist(be.getBrowserCore(),By.cssSelector("#weeklyAppRank"), true);
		// 分类
		waitUntilElementExist(be.getBrowserCore(), By.cssSelector("#J_CategoryApps>div ul"),true);
		
		System.out.println(be.getBrowser().getTitle());
	}
	
	/*
	 * m5首页：精品游戏
	 */
	@Test
	public void m5hotestGame_Test() {
		
		M5HotestAppModuleTest hotestGameTest = new M5HotestAppModuleTest();
		hotestGameTest.maincon_selector = "#J_HotestGame";
		hotestGameTest.list_selector = "li";
		hotestGameTest.detail_selector = "choicestapp/div/a";
		hotestGameTest.count = 24;			
		hotestGameTest.Test(be.getBrowserCore());
	}
	
	/*
	 * m5首页：游戏周排行
	 */
	@Test(dependsOnMethods="rankTestBase")
	public void weeklyGameRankTest() {
		
//		RankListModuleTest ranklistTest = new RankListModuleTest();
		ranklistTest.maincon_selector = "#weeklyGameRank";
		ranklistTest.list_selector = "div[2]/ul/li";				
		ranklistTest.Test(be.getBrowserCore());

	}
	
	/*
	 * m5首页：软件周排行
	 */
	@Test(dependsOnMethods="rankTestBase")
	public void weeklyAppRankTest(){
		
		ranklistTest.maincon_selector = "#weeklyAppRank";
		ranklistTest.list_selector = "div[2]/ul/li";
		ranklistTest.Test(be.getBrowserCore());
		
	}
	
	@AfterTest
	public void After() {
		be.quit();
	}
}
