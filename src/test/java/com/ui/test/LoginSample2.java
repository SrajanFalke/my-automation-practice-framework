package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.utility.BrowserUtility;

public class LoginSample2 {

	public static void main(String[] args) {
		WebDriver wb = new ChromeDriver();
		
		BrowserUtility browserUtility = new BrowserUtility(wb);
		browserUtility.goToWebSite("http://www.automationpractice.pl");
		browserUtility.maximizeWindow();
		

		By signInButtonLocator = By.xpath("//a[@class=\"login\"]");
		browserUtility.clickOn(signInButtonLocator);

		By emailIdLocator = By.id("email");
		browserUtility.enterText(emailIdLocator, "srajan.falke@gmail.com");

		By passwordLocator = By.id("passwd");
		browserUtility.enterText(passwordLocator, "pass@123");

		By SubmitLoginbuttonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(SubmitLoginbuttonLocator);

	}

}
