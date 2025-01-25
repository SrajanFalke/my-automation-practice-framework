package com.ui.dataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.ui.utility.CsvReaderUtility;
import com.ui.utility.ExcelReaderUtility;

public class LoginDataProvider {

//	creating a method for reading the data from the testdata.json

	@DataProvider(name = "LogInDataProviders")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson = new Gson(); // creating an object for Gson class qk ye 3rd party libs hume json
								// representation ko java mai convert karti hai.
		File testDataFile = new File(System.getProperty("user.dir") + "\\testData\\testdata.json");
		FileReader ReadFile = new FileReader(testDataFile);
		TestData data = gson.fromJson(ReadFile, TestData.class); // here readfile is mapping into TestData.class
																	// Deserilazation json to jave object

		List<Object[]> dataToReturn = new ArrayList<Object[]>(); // this is for what we are retrieving the list of data
																	// in array format.

		for (User userData : data.getData()) {
			dataToReturn.add(new Object[] { userData });
		}
		return dataToReturn.iterator();
	}

	@DataProvider(name = "LogInDataCSVProviders")
	public Iterator<User> loginCSVdataprovider() {
		return CsvReaderUtility.readCSVFile("loginData.csv");
	}

	@DataProvider(name = "LogInDataExcelProviders")
	public Iterator<User> loginExceldataprovider() {
		return ExcelReaderUtility.readExcel("CopyofExcelLoginData.xlsx");
	}

}
