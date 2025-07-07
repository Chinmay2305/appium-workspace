package testcase.painchek;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtil {

	private static Logger logger = Logger.getLogger("TextViewLogger");

	public static void handleElements(WebDriver driver) throws InterruptedException {

		// Initial wait to ensure elements are loaded
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds wait time
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.Button")));

		// For Accept consent form or Activate QSI
		List<WebElement> textViewElements = driver.findElements(By.className("android.widget.Button"));

		// Retry mechanism with a maximum number of attempts
		int attempts = 0;
		int maxAttempts = 3;

		while (attempts < maxAttempts) {
			try {
				// Iterate through elements
				for (WebElement element : textViewElements) {
					// Get text from each element
					String text = element.getText();
					logger.log(Level.INFO, "Text view from element: " + text);

					// Check the text and perform actions
					if (text.equals("CONTINUE")) {
						// Perform actions for CONTINUE button
						performContinueActions(driver);
					} else if (text.equals("ACTIVATE")) {
						// Perform actions for ACTIVATE button
						performActivateActions(driver);
					}
				}
				break; // Exit while loop if successful
			} catch (StaleElementReferenceException e) {
				logger.log(Level.WARNING, "StaleElementReferenceException encountered. Retrying... " + (attempts + 1));
				attempts++;
				Thread.sleep(2000);
				// Re-fetch the elements
				textViewElements = driver.findElements(By.className("android.widget.Button"));
			}
		}

		if (attempts == maxAttempts) {
			logger.log(Level.SEVERE, "Failed to interact with the element after " + maxAttempts + " attempts");
		}
	}

	public static void performContinueActions(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds wait time

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.TextView[@text='PainChek Privacy Policy']"))).click();
		driver.findElement(By.id("com.painchek.adult:id/cbAcceptConsent")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.TextView[@text='PainChek Data Consents']"))).click();
		driver.findElement(By.id("com.painchek.adult:id/cbAcceptConsent")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.TextView[@text='PainChek Terms & Conditions']")))
				.click();
		driver.findElement(By.id("com.painchek.adult:id/cbAcceptConsent")).click();
		driver.findElement(By.id("com.painchek.adult:id/btContinue")).click();

		// Setup QSI
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin1")).sendKeys("2");
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin2")).sendKeys("5");
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin3")).sendKeys("8");
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin4")).sendKeys("0");
		driver.findElement(By.id("com.painchek.adult:id/btn_save")).click();
	}

	public static void performActivateActions(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds wait time
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.painchek.adult:id/btnActivate"))).click();
		logger.log(Level.INFO, "Performed ACTIVATE actions");
	}
}
