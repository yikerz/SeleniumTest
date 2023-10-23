import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestSynchronization {
	WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Disabled
	@Test
	void testImplicitWait() {
		driver.get("https://formy-project.herokuapp.com/autocomplete");
		WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
		autocompleteResult.click();
				
	}
	
	@Disabled
	@Test
	void testExplicitWait() {
		driver.get("https://formy-project.herokuapp.com/autocomplete");
		WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		WebElement autocompleteResult = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("pac-item")));
		autocompleteResult.click();
		
	}
	
	//@Disabled
	@Test
	void testFluentWait() {
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("FDM Group" + Keys.ENTER);
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
																			.withTimeout(Duration.ofSeconds(30))
																			.pollingEvery(Duration.ofSeconds(5))
																			.ignoring(NoSuchElementException.class);
		WebElement foundElement = fluentWait.until(new Function<WebDriver, WebElement>(){

			@Override
			public WebElement apply(WebDriver t) {
				return driver.findElement(By.partialLinkText("Facebook"));
			}
		});
		
		System.out.println(foundElement.getText());
		foundElement.click();
	}
	
	@AfterEach
	public void destroy() {
		driver.quit();
	}

}
