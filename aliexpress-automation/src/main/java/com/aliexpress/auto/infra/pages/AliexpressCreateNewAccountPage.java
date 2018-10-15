package com.aliexpress.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aliexpress.auto.infra.web.ByElement;

public class AliexpressCreateNewAccountPage extends AbstractPage {

	private static final ByElement emailAddress = new ByElement ("Email address field ", By.id("email-ipt"));
	private static final ByElement firstName = new ByElement ("First Name field ", By.id("first-name-ipt"));
	private static final ByElement lastName = new ByElement ("Last Name field ", By.id("last-name-ipt"));
	private static final ByElement createPassword = new ByElement ("Create password field ", By.id("password-ipt"));
	private static final ByElement confirmPassword = new ByElement ("Confirm password field ", By.id("confirm-password-ipt"));
	private static final ByElement enterVerifivationCode = new ByElement ("Enter the code bellow: ", By.xpath("//input[@id='checkcode-ipt']"));
	private static final ByElement verifivationCode = new ByElement ("Confirm password field ", By.xpath("//div/img[@id='checkcode-img']"));
	private static final ByElement createAccountButton = new ByElement("Create your Account", By.xpath("//input[@id='submit-btn']"));

	public AliexpressCreateNewAccountPage(WebDriver driver) {
		super (driver, "New Account registration page", emailAddress,firstName, lastName,createPassword,confirmPassword,enterVerifivationCode,verifivationCode,createAccountButton);
	}
	
	public void enterEmail(String email) {
		bot.writeToElement(emailAddress, email);
	}
	public void enterFirstname(String firstname) {
		bot.writeToElement(firstName, firstname);
	}
	public void enterLastname(String lastname) {
		bot.writeToElement(lastName, lastname);
	}
	public void enterPassword(String password) {
		bot.writeToElement(createPassword, password);
	}
	public void confirmPassword(String passwordConfirmation) {
		bot.writeToElement(confirmPassword, passwordConfirmation);
	}
	public void enterCode(String code) {
		bot.writeToElement(enterVerifivationCode, code);
	}
	public AliexpressAfterRegistrationPage clickCreateAccountButton() {
		bot.click(createAccountButton);
		return new AliexpressAfterRegistrationPage(driver);
	}

}
