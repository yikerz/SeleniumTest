package com.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// singleton object (only one instance is allowed at any time)
public class DriverUtilities {
	private static DriverUtilities driverUtilities; //1. private static object
	private WebDriver driver;

	//2. private constructor
	private DriverUtilities() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//3. public method to get instance
	public static DriverUtilities getInstance() {
		if (driverUtilities == null) {
			driverUtilities = new DriverUtilities();
		}
		return driverUtilities;
	}
	
	public WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private void createDriver() {
		String driverName = getDriverName();
		
		switch (driverName) {
		case "google chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalide browser!");
			break;
		}
	}

	private String getDriverName() {
		Properties config = new Properties();
		String driverName = new String();
		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String key : config.stringPropertyNames()) {
			if (key.equals("Browser")) {
				driverName = config.getProperty(key);
			}
		}
		
		return driverName;
	}
	
}
