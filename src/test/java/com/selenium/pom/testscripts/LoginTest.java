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

public class LoginTest {
	DriverUtilities driverUtilities;
	WebDriver driver;	
	
	@BeforeEach
	public void setUp() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
	}
	
	@Test
	public void testLoginFunctionality() {
		driver.get(DataFile.homeURL);
		
		if (HomePage.signInButton(driver).isDisplayed()) {
			HomePage.signInButton(driver).click();
		}
		
		assertEquals(DataFile.loginPageHeader, LoginPage.loginPageHeader(driver).getText());
		
		LoginPage.usernameField(driver).sendKeys(DataFile.usr);
		LoginPage.passwordField(driver).sendKeys(DataFile.psw);
		LoginPage.signInButton(driver).click();
		
		driver.navigate().back();
		
		assertEquals(DataFile.usr, UserIndexPage.usernameDropDown(driver).getText());
						
	}
	
}
