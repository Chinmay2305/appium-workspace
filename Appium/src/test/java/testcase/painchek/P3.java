package testcase.painchek;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class P3 {

	private static AppiumDriver<AndroidElement> driver;

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		Base.initializeDriver("Appname");
		driver = Base.getDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	@Test
	public void AddPatient() throws InterruptedException {

		// QSI Login
		driver.findElement(By.id("com.painchek.adult:id/civQuickSignInImage")).click();
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin1")).sendKeys("2");
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin2")).sendKeys("5");
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin3")).sendKeys("8");
		driver.findElement(By.id("com.painchek.adult:id/etEnterPin4")).sendKeys("0");

		// Verify resident label from Main Dashboard
		String expectedLabelName = "Residents";
		String actualLabelName = driver.findElementById("com.painchek.adult:id/tvPatientsDBBView").getText();

		if (actualLabelName.equals(expectedLabelName)) {
			System.out.println("Label name is correct for Residents: " + actualLabelName);
		} else {
			System.out.println(
					"Label name is incorrect for the Residents" + expectedLabelName + ", Actual: " + actualLabelName);
		}

		// Verify add patient functionality from Main Dashboard
		driver.findElement(By.id("com.painchek.adult:id/tvAddPatientDBBView")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("P3");
		driver.findElement(By.id("com.painchek.adult:id/ptiLastNameNPFragment")).click();
		Actions action = new Actions(driver);
		String randomString = Methods.generateRandomString(5);
		action.sendKeys(randomString).sendKeys(Keys.ENTER).build().perform();
		driver.hideKeyboard();
		Methods.scrollUp(driver);
		driver.findElement(By.id("com.painchek.adult:id/tvGenderMandatory")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvDateMandatory")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvDateMandatory")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvInstitutionMandatory")).click();
		driver.findElement(By.id("com.painchek.adult:id/ptiWardNPFragment")).click();
		driver.findElement(By.id("com.painchek.adult:id/bSaveNPFragment")).click();

		/* Selection for Painchek and NRS assessment */
		driver.findElement(By.id("com.painchek.adult:id/btn_asses_pain")).click();

		driver.findElement(By.id("com.painchek.adult:id/tbPaincheckOptionSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();

		/* Selection for perform At Rest Assessment and manual */
		driver.findElement(By.id("com.painchek.adult:id/tbModeTimingAtRestSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbSecondOptionSelectLeadIn")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();

		/*
		 * Select descriptors: All odd description (1st, 3rd, 5th, etc for each domain)
		 * 
		 * The face Domain
		 */

		driver.findElement(By.id("com.painchek.adult:id/browLoweringToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/tighteningToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/raisingLipToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/horizontalToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/closingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The face comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		Methods.swipeLeft(driver);

		/* The voice domain */
		driver.findElement(By.id("com.painchek.adult:id/noisyCheckToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/groaningToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/cryingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/loudTalkToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/sighingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Voice comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();
		Methods.swipeLeft(driver);

		/* The Movement domain */
		driver.findElement(By.id("com.painchek.adult:id/randomMovementToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/freezingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/movingAwayToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/pacingCheckToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Movement comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		Methods.swipeLeft(driver);

		/* The Behaviour domain */
		driver.findElement(By.id("com.painchek.adult:id/introvertAToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/aggressiveToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/inappropriateToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/distressedToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Behaviour comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		Methods.swipeLeft(driver);

		/* The Activity domain */
		driver.findElement(By.id("com.painchek.adult:id/restingCareToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/sleepToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Activity comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		Methods.swipeLeft(driver);

		/* The body domain */
		driver.findElement(By.id("com.painchek.adult:id/sweatingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/feverishToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/painfulToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The body comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		/* Click on display summary */
		driver.findElement(By.id("com.painchek.adult:id/bSummary")).click();

		/* Save Assessment */
		driver.findElement(By.id("com.painchek.adult:id/btn_save")).click();
		driver.findElement(By.id("com.painchek.adult:id/dialog_right_btn")).click();

		/* Create NRS Assessment */
		driver.findElement(By.id("com.painchek.adult:id/btn_asses_pain")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbNRSOptionSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbNRSAtRestSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/isbNRSLevel")).click();
		driver.findElement(By.id("com.painchek.adult:id/btSaveNRSAssessment")).click();
		driver.findElement(By.id("com.painchek.adult:id/dialog_right_btn")).click();
		driver.findElement(By.id("com.painchek.adult:id/cbMixedAssessmentAlertCheckBox")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvMixedAssessmentAlertOK")).click();

		/* Adding comment */

		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Comments']")))
				.click();
		driver.findElement(By.id("com.painchek.adult:id/activityPatientBtnAddComment")).click();
		driver.findElement(By.id("com.painchek.adult:id/edt_comment")).sendKeys("Comment 3");
		driver.findElement(By.id("com.painchek.adult:id/btSave")).click();

		/* Adding Therapy */
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Pain Relief']")))
				.click();
		driver.findElement(By.id("com.painchek.adult:id/activityPatientBtnAddTherapy")).click();
		driver.findElement(By.id("com.painchek.adult:id/rbTherapyManually")).click();
		driver.findElement(By.id("com.painchek.adult:id/etName")).click();
		driver.findElement(By.id("com.painchek.adult:id/etName")).sendKeys("Massage");
		driver.findElement(By.id("com.painchek.adult:id/etAdditionalRemarks")).click();
		driver.findElement(By.id("com.painchek.adult:id/etAdditionalRemarks")).sendKeys("None");
		driver.findElement(By.id("com.painchek.adult:id/btSave")).click();
		driver.findElement(By.id("com.painchek.adult:id/tBackDashboard")).click();

		System.out.println("The P3 Test case passed ");
	}
}