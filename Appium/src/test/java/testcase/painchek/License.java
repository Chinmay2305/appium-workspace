package testcase.painchek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class License {

	@Test
	public static void license() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // Maximize the browser window

		// Login
		driver.get("https://dev.ap.painchek.com/sign-in");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("painchek@darwindigital.com");
		driver.findElement(By.id("next-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("3xhAVYjHSLxf");
		driver.findElement(By.id("sign-in-button")).click();
		Thread.sleep(5000);
		// Create license
		driver.get("https://dev.ap.painchek.com/licenses/create");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/main/div[2]/div/div/div/div[2]/form/div/div[2]/div[2]/div[2]/div/div[1]/div/div[3]/div"))
				.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000);
		// Click the first "Enterprise" option
		WebElement firstEnterprise1 = driver.findElement(By.xpath("//*[text()='Enterprise']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstEnterprise1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstEnterprise1);
		Thread.sleep(2000);

		// Click the second dropdown
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]"))
				.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);

		// Press Enter
		actions.sendKeys(Keys.ENTER);

		// Perform the actions
		actions.perform();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

		// LICENSE HOLDER DETAILs

		driver.findElement(By.id("license-form-first-name")).click();
		driver.findElement(By.id("license-form-first-name")).sendKeys("Amit");

		driver.findElement(By.id("license-form-last-name")).click();
		driver.findElement(By.id("license-form-last-name")).sendKeys("Test");

		driver.findElement(By.id("license-form-email")).click();
		driver.findElement(By.id("license-form-email")).sendKeys("amit4@darwindigital.com");

		driver.findElement(By.id("license-form-organisation")).click();
		driver.findElement(By.id("license-form-organisation")).sendKeys("Test Organization 04");

		driver.findElement(By.id("country")).click();
		Actions actions1 = new Actions(driver);

		// Send the down arrow key 10 times
		for (int i = 0; i < 15; i++) {
			actions1.sendKeys(Keys.ARROW_DOWN).perform();
		}

		WebElement dashboard1 = driver.findElement(By.xpath("//*[text()='Australia']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dashboard1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dashboard1);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Save Later')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Shared Care')]")).click();

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[9]/div[5]/div[1]/div[1]/div[1]/div[3]/div[1]"))
				.click();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN);

		actions.sendKeys(Keys.ENTER);
		actions.perform();
		driver.findElement(By.id("license-form-client-folder")).click();
		driver.findElement(By.id("license-form-client-folder")).sendKeys("DDTestLicense");
		driver.findElement(By.id("license-form-report-prefix")).click();
		driver.findElement(By.id("license-form-report-prefix")).sendKeys("DDTestLicense");

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/main/div[2]/div/div/div/div[2]/form/div/div[2]/div[10]/div[4]/div/div[1]/div/div[3]/div/input"))
				.click();
		Thread.sleep(2000);

		Actions actions2 = new Actions(driver);
		for (int i = 0; i < 18; i++) {
			actions2.sendKeys(Keys.ARROW_DOWN).perform();
		}
		WebElement dashboard2 = driver.findElement(By.xpath("//*[text()='MiljanVuletic']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dashboard2);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dashboard2);

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/div[2]/button[1]/span[3]"))
				.click();
		Thread.sleep(9000);

		// Create LA user under license
		driver.findElement(By.xpath("//*[@id=\"painchek-wap\"]/div/nav/div[1]/div[2]/div/a[7]/div[2]/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"v-content\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/button"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]"))
				.click();
		Thread.sleep(2000);

		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.perform();
		Thread.sleep(1000);
		driver.findElement(By.id("input-240")).click();
		driver.findElement(By.id("input-240")).sendKeys("LA");

		driver.findElement(By.id("input-242")).click();
		driver.findElement(By.id("input-242")).sendKeys("User");

		// Enter random email for LA user
		driver.findElement(By.id("input-248")).click();
		WebElement emailField1 = driver.findElement(By.id("input-248"));
		String firstEmail = generateRandomEmail(driver, emailField1);

		// Load existing properties
		Properties properties = new Properties();
		String filePath = "src/main/java/testcase/painchek/global.properties";
		File file = new File(filePath);

		try (FileInputStream fis = new FileInputStream(file)) {
			properties.load(fis);

			// Store the first email
			properties.setProperty("email1", firstEmail);

			// Write the updated properties back to the file
			try (FileOutputStream fos = new FileOutputStream(file)) {
				properties.store(fos, "Updated email address");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[3]/div[2]/button[2]")).click();
		Thread.sleep(15000);

		// Create sites
		driver.findElement(By.xpath("//*[@id=\"painchek-wap\"]/div/nav/div[1]/div[2]/div/a[6]/div[2]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"v-content\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/button"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("input-279")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("input-279")).sendKeys("Site 1");
		driver.findElement(By.xpath(
				"//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[2]/div[4]/div[1]/div/div[1]/div/div[3]/div"))
				.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		driver.findElement(
				By.xpath("//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[3]/div[2]/button[2]")).click();
		Thread.sleep(8000);

		driver.findElement(By.id("input-279")).click();
		driver.findElement(By.id("input-279")).sendKeys("Site 2");
		driver.findElement(By.xpath(
				"//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[2]/div[4]/div[1]/div/div[1]/div/div[3]/div"))
				.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		driver.findElement(
				By.xpath("//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[3]/div[2]/button[2]")).click();
		Thread.sleep(6000);

		// Create Admin user
		driver.findElement(By.xpath("//*[@id=\"painchek-wap\"]/div/nav/div[1]/div[2]/div/a[7]/div[2]/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"v-content\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/button"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]"))
				.click();

		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		driver.findElement(By.id("input-345")).click();
		driver.findElement(By.id("input-345")).sendKeys("Admin");

		driver.findElement(By.id("input-347")).click();
		driver.findElement(By.id("input-347")).sendKeys("User");

		// Find the email field for the second email
		WebElement emailField2 = driver.findElement(By.id("input-353"));

		// Reuse the method to generate the second email
		String secondEmail = generateRandomEmail(driver, emailField2);

		try (FileInputStream fis = new FileInputStream(file)) {
			properties.load(fis);

			// Store the second email
			properties.setProperty("email2", secondEmail);

			// Write the updated properties back to the file
			try (FileOutputStream fos = new FileOutputStream(file)) {
				properties.store(fos, "Updated email addresses");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[2]/div[8]/div[3]/div/div/div[1]/div/div[3]/div"))
				.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		driver.findElement(
				By.xpath("//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[3]/div[2]/button[2]")).click();
		Thread.sleep(8000);

		// Create user 3rd
		driver.findElement(By.xpath("//*[@id=\"painchek-wap\"]/div/nav/div[1]/div[2]/div/a[7]/div[2]/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"v-content\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/button"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[2]/div[3]/div/div/div[1]/div/div[3]/div"))
				.click();
		Thread.sleep(4000);

		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.perform();
		Thread.sleep(1000);
		driver.findElement(By.id("input-377")).click();
		driver.findElement(By.id("input-377")).sendKeys("User");

		driver.findElement(By.id("input-379")).click();
		driver.findElement(By.id("input-379")).sendKeys("User");

		// Find the email field for the second email
		WebElement emailField3 = driver.findElement(By.id("input-385"));

		// Reuse the method to generate the second email
		String thirdEmail = generateRandomEmail(driver, emailField3);

		try (FileInputStream fis = new FileInputStream(file)) {
			properties.load(fis);

			// Store the second email
			properties.setProperty("email3", thirdEmail);

			// Write the updated properties back to the file
			try (FileOutputStream fos = new FileOutputStream(file)) {
				properties.store(fos, "Updated email addresses");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[2]/div[8]/div[3]/div/div/div[1]/div/div[3]/div"))
				.click();
		Thread.sleep(3000);
		actions.sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.perform();
		// Click the final button to create the user
		driver.findElement(
				By.xpath("//*[@id=\"v-content\"]/div[2]/div/div/div/div[2]/form/div/div[3]/div[2]/button[2]")).click();
		Thread.sleep(8000);
		driver.quit();

	}

	// Method to generate a random email
	public static String generateRandomEmail(WebDriver driver, WebElement emailField) {
		emailField.click();
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		String email = "amit" + randomNumber + "@darwindigital.com";
		emailField.sendKeys(email);
		return email;
	}

}
