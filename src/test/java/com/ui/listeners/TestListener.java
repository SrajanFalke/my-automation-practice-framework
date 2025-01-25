package com.ui.listeners;

import java.awt.event.ItemListener;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.checkerframework.common.reflection.qual.GetMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.ui.utility.BrowserUtility;
import com.ui.utility.ExtentReporterUtility;
import com.ui.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "" + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + "" + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + "" + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "" + "FAILED");

		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
		logger.info("Capturing the screenshot");

		String screenshot = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Capturing the failed test screenshot in HTML report");

		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshot);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + "" + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "" + "SKIPPED");
	}

	public void onStart(ITestContext context) {
		logger.info("Test execution started");
		ExtentReporterUtility.setUpSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test execution completed");
		ExtentReporterUtility.flushReports();
	}
}
