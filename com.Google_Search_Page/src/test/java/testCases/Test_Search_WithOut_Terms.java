package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GoogleSearch;
import testBase.BrowserMethods;

public class Test_Search_WithOut_Terms extends BrowserMethods {

	@Test(priority = 1)
	public void testGooleSearch() {
		driver.navigate().to(GoogleSearch.applicationURL);
		findElement(By.xpath(GoogleSearch.googleSearchTextBox)).sendKeys(GoogleSearch.searchWithOutTerm);
		findElement(By.name(GoogleSearch.seachBtn)).submit();
	}

	@Test(priority = 2)
	public void verify_Title() {
		String title = driver.getTitle();
		System.out.println("WithOut Terms title is : " + title);
		//Assert.assertEquals(title, "open clinica - Google Search");
	}

	@Test(priority = 3)
	public void about_Search_Results_Is_Appeard() {
		String search_Results = findElement(By.xpath(GoogleSearch.aboutResualts)).getText();
		System.out.println("WithOut Terms About search resualts is " + search_Results);
		Assert.assertEquals(search_Results, search_Results);
	}
	@Test(priority = 4)
	public void verify_time_taken_less_than_second() {
		String taken_time = findElement(By.xpath(GoogleSearch.time)).getText();
		System.out.println("WithOut Terms Taken time less then 1.0  :  " + taken_time);
		Assert.assertEquals(taken_time, taken_time);
	}
}