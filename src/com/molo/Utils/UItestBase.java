package com.molo.Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.molo.dagger.BrowserEmulator;

public class UItestBase {
	
	private static Logger logger = Logger.getLogger(BrowserEmulator.class.getName());
	
	
	/**
	 * 
	 * 延迟时间
	 * 单位：秒
	 * 
	 * */
	public static void pause(int time) {
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time*1000);
			logger.info("Pause " + time + " s");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * UI方法
	 * 适用于元素延迟加载
	 * 
	 * */
	
	protected WebDriverWait wait;

	// 验证异步加载的内容是否存在
	public void waitUntilElementExist(WebDriver driver,By by,Boolean sign){
		ElementExistOrNot  ex = new ElementExistOrNot(by,sign);
		try{
			wait = new WebDriverWait(driver,10);
			Assert.assertTrue(wait.until(ex));
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("找不到指定:"+by);
		}
		
	}
	
	// 返回一个webElement
	public WebElement waitForElement(WebDriver driver,By by){
		waitUntilElementExist(driver,by,true);
		return driver.findElement(by);
	}

	
class ElementExistOrNot implements Function<WebDriver, Boolean>{//第一个参数为apply方法的参数类型，第二个参数为apply方法的返回类型
	    private By by;
	    private Boolean sign;
	    
	    public ElementExistOrNot(By by, Boolean sign) {
	        this.by = by;
	        this.sign = sign;
	    }
	    @Override
	    public Boolean apply(WebDriver driver) {
	        try{
	            WebElement e=driver.findElement(by);
	            if(sign){
	                return true;
	            }else{
	                return false;
	            }
	        }catch (Exception e){
	            if(sign){
	                return false;
	            }else{
	                return true;
	            }
	        }
	    }
	}
}
