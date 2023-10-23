package com.selenium.pom.testscripts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.pom.data.DataFile;
import com.selenium.pom.pages.HomePage;
import com.selenium.pom.pages.LoginPage;
import com.selenium.pom.pages.UserIndexPage;
import com.selenium.util.DriverUtilities;

public class LogoutTest {
	DriverUtilities driverUtilities;
	WebDriver driver;	
	
	@BeforeEach
	public void setUp() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}
	
	@Test
	public void testLogoutFunctionality() {
		UserIndexPage.usernameDropDown(driver).click();
		if (UserIndexPage.logoutLink(driver).isDisplayed()) {
			UserIndexPage.logoutLink(driver).click();
		}
		
		assertTrue(HomePage.signInButton(driver).isDisplayed());
		
		driver.quit();
	}
	
}
