package com.molo.UItest.sj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.Utils.UItestBase;
import com.molo.dagger.BrowserEmulator;

public class SJappmarket extends UItestBase {
	
		BrowserEmulator be;
		
		@BeforeTest
		public void Before() {
			be = new BrowserEmulator();
			be.open("http://sj.qq.com/myapp/");
		}
		
		
		@Test
		public void openAppMarket_Test() {
			
			// banner4
			AppUtils.isEleExsit(be, "#J_IndBanner");
			List<WebElement> blist = AppUtils.findEle(be, "#J_IndBanner").findElements(By.tagName("li"));
			Assert.assertTrue(blist.size()!=0,"banner不存在！！");
			// 小红花
			AppUtils.isEleExsit(be, "div.ind-recommend");
			List<WebElement> alist = AppUtils.findEle(be, "div.apk-info-con").findElements(By.tagName("a"));
			Assert.assertEquals(alist.size(), 3,"小红花应有3个a标签！！");
			// 装机必备
			AppUtils.isEleExsit(be, "#J_NecessaryAppBox");
			List<WebElement> llist = AppUtils.findEle(be, "#J_NecessaryAppBox").findElements(By.tagName("li"));
			Assert.assertTrue(llist.size()>7,"装机必备小于7！！");
			
			// 精品
			List<WebElement> clist = AppUtils.findEle(be, ".ind-boutique").findElements(By.cssSelector(".boutique-app-box"));
			List<WebElement> apps = clist.get(0).findElements(By.cssSelector("li"));
			List<WebElement> games = clist.get(1).findElements(By.cssSelector("li"));
			
			Assert.assertTrue(apps.size()>6,"精品软件小于6！！");
			Assert.assertTrue(games.size()>6,"精品游戏小于6！！");
			
			// 分类
			AppUtils.isEleExsit(be, "#J_CategoryTabBody");
			List<WebElement> cates = AppUtils.findEle(be, "#J_CategoryTabBody").findElements(By.tagName("li"));
			Assert.assertEquals(cates.size(),4,"分类错误！！");
			
			// 合集
			AppUtils.isEleExsit(be, "div.union-left");
			AppUtils.isEleExsit(be, "div.union-right");
			AppUtils.isEleExsit(be, "div.union-more-banner");
			
			// 排行
			AppUtils.isEleExsit(be, "div.ind-appbody-right");
			List<WebElement> ranks = AppUtils.findEle(be, "div.ind-appbody-right").findElements(By.tagName("div"));
			
			Assert.assertTrue(ranks.size()>0,"排行榜没出来！！");
		}
		
		
		@AfterTest
		public void After() {
			be.quit();
		}
	}


