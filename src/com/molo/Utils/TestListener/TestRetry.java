package com.molo.Utils.TestListener;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestRetry implements IRetryAnalyzer{
	
	private static Logger logger = Logger.getLogger(TestRetry.class);
	private int retryCount = 1;
	private static int maxRetryCount;
	private static Properties config;
	
	static {
        
		config = getProperties();
		maxRetryCount = Integer.parseInt(config.getProperty("retryCount", "1"));
		logger.info("maxRunCount=" + (maxRetryCount));
	}

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "running retry for  '" + result.getName() + "' on class " + this.getClass().getName() + " Retrying "
					+ retryCount + " times";
			logger.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}
	
	
	public static Properties getProperties() {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("config.properties");
			prop.load(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
