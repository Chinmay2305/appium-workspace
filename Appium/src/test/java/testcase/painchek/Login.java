package testcase.painchek;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Login {

	private static AndroidDriver<AndroidElement> driver;
	private static Properties properties = new Properties();
	private static Logger logger = Logger.getLogger("TextViewLogger");

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		// Load properties file
		String filePath = "src/main/java/testcase/painchek/global.properties";
		FileInputStream fis = new FileInputStream(filePath);
		properties.load(fis);

		Base.initializeDriver("Appname"); // Use Base class to call static method
		driver = Base.getDriver(); // Get the driver instance from Base class and cast it to AndroidDriver
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	@Test
	public void patient() throws InterruptedException, IOException {
		String email = properties.getProperty("email1");
		String password = "Epattech"; // Hardcoded for now

		// For Login
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.findElement(By.id("com.painchek.adult:id/ivSplashActivityTopLogo")).isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, 120);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.Button[contains(@text, 'CONTINUE')]")));
		driver.findElement(By.id("com.painchek.adult:id/btSplashActivityContinue")).click();

		// Find the element you want to long press
		MobileElement element = driver.findElement(By.id("com.painchek.adult:id/ivPainchekLogoUFragment"));

		// Create Actions instance
		Actions actions = new Actions(driver);

		// Perform a long press action
		actions.moveToElement(element).clickAndHold().pause(Duration.ofSeconds(3)) // Long press duration
				.release().perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Development']")).click();

		// Login
		WebElement e1 = driver.findElement(By.id("com.painchek.adult:id/edit_text"));
		e1.click();
		e1.sendKeys(email);
		driver.hideKeyboard();
		driver.findElement(By.id("com.painchek.adult:id/btnNextUFragment")).click();

		driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Password')]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Password')]")).sendKeys(password);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER)); // Cast to AndroidDriver allows using pressKey method
		driver.findElement(By.id("com.painchek.adult:id/btnLogInPFragment")).click();

		// Call the action utility method for accept consent form or Activate QSI
		ActionUtil.handleElements(driver);

		// Site selection and logout

		driver.findElement(By.xpath("//android.widget.TextView[@text='Site 1']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Site 2']")).click();

		driver.findElement(By.id("com.painchek.adult:id/bContinueSitesSelectionsFragment")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("com.painchek.adult:id/btn_ok")));
		driver.findElement(By.id("com.painchek.adult:id/btn_ok")).click();
		System.out.println("The login Test case passed");

		// Logout
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Out']")).click();
		driver.findElement(By.id("com.painchek.adult:id/btnYes")).click();
	}
}
