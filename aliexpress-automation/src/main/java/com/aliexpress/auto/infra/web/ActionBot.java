package com.aliexpress.auto.infra.web;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aliexpress.auto.infra.config.MainConfig;
import com.aliexpress.auto.infra.reports.Reports;


public class ActionBot {

	private WebDriver driver;
	private WebDriverWait webDriverWait;

	public ActionBot(WebDriver driver) {
		this.driver = driver;
		this.webDriverWait = new WebDriverWait(driver,MainConfig.webdriverExplicitWaitInSeconds);  
	}

	public void click (ByElement byElement) {
		Reports.report("Click on element: " + byElement.description + " (" + byElement.by + ")");
		WebElement element = driver.findElement(byElement.by);
		executeJavaScript("arguments[0].scrollIntoView(true);", element);
	}

	//if(driver.findElement(wellcomePopUp) != null)
	//	driver.findElement(closePopUp).click();

	public void writeToElement(ByElement byElement, String text) {
		Reports.report("Write '" + text + "' to element: " + byElement.description + " (" + byElement.by + ")");
		WebElement element = driver.findElement(byElement.by);
		element.sendKeys(text);
	}

	public String getElementText(ByElement byElement) {
		WebElement element = driver.findElement(byElement.by);
		String text = element.getText();
		Reports.report(byElement.description + " text: '" + text + "'");
		return text;
	}

	public void waitForElementToBeVisible(ByElement byElement) {
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byElement.by));
		Reports.report("Element is visible: " + byElement.description + " (" + byElement.by + ")");
	}

	public void switchToIframe(ByElement byElement) {
		Reports.report("Switch to iframe: " + byElement.description + " (" + byElement.by + ")");
		WebElement iframeElement = driver.findElement(byElement.by);
		driver.switchTo().frame(iframeElement);
	}

	public void switchToIframe(String iframeId) {
		Reports.report("Switch to iframe by ID: " + iframeId);
		driver.switchTo().frame(iframeId);

	}

	public boolean isElementDisplayed(ByElement byElement) {

		List<WebElement> elements = driver.findElements(byElement.by);
		if (elements.size() > 0) {

			boolean displayed = elements.get(0).isDisplayed();
			if (displayed) {
				Reports.report("Element displayed: " + byElement.description + " (" + byElement.by + ")");
				return true;
			}
			else {
				Reports.report("Element is not displayed: " + byElement.description + " (" + byElement.by + ")");
				return false;
			}
		}
		else {
			Reports.report("Element is not displayed: " + byElement.description + " (" + byElement.by + ")");
			return false;
		}

		/*
		try {
			WebElement element = driver.findElement(by2.by);
			return element.isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
		 */
	}

	public void switchToTabByTitle(String tabTitle) throws Exception {

		Reports.report("Switch to tab where title contains: '" + tabTitle + "'");;

		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().contains(tabTitle)) {
				return;
			}
		}

		throw new Exception("There is No tab where title contains: '" + tabTitle + "'");
	}

	public void switchToTabByUrl(String tabUrl) throws Exception {

		Reports.report("Switch to tab where URL contains: '" + tabUrl + "'");;

		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			if (driver.getCurrentUrl().contains(tabUrl)) {
				return;
			}
		}

		throw new Exception("There is No tab where URL contains: '" + tabUrl + "'");
	}

	public void hoverOverElement(ByElement byElement) {

		Reports.report("Hover over element: " + byElement.description + " (" + byElement.by + ")");

		WebElement element = driver.findElement(byElement.by);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void executeJavaScript(String javaScript, WebElement element) {

		((JavascriptExecutor) driver).executeScript(javaScript, element);		
	}
}
