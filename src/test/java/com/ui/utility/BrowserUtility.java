package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.contants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // this is the intance variable
																			// creating to call by a constructor
																			// and because of
	// non primitive it has null value.

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) {
		logger.info("Bworser is launching " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("Invalid Browser Name....Please select Chrome or Edge only");
			System.err.println("No browser is in the list");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--windows-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--headless=old");
				option.addArguments("disable-gpu");
				driver.set(new EdgeDriver(option));
			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}
		}
	}

	public void goToWebSite(String url) {
		logger.info("Url is loading " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Window is maximizing");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By Locator) {
		logger.info("Clicking on this Locator " + Locator);
		WebElement element = driver.get().findElement(Locator);
		element.click();
	}

	public void enterText(By Locator, String texttoEnter) {
		logger.info("Locator is found for " + texttoEnter);
		WebElement element = driver.get().findElement(Locator);
		element.sendKeys(texttoEnter);
	}

	public String getVisibleText(By Locator) {
		WebElement element = driver.get().findElement(Locator);
		logger.info("Element is found successfully " + element.getText());
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date(0);
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timespan = format.format(date);
		String path = System.getProperty("user.dir") + "//ScreenShot//" + name + "-" + timespan + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshorfile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshorfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	public void quit() {
		driver.get().quit();
	}
}
