package com.ui.test;

import static com.contants.Browser.*; //To make it static and we can use my the parameter that we have in Enum class.

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.ui.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	

	
	  @Test(description =
	  "verify that the user is able to login into the application", groups = {
	  "e2e", "smoke" }, dataProviderClass =
	  com.ui.dataProvider.LoginDataProvider.class, dataProvider =
	  "LogInDataProviders") public void loginTest(User user) {
	  
	  assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailId(),
	  user.getPassword()).getName(), "Srajan falke");
	  
	  }
	  
	  @Test(description =
	  "verify that the user is able to login into the application", groups = {
	  "e2e", "smoke" }, dataProviderClass =
	  com.ui.dataProvider.LoginDataProvider.class, dataProvider =
	  "LogInDataCSVProviders") public void loginTestCSV(User user) {
	  
	  assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailId(),
	  user.getPassword()).getName(), "Srajan falke"); }
	 

	@Test(description = "verify that the user is able to login into the application", groups = { "e2e",
			"smoke" }, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LogInDataExcelProviders", retryAnalyzer = com.ui.listeners.MyRetryAnalyser.class)
	public void loginTestExcel(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailId(), user.getPassword()).getName(),
				"Srajan falke");
	}
}
