import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestWebDriver {
	WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Disabled
	@Test
	public void testKeyboardAndMouseInput() throws InterruptedException {
		
		driver.get("https://formy-project.herokuapp.com/keypress");
		Thread.sleep(1000);
		
		WebElement name = driver.findElement(By.id("name"));
		name.click();
		Thread.sleep(1000);
		name.sendKeys("Travis Mong");
		Thread.sleep(1000);
		
		WebElement button = driver.findElement(By.xpath("//*[contains(@id, 'button')]"));
		button.click();
		
	}
	
	@Disabled
	@Test
	public void testAutoComplete() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/autocomplete");
		Thread.sleep(1000);
		
		WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");
		Thread.sleep(1000);
		
		WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
		autocompleteResult.click();
		
	}
	
	@Disabled
	@Test
	public void testScroll() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/scroll");
		Thread.sleep(1000);
				
		WebElement name = driver.findElement(By.id("name"));
		Actions actions = new Actions(driver);
		actions.moveToElement(name);
		Thread.sleep(1000);
		name.sendKeys("Travis Mong");
		Thread.sleep(1000);
		
		WebElement date = driver.findElement(By.id("date"));
		date.sendKeys("01/01/2020");
		Thread.sleep(1000);

	}
	
	@Disabled
	@Test
	public void testSwitchWindow() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(1000);
		
		WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
		newTabButton.click();
		Thread.sleep(1000);
		
		String originalHandle = driver.getWindowHandle();
		
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			Thread.sleep(1000);
		}
		
		driver.switchTo().window(originalHandle);
		Thread.sleep(1000);
		
	}
	
	@Disabled
	@Test
	public void testSwitchAlert() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(1000);
		
		WebElement alertButton = driver.findElement(By.id("alert-button"));
		alertButton.click();
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();	
		alert.accept();
		Thread.sleep(1000);
		
	}
	
	@Disabled
	@Test
	public void testRunJS() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/modal");
		Thread.sleep(1000);
		
		WebElement modalButton = driver.findElement(By.id("modal-button"));
		modalButton.click();
		Thread.sleep(1000);

		WebElement closeButton = driver.findElement(By.xpath("//*[contains(@class,'modal-footer')]//button[text()='Close']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", closeButton);
		Thread.sleep(1000);
		
	}
	
//	@Disabled
	@Test
	public void testDragDrop() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/dragdrop");
		Thread.sleep(1000);
		
		WebElement image = driver.findElement(By.id("image"));
		WebElement box = driver.findElement(By.id("box"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(image, box).perform();
		Thread.sleep(1000);
				
	}
	
	
	@AfterEach
	public void destroy() {
		driver.quit();
	}
	
}
