package com.molo.Utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.molo.dagger.BrowserEmulator;

public class AppUtils {
	
	/**
	 * 校验元素是否存在
	 * 入参：BrowserEmulator，selector
	 * */
	
	public static void isEleExsit(BrowserEmulator be,String selector){
		WebElement ele = null;
		try{
			 ele = be.getBrowserCore().findElement(By.cssSelector(selector));
		}catch(NoSuchElementException e){
			Assert.assertNotNull(ele,"在查找"+selector+"元素时不存在！！");
		}
	}
	
	/**
	 * 返回WebElement对象 dom方式
	 * 入参：BrowserEmulator，selector
	 * */
	public static WebElement findEle(BrowserEmulator be,String selector){
		JavascriptExecutor JSobj = (JavascriptExecutor)be.getBrowserCore();
		String js = "return document.querySelector("+"\"" +selector +"\""+")";
		return (WebElement) JSobj.executeScript(js);
	}
	
	/**
	 * 校验元素是否存在 dom方式
	 * 入参：BrowserEmulator，selector
	 * */
	public static void isfindEle(BrowserEmulator be,String selector){
		WebElement  ele = findEle(be,selector);
		Assert.assertNotNull(ele);
	}
	
	/**
	 * 执行js
	 * 入参：BrowserEmulator，Js代码块
	 * */
	
	public static void ExecuteJS(BrowserEmulator be,String js){
		JavascriptExecutor JSobj = (JavascriptExecutor)be.getBrowserCore();
		JSobj.executeScript(js);
	}
	
	/**
	 * 避免调用WebDriver click产生错误，实现通过js模拟点击动作
	 * 入参：BrowserEmulator ,selector
	 * */
	
	public static void mouseClick(BrowserEmulator be,String selector){
		String js ="arguments[0].click();";
		JavascriptExecutor JSobj = (JavascriptExecutor)be.getBrowserCore();
		JSobj.executeScript(js, be.getBrowserCore().findElement(By.cssSelector(selector)));
	}
	
	/**
	 * 校验url连接
	 * 
	 * */
	public static void UrlCheck(String url){
		
		if("".equals(url)){
			Assert.fail("Banner对应的url为空！！");
		}
		//协议重复
 		String regx0 = "(http|http:|http:\\/\\/){2,}";
		String regx1 = "(http|http:|http:\\/\\/){1,}$";
		//头部缺少协议
		String regx2 = "^(http){1}";
		
		Pattern r0 = Pattern.compile(regx0);
		Pattern r1 = Pattern.compile(regx1);
		Pattern r2 = Pattern.compile(regx2);
		
		Matcher m0 = r0.matcher(url);
		Matcher m1 = r1.matcher(url);
		Matcher m2 = r2.matcher(url);
		
		
		if(m0.find()||m1.find())
		{
			System.out.println("协议重复需要检查！！"+url);
			Assert.fail("协议重复需要检查！！"+url);
		}
		else if(!m2.find())
		{
			System.out.println("协议缺少需要检查！！"+url);
			Assert.fail("协议缺少需要检查！！"+url);
		}
	}
	
	/**
	 * 
	 * 测试数据
	 * path: /data/items.properties
	 * 
	 * */
	public static Properties getProperties() {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("./data/items.properties");
			prop.load(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public static List<String> getItems(){
		Properties pro = getProperties();
		List<String> list = new ArrayList<String>();
		
		Set<String> set = pro.stringPropertyNames();
		
		
		for(String o : set){
			list.add(o);
		}
		Collections.reverse(list);
		
		return list;
	}
	
	/**
	 * 
	 * 测试数据
	 * path: /data/items.txt
	 * 
	 * */
	public static List<String> getDatas() {
		List<String> list = new ArrayList<String>();
		
		try {
			InputStream file = new FileInputStream("./data/items.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(file,"utf-8"));
			
			String line;
			
			 line = reader.readLine(); // 读取第一行
		        while (line != null) { // 如果 line 为空说明读完了
		            list.add(line);
		            line = reader.readLine(); // 读取下一行
		        }
		        reader.close();
		        file.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 *  两张图片进行对比
	 *  入参：image1、image2、模块名称
	 * */
	public static void CompareImage(BufferedImage image1,BufferedImage image2,String modName)
	{		
		
		int nWidth1 = image1.getWidth();
		int nWidth2 = image2.getWidth();

		if(nWidth1==nWidth2){		
		}
		else {
			//如果对比失败，则保存当前图片
			SaveFailureImage(image1,modName);
			Assert.assertEquals(nWidth1, nWidth2);
		}
		
		int nHeight1= image1.getHeight();
		int nHeight2= image2.getHeight();
		if(nHeight1==nHeight2){
			
		}
		else {
			//如果对比失败，则保存当前图片
			SaveFailureImage(image1,modName);
			Assert.assertEquals(nHeight1, nHeight2);
		}

		for(int i=0;i<nWidth1;i++){
			for(int j=0;j<nHeight1;j++){
			int ooxx1=image1.getRGB(i,j);
			int ooxx2=image2.getRGB(i,j);
			if(ooxx1==ooxx2){	
			}
			else {
				//如果对比失败，则保存当前图片
				SaveFailureImage(image1,modName);
				Assert.assertEquals(ooxx1, ooxx2);
			}
			}
		}
		
	}
	
	/**
	 *  返回屏幕截图
	 *  入参：BrowserEmulator
	 * */
	public static BufferedImage getScreenshot(BrowserEmulator be){
		
		byte fScreen[] = ((TakesScreenshot) be.getBrowserCore()).getScreenshotAs(OutputType.BYTES);
		ByteArrayInputStream in = new ByteArrayInputStream(fScreen);    
		BufferedImage image = null;
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;

	}
	
	/**
	 *  从大图中截取小图
	 *  入参：截取模块的起点、高宽
	 * */
	public static BufferedImage ImageCrop(BufferedImage image, int x,int y,int w,int h){
		  
		BufferedImage outImg=image.getSubimage(x, y, w, h);
		//对图片中一部分区域进行染色
//		Color color=new Color(0xFFFFF0);
//		outImg.getGraphics().setColor(color);
//		outImg.getGraphics().fillRect(0, 0, w, h);
		return outImg;

	}
	
	/**
	 *  保存失败图片
	 *  入参：图片、模块名称
	 * */
	public static void SaveFailureImage(BufferedImage image,String modName){
		
		//模块名_时分秒.jpg
		SimpleDateFormat now = new SimpleDateFormat("MMdd_HH-mm-ss");
		String imagePath = "d:\\UITestResult\\";
		String imageName=String.format(modName+"_%s.png", now.format(new Date()));
		try {
			ImageIO.write(image, "png", new File(imagePath+imageName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 *  将多张图片合成一张
	 *  
	 * */
	public static BufferedImage ImagePaster(BufferedImage image[]){
		
		//取最宽的图片宽度
		int width_max=100;
		for (int i=0;i<image.length;i++)
		{        
			if(image[i].getWidth() > width_max){
			    width_max = image[i].getWidth();
			}
		}
		//取所有图片高度总和
		int height_total=100;
		for (int i=0;i<image.length;i++)
		{          
			height_total += image[i].getHeight();
		}

		//初始化画布
		BufferedImage image0 = new BufferedImage(width_max, height_total, BufferedImage.TYPE_INT_RGB);
		int h=0;
		for (int i=0;i<image.length;i++)
		{          
            image0.getGraphics().drawImage(image[i], 0, h, null);
            h += image[i].getHeight();
		}
		return image0;
		
	}
		
	
}
