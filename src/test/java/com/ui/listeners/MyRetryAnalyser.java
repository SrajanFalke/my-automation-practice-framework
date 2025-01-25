package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.contants.EnviromentSetup;
import com.ui.utility.JsonUtility;
import com.ui.utility.PropertiesFileSetup;

public class MyRetryAnalyser implements IRetryAnalyzer {

	private static final int MAX_NUMBER_OF_ATTEMPTS = 3;
//	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesFileSetup.readProperty(EnviromentSetup.QA, "MAX_NUMBER_OF_ATTEMPTS"));
//	private static final int MAX_NUMBER_OF_ATTEMPTS = JsonUtility.readJson(EnviromentSetup.DEV).getMAX_NUMBER_OF_ATTEMPTS();
	private static int currentAttempts = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempts <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempts++;
			return true;
		}
		return false;
	}

}
