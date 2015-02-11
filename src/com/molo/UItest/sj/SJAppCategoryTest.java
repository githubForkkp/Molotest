package com.molo.UItest.sj;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.molo.dagger.BrowserEmulator;

public class SJAppCategoryTest {
	
	BrowserEmulator be;

	@BeforeTest
	public void Before() {
		be = new BrowserEmulator();
		be.open("http://sj.qq.com/myapp/category.htm?orgame=1");
		Sleeper.sleepTightInSeconds(1);
	}
	
	/*
	 * 应用分类二级导航，使用截图对比测试
	 */
//	@Test
	public void CateMenuTest(){
		
		WebDriver browserCore = be.getBrowserCore();
		
		BufferedImage image_cate = null;
		try {
			image_cate = ImageIO.read(new File("./screenshot/category.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement mainContainer = browserCore.findElement(By.cssSelector(".nav-menu"));
		int pointX=mainContainer.getLocation().getX();
		int pointY=mainContainer.getLocation().getY();
		int Width=mainContainer.getSize().getWidth();
		int Height=mainContainer.getSize().getHeight();		
		
		JavascriptExecutor webdriver = (JavascriptExecutor) browserCore;
//		BufferedImage image[] = new BufferedImage[2];
		webdriver.executeScript("scrollTo(0," + pointY + ")"); 
		Sleeper.sleepTightInSeconds(3);
		BufferedImage image0 = AppUtils.getScreenshot(be);
		BufferedImage outImage = AppUtils.ImageCrop(image0,pointX,0,Width,Height);		
		AppUtils.CompareImage(outImage, image_cate,"category");
		
	}
	
	/*
	 * 应用全部分类列表
	 */
	@Test
	public void CateListTest(){
		
		WebDriver browserCore = be.getBrowserCore();
		//取到应用列表
		WebElement appListMain = browserCore.findElement(By.cssSelector(".main"));
		List<WebElement> list = appListMain.findElements(By.xpath("ul/li"));
		
		//第一屏有28个应用
		String message = String.format("列表应获取%s", list.size());
		Assert.assertTrue(message, list.size() >= 28);
		
		//判断所有应用链接不为空
		for(WebElement result : list){
			
			WebElement innerEle = null;
			try {
				innerEle = result.findElement(By.xpath("div/div/a[2]"));
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
