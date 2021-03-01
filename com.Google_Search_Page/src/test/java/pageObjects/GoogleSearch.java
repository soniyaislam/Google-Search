package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearch {

	public static String applicationURL="https://www.google.com/";
	public static String googleSearchTextBox="//input[@name='q']";
	public static String searchWithTerm="Open AND Clinica";
	public static String searchWithOutTerm="Open Clinica";
	public static String Did_you_mean="//a[@class='gL9Hy']";
	public static String  map="//*[@id='dimg_20']";
	//public static String map = "//img[@alt='Map of Open AND Clinica']";
	public static String search_Resualt ="//div[@id='result-stats']";
	public static String aboutResualts ="//*[@id='result-stats']";
	public static String seachBtn="btnK";
	public static String time="//*[@id='result-stats']/nobr";

}
