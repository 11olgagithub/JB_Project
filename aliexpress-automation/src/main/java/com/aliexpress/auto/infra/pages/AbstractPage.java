package com.aliexpress.auto.infra.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.aliexpress.auto.infra.reports.Reports;
import com.aliexpress.auto.infra.web.ActionBot;
import com.aliexpress.auto.infra.web.ByElement;

public abstract class AbstractPage {
	
	protected WebDriver driver;
	protected ActionBot bot;
	protected String pageName;
	protected ByElement[] pageUnigueElements;
	
	public AbstractPage(WebDriver driver, String pageName,ByElement... pageUniqueElements) {
		this.driver = driver;
		this.pageName = pageName;
		this.pageUnigueElements = pageUniqueElements;
		this.bot = new ActionBot(driver);
	}
	
	public void assertInpage() {
		
		try {
			
			for(ByElement byElement: pageUnigueElements) {
			bot.waitForElementToBeVisible(byElement);
		}
		Reports.report("*** On page: " + pageName + " ***************************** ");
	}
		catch (TimeoutException e) {
			Reports.report("***Not on the expected page: " + pageName + "****************************");
			throw e;
		}
	}


}
