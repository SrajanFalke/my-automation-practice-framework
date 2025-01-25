package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.contants.EnviromentSetup;

public class PropertiesFileSetup {

	public static String readProperty(EnviromentSetup env, String propertyName) {

		File propFile = new File(System.getProperty("user.dir") + "Properties files\\" + env + ".properties");
		FileReader filereader = null;
		Properties property = new Properties();
		try {
			filereader = new FileReader(propFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			property.load(filereader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = property.getProperty(propertyName.toUpperCase());
		return value;
	}

}
