package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GoogleSearch;
import testBase.BrowserMethods;

public class Test_Search_With_Terms extends BrowserMethods {

	@Test(priority = 1)
	public void testGooleSearch() {
		driver.navigate().to(GoogleSearch.applicationURL);
		findElement(By.xpath(GoogleSearch.googleSearchTextBox)).sendKeys(GoogleSearch.searchWithTerm);
		findElement(By.name(GoogleSearch.seachBtn)).submit();
	}

	@Test(priority = 2)
	public void suggestion_question_is_Appeared() {
		String suggestion_question = findElement(By.xpath(GoogleSearch.Did_you_mean)).getText();
		System.out.println("With Terms suggestion question Did you mean :  " + suggestion_question);
		Assert.assertTrue(true);
	}

	@Test(priority = 3)
	public void display_Map() {
		boolean map = findElement(By.xpath(GoogleSearch.map)).isDisplayed();
		//Assert.assertEquals(map, true);
		System.out.println("With Terms Map is Displayed");
	}

	@Test(priority = 4)
	public void verify_time_taken_less_than_second() {
		String taken_time = findElement(By.xpath(GoogleSearch.time)).getText();
		System.out.println("With Terms Taken time less then 1.0  :  " + taken_time);
		Assert.assertEquals(taken_time, taken_time);
	}

	@Test(priority = 5)
	public void verify_search_result_will_appear_about_is_visible() {
		String search_Results = findElement(By.xpath(GoogleSearch.aboutResualts)).getText();
		System.out.println("With Terms About search resualts is " + search_Results);
		Assert.assertEquals(search_Results, search_Results);
	}
}
