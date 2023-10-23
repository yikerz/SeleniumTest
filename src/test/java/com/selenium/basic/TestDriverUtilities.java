package com.selenium.basic;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.selenium.util.DriverUtilities;


public class TestDriverUtilities {
	private DriverUtilities driverUtilities;
	private WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}
	
	@Test
	public void testBasicCommands() throws IOException {
		driver.manage().window().maximize(); // maximize window
		driver.get("http://www.google.com/");
		driver.navigate().to("http://youtube.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		// get browser info
		String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
		String browserVersion = ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion();
		System.out.println("Browser: " + browserName + " v" + browserVersion);
		
		// taking screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("C:\\Users\\Yik\\Desktop\\srcshot1.png"));
		
	}
	
	@AfterEach
	public void destroy() {
		driver.quit();
	}
}
