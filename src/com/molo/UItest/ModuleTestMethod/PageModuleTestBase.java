package com.molo.UItest.ModuleTestMethod;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class PageModuleTestBase {
	
	public String maincon_selector;
	public String list_selector;
	public String detail_selector;
	public int count;//列表数量
	
	
	public void Test(WebDriver browserCore)
	{
		WebElement mainContainer = this.FindContainer(browserCore);
		if(mainContainer == null)
		{
			System.out.printf("can not find the element %s",maincon_selector);
		}
		Assert.assertTrue(mainContainer != null,"无法找到模块");

		List<WebElement> list = this.FindElements(mainContainer);
		if(list == null){
			System.out.printf("can not find the elements %s", list_selector);
		}
		Assert.assertTrue(list != null,"无法找到列表");
		//校验列表、应用详情
		this.CheckListCount(list);
		this.CheckListAppDetail(list);
	}
	
	//返回要校验的模块
	protected WebElement FindContainer(WebDriver browserCore)
	{		
		return browserCore.findElement(By.cssSelector(maincon_selector));
	}
	
	//返回模块中的列表
	protected List<WebElement> FindElements(WebElement mainContainer)
	{		
		return mainContainer.findElements(By.xpath(list_selector));
	}
	
	//校验列表的数量
	protected void CheckListCount(List<WebElement> list)
	{
		String message1 = String.format("实际获取%s", list.size());
		Assert.assertTrue(list.size() == count,"列表数量不足，"+message1);
	}
	
	//校验应用名称
	protected void CheckListAppDetail(List<WebElement> list)
	{
		int appCount=0;
		for(WebElement result : list){
			//取应用详情中的应用名称，应用详情路径自传
			WebElement innerEle = null;
			try {
				innerEle = result.findElement(By.xpath(detail_selector));
			}
			catch(NoSuchElementException ex)
			{
				//允许存在非应用的li
				//ex.printStackTrace();
			}
			
			if(innerEle == null)
			{
				continue;
			}			
			
            String attr = innerEle.getAttribute("data-title");
    		if(attr != "" && attr != null){
    			appCount++;
    		}
		}
    		String message = String.format("data-title应获取%d个，实际获取%d个", count,appCount);
    		Assert.assertTrue(appCount == count,message);	
	}	
	
}
