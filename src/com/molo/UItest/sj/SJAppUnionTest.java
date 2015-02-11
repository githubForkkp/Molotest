package com.molo.UItest.sj;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.molo.dagger.BrowserEmulator;

public class SJAppUnionTest {
	BrowserEmulator be;

	@BeforeTest
	public void Before() {
		be = new BrowserEmulator();
		be.open("http://sj.qq.com/myapp/union.htm?orgame=1&page=1");
		Sleeper.sleepTightInSeconds(1);
	}
	
	/*
	 * 全部合集列表校验
	 */
	@Test
	public void UnionListTest(){
		
		WebDriver browserCore = be.getBrowserCore();
		//取到合集列表
		WebElement UnionListMain = browserCore.findElement(By.cssSelector("#J_UnionList"));
		List<WebElement> list = UnionListMain.findElements(By.xpath("li"));
		
		//有分页，第一页20个合集
		String message = String.format("列表应获取%s", list.size());
		Assert.assertTrue(message, list.size() >= 20);
		
		//判断所有合集里的应用链接不为空
		for(WebElement result : list){
			
			WebElement innerEle = null;
			try {
				innerEle = result.findElement(By.xpath("section/div/div/a[2]"));
			}
			catch(NoSuchElementException ex)
			{
				ex.printStackTrace();
			}		
			
            String attr = innerEle.getAttribute("ex_url");
            Assert.assertTrue(attr != "" && attr != null);
		}
    		
	}
	
	
	
	@AfterTest
	public void After() {
		be.quit();
	}

}
