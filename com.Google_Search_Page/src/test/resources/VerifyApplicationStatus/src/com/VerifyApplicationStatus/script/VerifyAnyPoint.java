package com.VerifyApplicationStatus.script;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.VerifyApplicationStatus.helper.BrowserMethods;
import com.VerifyApplicationStatus.variables.AnyPointApplication;

public class VerifyAnyPoint extends BrowserMethods
{
	@Test
	public void testAnyPointApplication()
	{
		driver.navigate().to(AnyPointApplication.applicationURL);

		findElement(By.cssSelector(AnyPointApplication.userNameLocator)).sendKeys(AnyPointApplication.userName);
		captureLog("Application is UP");
		findElement(By.cssSelector(AnyPointApplication.passwordLocator)).sendKeys(AnyPointApplication.password);
		findElement(By.cssSelector(AnyPointApplication.loginButtonLocator)).click();
		Assert.assertTrue(findElement(By.cssSelector(AnyPointApplication.homePageLocator)).isDisplayed());
		captureLog("Application is Accisiable");
	}
}
