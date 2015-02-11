package com.molo.UItest.sj;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.Utils.UItestBase;
import com.molo.dagger.BrowserEmulator;

public class SJframeIndexTest extends UItestBase {
	
	BrowserEmulator be;
	
	@BeforeTest
	public void Before() {
		be = new BrowserEmulator();
		be.open("http://sj.qq.com/");
	}
	
	
	@Test
	public void openSjIndex_Test() {
		AppUtils.isEleExsit(be, "a#J_index-install-bt");
		AppUtils.isEleExsit(be, "#J_index-install-bt-phone>a");
//		AppUtils.ExecuteJS(be, "window.scrollTo(0,800)");
		
		be.enterFrame("//iframe[@class=\"index-app-inc-iframe\"]");
//		waitUntilElementExist(be.getBrowserCore(),By.cssSelector("div.index-left-box"),true);
		AppUtils.isEleExsit(be, "div.index-left-box");
		AppUtils.isEleExsit(be, "div.index-right-box");
	}
	
	
	@AfterTest
	public void After() {
		be.quit();
	}
}
