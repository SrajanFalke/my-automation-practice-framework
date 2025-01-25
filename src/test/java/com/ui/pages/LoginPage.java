package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_ID_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailId, String password) {
		enterText(EMAIL_ID_TEXT_BOX_LOCATOR, emailId);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);

		MyAccountPage myaccountPage = new MyAccountPage(getDriver());
		return myaccountPage;
	}
}
