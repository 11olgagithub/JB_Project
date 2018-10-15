package com.aliexpress.auto.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aliexpress.auto.infra.config.MainConfig;
import com.aliexpress.auto.infra.pages.AliexpressHomePage;
import com.aliexpress.auto.infra.pages.AliexpressSearchResultPage;

public class AliexpressTests extends BaseTest {

	@Test
	public void searchFromMainHomePage() {

		browseToUrl(MainConfig.baseURL);
		String searchItem = "Adidas jacket";

		AliexpressHomePage aliexpresHomePage = new AliexpressHomePage(driver);
		aliexpresHomePage.closeWelcomePopUp();
		aliexpresHomePage.enterSearchItemToSearchBox(searchItem);
		aliexpresHomePage.clickSearchButton();
		AliexpressSearchResultPage aliexpresSearchResultPage = aliexpresHomePage.clickSearchButton();
	}
	
	@Test
	public void Registration() {
		
	}
}


