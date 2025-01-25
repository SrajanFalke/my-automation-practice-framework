package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.contants.EnviromentSetup;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Enviroments;

public class JsonUtility {

	public static String readJson(EnviromentSetup env) {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + "\\Properties files\\Config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Enviroments enviroments = config.getEnviroments().get("QA");
		return enviroments.getUrl();

	}

}
