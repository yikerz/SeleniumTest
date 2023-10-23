package com.selenium.basic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestComponentInteractions {
	WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Disabled
	@Test
	public void testRadioButtons() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/radiobutton");
		
		WebElement radio1 = driver.findElement(By.id("radio-button-1"));
		radio1.click();
		Thread.sleep(1000);
		
		WebElement radio2 = driver.findElement(By.cssSelector("input[value='option2']"));
		radio2.click();
		Thread.sleep(1000);
		
		WebElement radio3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
		radio3.click();
		Thread.sleep(1000);

		
	}
	
	@Disabled
	@Test
	public void testDatePicker() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/datepicker");
		Thread.sleep(1000);
		
		WebElement dateField = driver.findElement(By.id("datepicker"));
		dateField.click();
		Thread.sleep(1000);
		dateField.sendKeys("03/03/2024");
		Thread.sleep(1000);
		dateField.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		
	}
	
	
	@Disabled
	@Test
	public void testDropDown() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/dropdown");
		Thread.sleep(1000);
		
		WebElement dropDownMenu = driver.findElement(By.id("dropdownMenuButton"));
		dropDownMenu.click();
		Thread.sleep(1000);
		WebElement autocompleteItem = driver.findElement(By.id("autocomplete"));
		autocompleteItem.click();
		Thread.sleep(1000);
		
	}

	//	@Disabled
	@Test
	public void testFileUpload() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/fileupload");
		Thread.sleep(1000);
		
		WebElement uploadField = driver.findElement(By.id("file-upload-field"));
		uploadField.sendKeys("src/test/resources/file-to-upload.png");
		Thread.sleep(1000);
		
	}
	
	@AfterEach
	public void destroy() {
		driver.quit();
	}
}
