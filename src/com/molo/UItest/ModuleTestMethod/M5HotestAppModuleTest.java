package com.molo.UItest.ModuleTestMethod;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class M5HotestAppModuleTest extends PageModuleTestBase {
		
	@Override
	protected void CheckListCount(List<WebElement> list)
	{
		int listCount=0;
		for(WebElement result : list){
        String apkName = result.getAttribute("data-pkgname");
        if(apkName != "" && apkName != null){
        	listCount++;
        } 
    }
		System.out.println(listCount);
		Assert.assertTrue(listCount == count, "应用数量不足24个");
	}

}
