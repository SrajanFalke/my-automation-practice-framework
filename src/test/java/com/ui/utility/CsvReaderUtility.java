package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CsvReaderUtility {
	public static Iterator<User> readCSVFile(String filename) {

		File csvFile = new File(System.getProperty("user.dir") + "\\testData\\"+ filename);
		FileReader filereader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		User userdata;
		try {
			filereader = new FileReader(csvFile);
			csvReader = new CSVReader(filereader);
			csvReader.readNext(); // Row---->1

			userList = new ArrayList<User>();
			
			while ((line = csvReader.readNext()) != null) {
				userdata = new User(line[0], line[1]);
				userList.add(userdata);
			}

			/*
			 * for (User user : userList) { System.out.println(user); }
			 */

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
