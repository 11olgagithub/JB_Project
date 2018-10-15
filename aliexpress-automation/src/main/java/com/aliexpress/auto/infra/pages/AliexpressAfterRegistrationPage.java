package com.aliexpress.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aliexpress.auto.infra.web.ByElement;


public class AliexpressAfterRegistrationPage extends AbstractPage {
	
	private static final ByElement SuccessfullRegistrationVerificationTitle = new ByElement("'You have successfully joined AliExpress' title", By.xpath("//div[contains(text(),', you have successfully joined AliExpress.')]"));


	public AliexpressAfterRegistrationPage(WebDriver driver) {
	
		super(driver, "After-Registration page", SuccessfullRegistrationVerificationTitle);

	}

}
