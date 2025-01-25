package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.utility.BrowserUtility;

public class LoginSample {

	public static void main(String[] args) {
		WebDriver wb = new ChromeDriver();
		
		HomePage homePage = new HomePage(wb);
		homePage.maximizeWindow();
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("srajan.falke@gmail.com", "pass@123");
		

		/*
		 * By signInButtonLocator = By.xpath("//a[@class=\"login\"]");
		 * browserUtility.clickOn(signInButtonLocator);
		 * 
		 * By emailIdLocator = By.id("email"); browserUtility.enterText(emailIdLocator,
		 * "srajan.falke@gmail.com");
		 * 
		 * By passwordLocator = By.id("passwd");
		 * browserUtility.enterText(passwordLocator, "pass@123");
		 * 
		 * By SubmitLoginbuttonLocator = By.id("SubmitLogin");
		 * browserUtility.clickOn(SubmitLoginbuttonLocator);
		 */

	}

}
