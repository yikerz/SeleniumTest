package com.selenium.basic;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAdvLocators {
	WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
//	@Disabled
	@Test
	public void testCssSelector() {
		driver.get("https://formy-project.herokuapp.com/");
		
		WebElement logo1 = driver.findElement(By.cssSelector("a#logo"));
		WebElement logo2 = driver.findElement(By.cssSelector("a[id='logo']"));
		
		assertEquals(logo1.hashCode(), logo2.hashCode());
		
		WebElement nav = driver.findElement(By.cssSelector(".navbar.navbar-expand-lg.bg-light"));
		System.out.println(nav.hashCode());
		
	}
	
	
	@AfterEach
	public void destroy() {
		driver.quit();
	}
}
