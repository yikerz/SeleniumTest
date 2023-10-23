import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestAllTogether {
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
	
	public static void submitForm(WebDriver driver) throws InterruptedException {
		// send keys
		driver.findElement(By.id("first-name")).sendKeys("Travis");
		Thread.sleep(1000);
		driver.findElement(By.id("last-name")).sendKeys("Mong");
		Thread.sleep(1000);
		driver.findElement(By.id("job-title")).sendKeys("Developer");
		Thread.sleep(1000);
		
		// radio button
		driver.findElement(By.id("radio-button-2")).click();
		Thread.sleep(1000);
		
		// checkbox
		driver.findElement(By.id("checkbox-1")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Thread.sleep(1000);
		
		// drop-down menu
		driver.findElement(By.id("select-menu")).click();
		driver.findElement(By.cssSelector("option[value='1']")).click();
		Thread.sleep(1000);
		
		// select date
		driver.findElement(By.id("datepicker")).sendKeys("05/28/2022");
		Thread.sleep(1000);
		driver.findElement(By.id("datepicker")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
	}
	
	public static void waitForAlertBanner(WebDriver driver) throws InterruptedException {
		// explicit wait for reloading page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
	}
	
	public static String getAlertBannerText(WebDriver driver) {
		return driver.findElement(By.className("alert")).getText();
	}
	
//	@Disabled
	@Test
	void testAutomateForm() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/form");
		Thread.sleep(1000);
		
		submitForm(driver);
		
		waitForAlertBanner(driver);
		
		assertEquals("The form was successfully submitted!", getAlertBannerText(driver));
		
	}

}
