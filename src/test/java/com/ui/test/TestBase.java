package com.ui.test;

import static com.contants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.contants.Browser;
import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LambdaTestUtility;
import com.ui.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean islambdaTest;
//	private boolean isHeadless = true;

	@Parameters({ "browser", "islambdaTest", "isHeadless" })
	@BeforeMethod(description = "navigate to the homepage with the browser")
	public void setUp(
			@Optional("chrome") String browser,
			@Optional("false") boolean islambdaTest,
			@Optional("true") boolean isHeadless, ITestResult result) {

		this.islambdaTest = islambdaTest;
		WebDriver lambdaDriver;
		if (islambdaTest) {
			lambdaDriver = LambdaTestUtility.initialiselambdaSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
//			Run the test on local machine
			logger.info("navigate to the homepage with the browser");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (islambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			homePage.quit();
		}
	}
}
