package com.tptrac.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "./data/commondata.property";

	// constructor
	public ReadConfig() {
		try {

		properties = new Properties();

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not sepcified in config file");
	}


  public String getBrowser()
{
	String value = properties.getProperty("browser");

	if(value!=null)
		return value;
	else
		throw new RuntimeException("url not sepcified in config file");
}
}



