package com.nt.utilityfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {

	public static String readFromProperties(String key) throws IOException {
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream("./src/test/resources/Configuration.properties");
		pro.load(file);
        String data = pro.getProperty(key);
        return data;
	}
}
