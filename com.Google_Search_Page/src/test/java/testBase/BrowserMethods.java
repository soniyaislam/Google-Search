package testBase;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extentReport;
	public static ExtentHtmlReporter extentHtmlReporter;
	public ExtentTest extentTest;
	
	
	
	
	
	@BeforeSuite
	//@Parameters("browser")
	//public void beforeSuite(String browser) {
		public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		/*if (browser.equalsIgnoreCase("chrome")) { 
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else  if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
			//As i am getting error in ff
			//WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
		}*/

		
		wait = new WebDriverWait(driver, 10);

		driver.manage().window().maximize();

		extentReport = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + File.separator + "Reports"
				+ File.separator + "ApplicationStatusReport_"
				+ new SimpleDateFormat("dd_MM_YYY_HH_mm").format(new Date()) + ".html"));
		extentHtmlReporter.config().setDocumentTitle("Application status");
		extentHtmlReporter.config().setTheme(Theme.DARK);
		extentHtmlReporter.config().setReportName("Application status");
		extentHtmlReporter.config().setTimeStampFormat("dd/MM/YYYY");
		extentReport.attachReporter(extentHtmlReporter);
	}

	@BeforeMethod
	public void beforeMethods(Method method) {
		extentTest = extentReport.createTest(method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass("APPLICATION IS RUNNING AND WORKING FINE...");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail("SOME ISSUE WITH APPLICATION NEED TO CHECK...");
			extentTest.addScreenCaptureFromPath(captureScreenshot(result.getName()));
		}
	}

	@AfterSuite
	public void afterSuite() {
		extentReport.flush();
		driver.quit();
	}

	public WebElement findElement(By value) {
		wait.until(ExpectedConditions.presenceOfElementLocated(value));
		return driver.findElement(value);
	}

	public String captureScreenshot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + name
				+ new SimpleDateFormat("dd_MM_YYYY_HH_mm").format(new Date()) + ".jpg";
		FileUtils.copyFile(srcFile, new File(path));

		return path;
	}

	public void captureLog(String value) {
		extentTest.info(value);
	}

}
