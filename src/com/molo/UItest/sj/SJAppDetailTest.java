package com.molo.UItest.sj;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.molo.Utils.AppUtils;
import com.molo.Utils.UItestBase;
import com.molo.dagger.BrowserEmulator;

public class SJAppDetailTest extends UItestBase{

	BrowserEmulator be;
//	String main_selector;

	@BeforeTest
	public void Before() {
		be = new BrowserEmulator();
		be.open("http://sj.qq.com/myapp/detail.htm?apkName=com.tencent.mm");
		Sleeper.sleepTightInSeconds(1);
	}
	
	@Test
	public void AppInfoTest(){
		
		WebDriver browserCore = be.getBrowserCore();
		//应用名称
		WebElement appName = browserCore.findElement(By.cssSelector(".det-name-int"));
		//广告标示
		WebElement appAdv = browserCore.findElement(By.cssSelector("#J_AdvBox"));
		//分类
		WebElement appCate = browserCore.findElement(By.cssSelector("#J_DetCate"));
		//安装到手机
		WebElement appInstall = browserCore.findElement(By.cssSelector(".det-ins-btn"));

		Assert.assertEquals("微信", appName.getText());
		Assert.assertEquals("无广告", appAdv.getText());
		Assert.assertEquals("社交", appCate.getText());
		String attr = appInstall.getAttribute("ex_url");
		Assert.assertTrue(attr != "" && attr != null);			
		
	} 
	
	@Test
	public void AppOtherInfoTest(){
		
		WebDriver browserCore = be.getBrowserCore();
		//应用简介
		WebElement appIntro = browserCore.findElement(By.cssSelector(".det-intro-tit"));
		//应用截图
		WebElement appImg = browserCore.findElement(By.cssSelector("#picInImgBoxImg0"));
		Assert.assertEquals("应用信息", appIntro.getText());
		String attr = appImg.getAttribute("data-src");
		Assert.assertTrue(attr != "" && attr != null);			
		
	} 
	
	@Test
	public void AppCommentTest(){
		
		

		JavascriptExecutor webdriver = (JavascriptExecutor) be.getBrowserCore();
		webdriver.executeScript("scrollTo(0,2000)"); 
		Sleeper.sleepTightInSeconds(1);
		WebDriver browserCore = be.getBrowserCore();
		//默认展示5条评论
		WebElement commentBox = browserCore.findElement(By.cssSelector("#J_DetShowCommentList"));
		List<WebElement> commentList = commentBox.findElements(By.xpath("li"));
		String message = String.format("实际获取了%s条", commentList.size());
		Assert.assertTrue("列表数量不足，"+message, commentList.size() >= 3);
		//点击查看更多评论
		WebElement commentMore = browserCore.findElement(By.cssSelector("#J_DetCommentShowMoreBtn"));
		commentMore.click();
		Sleeper.sleepTightInSeconds(1);
		//列表评论数变为10
		WebElement commentBox1 = browserCore.findElement(By.cssSelector("#J_DetShowCommentList"));
		List<WebElement> commentList1 = commentBox1.findElements(By.xpath("li"));
		String message1 = String.format("实际获取了%s条", commentList1.size());
		Assert.assertTrue("列表数量不足，"+message1, commentList1.size() >= 5);
		
	} 
//	@Test
//	public void ImagePasterTest(){
		
		
//		BufferedImage imageTest = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
//		BufferedImage image1 = null;
//		try {
//			image1 = ImageIO.read(new File("d:\\image1.jpg"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		BufferedImage image2 = null;
//		try {
//			image2 = ImageIO.read(new File("d:\\image2.jpg"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		AppUtils.ImagePaster(image1,image2);
		
//		WebElement mainContainer = browserCore.findElementByCssSelector("#weeklyRank");
//		int pointX=mainContainer.getLocation().getX();
//		int pointY=mainContainer.getLocation().getY();
//		int Width=mainContainer.getSize().getWidth();
//		int Height=mainContainer.getSize().getHeight();
//		
//		BufferedImage outImage = AppUtils.ImageCrop(image,pointX,pointY,Width,Height);		
//		AppUtils.CompareImage(outImage, image_sub,"weeklyRank");
		
//	}
	
	
	
	@AfterTest
	public void After() {
		be.quit();
	}
	
	
}
