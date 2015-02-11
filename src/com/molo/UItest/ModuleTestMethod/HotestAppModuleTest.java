package com.molo.UItest.ModuleTestMethod;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HotestAppModuleTest extends PageModuleTestBase {
	
	@Override
	protected void CheckListCount(List<WebElement> list)
	{
		int listCount=0;
//      Assert.assertTrue(list.size() == count,"列表数量不足");
		for(WebElement result : list){
        String apkName = result.getAttribute("data-apk");
        if(apkName != "" && apkName != null){
        	listCount++;
        } 
    }
		Assert.assertTrue(listCount == count, "应用数量不足24个");
	}

}
