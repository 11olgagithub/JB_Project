package com.aliexpress.auto.infra.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class MainConfig {

	public static String browserType;
	public static String baseURL;
	public static int webdriverImplicitWaitInSeconds;
	public static int webdriverExplicitWaitInSeconds;
	public static boolean closeBrowserAfterTest;
	
	public static void loadConfigFromPropertiesFile (String propertiesFilePath) throws Exception {
		
		Properties property = new Properties();
		InputStream input = new FileInputStream(propertiesFilePath);

		property.load(input);

		browserType = property.getProperty("browser_type");
		baseURL = property.getProperty("base_url");
		webdriverImplicitWaitInSeconds = Integer.parseInt(property.getProperty("webdriver_implicit_wait_in_seconds"));
		webdriverExplicitWaitInSeconds = Integer.parseInt(property.getProperty("webdriver_explicit_wait_in_seconds"));
		closeBrowserAfterTest = Boolean.parseBoolean(property.getProperty("close_browser_after_test"));

	}




}
