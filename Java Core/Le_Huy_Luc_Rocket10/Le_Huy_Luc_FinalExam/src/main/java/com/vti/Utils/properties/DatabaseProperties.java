package com.vti.Utils.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {

	public static final String RESOURCE_FOLDER_URL = "C:\\Users\\ASUS\\Desktop\\luc.lehuy\\Java Core\\Le_Huy_Luc_FinalExam\\src\\main\\java\\resources\\";

	private Properties properties;

	public DatabaseProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(RESOURCE_FOLDER_URL + "database.properties"));
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
