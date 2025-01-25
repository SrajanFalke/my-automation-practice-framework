package com.ui.pages;

import static com.contants.EnviromentSetup.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.contants.Browser;
import com.contants.EnviromentSetup;
import com.ui.utility.BrowserUtility;
import com.ui.utility.JsonUtility;
import com.ui.utility.LoggerUtility;

import static com.ui.utility.PropertiesFileSetup.*;

public final class HomePage extends BrowserUtility {
	// Page Object Design Pattern->The way u create classes
	// Rule -final variable locators value should not be changed
	// if variable is final then also is going to be static
	// Class variable
	// It should be private
	// HomePage Constructor can be called when we create object of the child class
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@class=\"login\"]");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // To call the parent constructor from the child constructor
//		goToWebSite(readProperty(QA, "URL"));
		goToWebSite(JsonUtility.readJson(QA));
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSite(JsonUtility.readJson(QA));
	}

	public LoginPage goToLoginPage() { // Page Functions --> To create page functions we need a return type
		logger.info("Clicking on the SignIn button to navigate login page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;

	}

}
