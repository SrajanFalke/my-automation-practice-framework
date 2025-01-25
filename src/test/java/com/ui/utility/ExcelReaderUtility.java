package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcel(String filename) {

		File file = new File(System.getProperty("user.dir") + "\\testData\\" + filename);
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowiterator;
		Row row;
		Cell emailaddresscell;
		Cell passwordcell;
		User user;
		List<User> userList = null;
		try {
			xssfWorkbook = new XSSFWorkbook(file);
			userList = new ArrayList<User>();
//			To landing on the right sheet
			xssfSheet = xssfWorkbook.getSheet("loginuserdata");
			rowiterator = xssfSheet.iterator();
			rowiterator.next();
			while (rowiterator.hasNext()) {
				row = rowiterator.next();

				emailaddresscell = row.getCell(0);
				passwordcell = row.getCell(1);
				user = new User(emailaddresscell.toString(), passwordcell.toString());
				userList.add(user);
				xssfWorkbook.close();
			}

		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();
	}

}
