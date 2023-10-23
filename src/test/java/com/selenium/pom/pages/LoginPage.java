package com.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

		public static WebElement usernameField(WebDriver driver) {
			return driver.findElement(By.name("user_login"));
		}
		
		public static WebElement passwordField(WebDriver driver) {
			return driver.findElement(By.name("user_password"));
		}
		
		public static WebElement signInButton(WebDriver driver) {
			return driver.findElement(By.name("submit"));
		}
		
		public static WebElement loginPageHeader(WebDriver driver) {
			return driver.findElement(By.tagName("h3"));
		}
		
}
