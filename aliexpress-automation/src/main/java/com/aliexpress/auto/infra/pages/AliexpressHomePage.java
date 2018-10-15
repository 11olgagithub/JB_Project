package com.aliexpress.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aliexpress.auto.infra.web.ByElement;


public class AliexpressHomePage extends AbstractPage {

	private static final ByElement wellcomePopUp = new ByElement("wellcome pop-up", By.xpath("//div[@class='newuser-container']"));
	private static final ByElement closePopUp = new ByElement("close pop-up button",By.xpath("//a[@class='close-layer']"));
	private static final ByElement joinLink = new ByElement("Join link",By.xpath("//a[contains(text(), \"Join\")][1]"));
	private static final ByElement joinFreeButton = new ByElement("join free button",By.xpath("//a[text()='Join Free']"));
	private static final ByElement searchBox = new ByElement("search box",By.id("search-key"));
	private static final ByElement searchButton = new ByElement("search button",By.xpath("//input[@class='search-button']"));

	public AliexpressHomePage(WebDriver driver) {
		super(driver, "AliExpress HomePage", searchBox, searchButton,joinLink,joinFreeButton);

	}

	public void closeWelcomePopUp() {
		//if(driver.findElement(wellcomePopUp) != null)
		//		driver.findElement(closePopUp).click();
		if(wellcomePopUp != null)
		{
			if(bot.isElementDisplayed(wellcomePopUp));
			bot.click(closePopUp);
		}
	}

	public void hoverOverJoinLink() {
		bot.hoverOverElement(joinLink);
	}

	public AliexpressCreateNewAccountPage clickJoinFreeButton() {
		bot.click(joinFreeButton);
		return new AliexpressCreateNewAccountPage(driver);

	}


	public void enterSearchItemToSearchBox(String searchItem) {

		//		WebElement searchBoxElement = driver.findElement(searchBox);
		//		searchBoxElement.sendKeys(searchItem);
		bot.writeToElement(searchBox,searchItem);
	}


	//public void clickOnJoinLink()  

	public AliexpressSearchResultPage clickSearchButton() {	
		bot.click(searchButton);
		return new AliexpressSearchResultPage(driver);
	}

}
