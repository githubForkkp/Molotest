package com.molo.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.molo.dagger.BrowserEmulator;
import com.molo.dagger.GlobalSettings;

/**
 * Type的一系列测试
 * @author WeiYating
 */
public class TypeOperations {

	BrowserEmulator be;
	String input = "hello wrold !";
	String inputForIE = "hello";

	@BeforeClass
	public void doBeforeTest() {
		be = new BrowserEmulator();
		CommonFunction.openCaptain(be);
	}

	@Test
	public void typeOperations() {
		CommonFunction.typeOperations(be);
	}

	@Test(dependsOnMethods = "typeOperations")
	public void typeIninput() {
		CommonFunction.typeInInput(be, input);
	}
	
	@Test(dependsOnMethods = "typeIninput")
	public void typeInIframe() {
		if (GlobalSettings.browserCoreType == 3) {
			WebDriver driver = be.getBrowserCore();
			driver.switchTo().frame("ifm");
			WebElement editable = driver.switchTo().activeElement();
			be.inputKeyboard(inputForIE);
			driver.switchTo().defaultContent();
			be.click("//input[@value='提交<iframe>节点文本']");
			be.expectElementExistOrNot(true, "//h1[contains(text(),'" + inputForIE + "')]", 5000);
			be.open("http://" + CommonFunction.ip + ":" + CommonFunction.port + "/type");
		} else {
			CommonFunction.typeInIframe(be, input);
		}
	}

	@AfterClass(alwaysRun = true)
	public void doAfterTest() {
		be.quit();
	}
}
