package com.aliexpress.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aliexpress.auto.infra.web.ByElement;


public class AliexpressSearchResultPage extends AbstractPage {
	
	private static final ByElement amazonMusicLink = new ByElement("'Amazon Music' Link", By.xpath("//a[text()='Amazon Music']"));

	public AliexpressSearchResultPage(WebDriver driver) {
	super(driver, "Ali-Express search result page");
	}

}
