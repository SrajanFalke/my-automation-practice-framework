package com.ui.test;

import static com.contants.Browser.*; //To make it static and we can use my the parameter that we have in Enum class.

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginSample3 {
	HomePage homePage;

	@BeforeMethod(description = "navigate to the homepage with the browser")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}

	@Test(description = "verify that the user is able to login into the application", groups = { "e2e", "smoke" })
	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWith("srajan.falke@gmail.com", "pass@123").getName(),
				"Srajan falke");

	}

}
