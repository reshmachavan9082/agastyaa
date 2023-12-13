package com.agastyaa.config;

import com.agastyaa.utilities.FileUtil;

public class Configuration {
	
	public String getAppUrl(String env) {
		FileUtil file = new FileUtil();//generic
		return file.getProperty("/src/main/resources/config.properties","app."+env+".url");
		
	}

	public String getBrowserName() {
		FileUtil file = new FileUtil();
		//return file.getConfiguration("browser-name");
		return null;
	}
}
