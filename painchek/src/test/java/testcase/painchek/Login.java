package testcase.painchek;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

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

		System.out.println("Testing In process");
		driver.quit();
		driver.wait(5000);
		System.out.println("Testing done");

	}
}
