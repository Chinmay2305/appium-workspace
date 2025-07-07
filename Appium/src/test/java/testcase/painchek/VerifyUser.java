package testcase.painchek;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VerifyUser {

	@Test
	public static void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // Maximize the browser window

		// Login
		driver.get("https://mailtrap.io/signin");
		driver.findElement(By.id("user_email")).click();
		driver.findElement(By.id("user_email")).sendKeys("javier@darwindigital.com");
		driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("user_password")).click();
		driver.findElement(By.id("user_password")).sendKeys("kloklo99");
		driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[2]/div[3]/input")).click();
		Thread.sleep(6000);

		driver.findElement(
				By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]/a"))
				.click();
		Thread.sleep(6000);

		// Load existing properties
		Properties properties = new Properties();
		String filePath = "src/main/java/testcase/painchek/global.properties";
		File file = new File(filePath);

		try (FileInputStream fis = new FileInputStream(file)) {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Activate multiple emails one by one
		activateEmail(driver, properties.getProperty("email1"));
		activateEmail(driver, properties.getProperty("email2"));
		activateEmail(driver, properties.getProperty("email3"));

		// Close the browser
		driver.quit();
	}

	public static void activateEmail(WebDriver driver, String email) throws InterruptedException {
		// Locate the input box using XPath
		WebElement inputBox = driver
				.findElement(By.xpath("//*[@id='falconApp']/div/div[2]/div/div[1]/div[1]/div[1]/input"));

		// Click the input box to make it active
		inputBox.click();

		// Clear any pre-existing value in the input box
		inputBox.clear();

		// Send the email value and press Enter
		inputBox.sendKeys(email + Keys.ENTER);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='falconApp']/div/div[2]/div/div[1]/div[2]/ul/li/a")).click();

		Thread.sleep(4000);

		WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@src, 'blob:https://mailtrap.io')]"));
		driver.switchTo().frame(iframeElement);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement activateButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Activate your account')]")));

		// Click on the element
		activateButton.click();
		Thread.sleep(4000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		// Switch to the new tab
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("input-4")).click();
		driver.findElement(By.id("input-4")).sendKeys("Epattech");
		driver.findElement(By.id("input-6")).click();
		driver.findElement(By.id("input-6")).sendKeys("Epattech");

		WebElement activateButton1 = driver.findElement(By.xpath("//button[contains(., 'Activate')]"));

		// Click on the button
		activateButton1.click();
		// Add a 3 second wait after activation
		Thread.sleep(3000);

		// Close the new tab and switch back to the original tab
		driver.close();
		driver.switchTo().window(tabs.get(0));

		// Optionally, navigate back to the main page if necessary
		driver.navigate().refresh();
		Thread.sleep(4000);

	}
}