package com.agastyaa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	
	public String getProperty(String filePath, String key) {
		// Read properties File
		String baseDir = System.getProperty("user.dir");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(baseDir + filePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		String value = "";
		try {
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;

	}

	public String getLocator(String locatorName) throws FileNotFoundException {
		
		//data in key value paire i .e key=HomePage.SEARCHCOMPONENT from locators.properties file se
		// locatorName means propert file me se
		// key
		// Read properties File
		
		
		 String baseDir = System.getProperty("user.dir");
		  
		  FileInputStream fis = new
		 FileInputStream(baseDir+"/src/main/resources/Locators.properties");
		  Properties prop = new Properties();//its like get value from hashtable
		  String value = "";
		   try { prop.load(fis);// file load ho gaye
		  value = prop.getProperty(locatorName); //get data from file.key 
		 } catch (IOException e) {
		  e.printStackTrace(); }
		  
		  return value;
		 

		//return getProperty("/src/main/resources/Locators.properties", locatorName);
		//filepath and key are parameters of getproperty
	}

	/*
	 * public void getConfiguration(String key) { String
	 * baseDir=System.getProperty("user.dir"); return
	 * getProperty(baseDir+"/src/main/resources/config.properties");
	 * 
	 * } public void getLocator1(String locatorNmae) { return
	 * getProperty("/src/main/resources/locators.properties"); } public void
	 * loadExcel() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
