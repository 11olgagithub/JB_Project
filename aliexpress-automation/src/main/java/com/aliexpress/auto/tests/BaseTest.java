package com.aliexpress.auto.tests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.aliexpress.auto.infra.config.MainConfig;
import com.aliexpress.auto.infra.reports.Reports;
import com.aliexpress.auto.infra.reports.extent.ExtentReportsListener;
import com.aliexpress.auto.infra.web.BrowserType;
import com.aliexpress.auto.infra.web.WebDriverFactory;

@Listeners(ExtentReportsListener.class)
public abstract class BaseTest {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		MainConfig.loadConfigFromPropertiesFile("src/main/resources/Config.properties");
	}
	
	@AfterMethod
	public void afterMethod() {
		if(driver != null) {
			driver.quit();
			driver=null;
		}
		
		}
	protected void browseToUrl(String url){
		if(driver == null) {
			BrowserType browserType = BrowserType.valueOf(MainConfig.browserType);
			driver = WebDriverFactory.getWebDriver(browserType);
			
		}
		Reports.report("Browsing to URL: " + url);
		driver.get(url);
		
	}
	
	public static void reportScreenshoot() throws Exception {
		if (driver != null) {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Reports.addScreenshotToReport(screenshotFile.getAbsolutePath(),driver.getTitle());
		}
		else {
			Reports.warning("Can't take screenshot, driver is null...");
		}
	}
	

}
