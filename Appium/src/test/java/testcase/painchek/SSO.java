package testcase.painchek;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SSO extends Base {
	private static AndroidDriver<AndroidElement> driver;
	private static Properties properties = new Properties();

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		Base.initializeDriver("Appname"); // Use Base class to call static method
		driver = Base.getDriver(); // Get the driver instance from Base class
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		// Load properties file
		try (FileInputStream fis = new FileInputStream("src/main/java/testcase/painchek/global.properties")) {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void create() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.resetApp();
		driver.launchApp();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.Button[contains(@text, 'CONTINUE')]")));
		driver.findElement(By.id("com.painchek.adult:id/btSplashActivityContinue")).click();
		// Long press for Environment selection
		TouchAction action1 = new TouchAction((driver));
		System.out.println();
		MobileElement pn = driver.findElement(By.id("com.painchek.adult:id/ivPainchekLogoUFragment"));
		action1.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(pn)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).release().perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Development']")).click();

		// SSO Login
		WebElement e1 = driver.findElement(By.id("com.painchek.adult:id/edit_text"));
		e1.click();
		e1.sendKeys("la@sso.painchek.com");
		driver.hideKeyboard();
		driver.findElement(By.id("com.painchek.adult:id/btnNextUFragment")).click();
		Methods.scrollUp(driver);
		Thread.sleep(4000);
		List<AndroidElement> editTextElements = driver.findElementsByClassName("android.widget.EditText");

		// Enter data into the first EditText element
		if (editTextElements.size() > 0) {
			editTextElements.get(0).sendKeys("la@sso.painchek.com");
			driver.hideKeyboard();
			driver.pressKey(new KeyEvent(AndroidKey.TAB));
		}

		// Enter data into the second EditText element
		if (editTextElements.size() > 1) {
			editTextElements.get(1).sendKeys("EpatTech123!");

			driver.hideKeyboard();
		}

		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(4000);
		// Activate QSI
		// Call the action utility method
		ActionUtil.handleElements(driver);

		// Site selection
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Bondi Beach']")))
				.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Clovelly']")).click();
		driver.findElement(By.id("com.painchek.adult:id/bContinueSitesSelectionsFragment")).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("com.painchek.adult:id/btn_ok")));
		driver.findElement(By.id("com.painchek.adult:id/btn_ok")).click();

		driver.findElement(By.id("com.painchek.adult:id/tvPatientsDBBView")).click();
		driver.findElement(By.id("com.painchek.adult:id/nameNickNameAndLastName")).click();
		driver.findElement(By.id("com.painchek.adult:id/cbMixedAssessmentAlertCheckBox")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvMixedAssessmentAlertOK")).click();

		// Create Assessment for SSO user
		driver.findElement(By.id("com.painchek.adult:id/btn_asses_pain")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbPaincheckOptionSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();

		/* Selection for perform At Rest Assessment and manual */
		driver.findElement(By.id("com.painchek.adult:id/tbModeTimingPostMovementSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbSecondOptionSelectLeadIn")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();

		// The face domain
		driver.findElement(By.id("com.painchek.adult:id/browLoweringToggle")).click();
		Methods.swipeLeft(driver);

		// The voice domain
		driver.findElement(By.id("com.painchek.adult:id/noisyCheckToggle")).click();
		Methods.swipeLeft(driver);

		// The Movement domain
		driver.findElement(By.id("com.painchek.adult:id/randomMovementToggle")).click();
		Methods.swipeLeft(driver);

		// The Behaviour domain
		driver.findElement(By.id("com.painchek.adult:id/doNotExhibitBehaviourToggle")).click();

		Methods.swipeLeft(driver);

		// The Activity domain
		driver.findElement(By.id("com.painchek.adult:id/doNotExhibitActivityToggle")).click();
		Methods.swipeLeft(driver);

		// The body domain
		driver.findElement(By.id("com.painchek.adult:id/doNotExhibitBody")).click();

		/* Click on display summary */
		driver.findElement(By.id("com.painchek.adult:id/bSummary")).click();

		/* Save Assessment */
		driver.findElement(By.id("com.painchek.adult:id/btn_save")).click();
		driver.findElement(By.id("com.painchek.adult:id/dialog_right_btn")).click();

		System.out.println("SSO Test case passed ");
		driver.closeApp();
	}
}
