package com.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PageBase {
	
	public static Logger logs=null;
	
	public Logger pageLogs() {
		logs = Logger.getLogger(this.getClass());
		String path = (System.getProperty("user.dir")+ "/src/main/resources/" + "/log4jPage.properties");
		PropertyConfigurator.configure(path);
		return logs;
	}

}
