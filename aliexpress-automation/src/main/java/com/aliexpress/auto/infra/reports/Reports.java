package com.aliexpress.auto.infra.reports;

import org.testng.Reporter;

import com.aliexpress.auto.infra.reports.extent.ExtentReporter;

public class Reports {
	public static void report(String message) {
		CliReporter.report(message);
		Reporter.log(message);

	}
	public static void fail(String message) {
		CliReporter.fail(message);
	}

	public static void error(String message) {
		CliReporter.error(message);
	}
	public static void warning(String message) {
		CliReporter.warning(message);

	}
	public static void addScreenshotToReport(String screenshotPath, String title) throws Exception {
		
		CliReporter.report( "[ADD SCREENSHOT]: '" +  title + "' - " + screenshotPath );
		ExtentReporter.addScreenshotToReport(screenshotPath, title);
	}
}
