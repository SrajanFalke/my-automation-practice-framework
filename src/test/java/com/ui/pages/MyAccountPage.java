package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By MY_ACCOUNT_DETAILS_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getName() {
		return getVisibleText(MY_ACCOUNT_DETAILS_LOCATOR);
	}

}
