package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtils {
	public static FileInputStream fis = null;
	public static Properties prop = null;

	public static String readProperties(String key) throws Exception {

		fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");

		prop = new Properties();
		prop.load(fis);

		return prop.getProperty(key);
	}

	
}
