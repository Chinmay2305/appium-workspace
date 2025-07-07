package testcase.painchek;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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

public class P4 {

	private static AppiumDriver<AndroidElement> driver;
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

		// Second Test case start from here

		// Turn off Internet

		// Add patient P4
		driver.findElement(By.id("com.painchek.adult:id/tvAddPatientDBBView")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("P4");
		driver.findElement(By.id("com.painchek.adult:id/ptiLastNameNPFragment")).click();
		Actions action = new Actions(driver);
		String randomString = Methods.generateRandomString(5);
		action.sendKeys(randomString).sendKeys(Keys.ENTER).build().perform();
		driver.hideKeyboard();
		driver.findElement(By.id("com.painchek.adult:id/tvGenderMandatory")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvDateMandatory")).click();
		// Take photo
		// driver.findElement(By.id("com.painchek.adult:id/tvAvatarOptionsNPFragment")).click();
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Take a
		// photo']")).click();
		// driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
		// driver.findElement(By.id("com.android.camera2:id/done_button")).click();

		driver.findElement(By.id("com.painchek.adult:id/tvDateMandatory")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvInstitutionMandatory")).click();
		driver.findElement(By.id("com.painchek.adult:id/ptiWardNPFragment")).click();

		// Perform scroll up
		Methods.scrollUp(driver);
		driver.findElement(By.id("com.painchek.adult:id/bSaveNPFragment")).click();

		/* Create PainChek Assessment for P4 */
		driver.findElement(By.id("com.painchek.adult:id/btn_asses_pain")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbPaincheckOptionSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();

		/* Selection for perform Post Movement Assessment and manual */
		driver.findElement(By.id("com.painchek.adult:id/tbModeTimingPostMovementSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbSecondOptionSelectLeadIn")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();

		/*
		 * Select descriptors: All even descriptors (2nd, 4th, etc for each domain)
		 * 
		 * The face Domain
		 */

		driver.findElement(By.id("com.painchek.adult:id/cheekRaisingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/wrinklingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/pullingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/partingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The face comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();
		Methods.swipeLeft(driver);

		/* The voice domain */
		driver.findElement(By.id("com.painchek.adult:id/reqHelpToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/moaningToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/screamingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/howlingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Voice comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();
		Methods.swipeLeft(driver);

		/* The Movement domain */
		driver.findElement(By.id("com.painchek.adult:id/restlessnessToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/guardingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/abnormalCheckToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Movement comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		Methods.swipeLeft(driver);

		/* The Behaviour domain */
		driver.findElement(By.id("com.painchek.adult:id/verballyOffensiveToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/dislikeToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/confusedToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Behaviour comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		Methods.swipeLeft(driver);

		/* The Activity domain */
		driver.findElement(By.id("com.painchek.adult:id/prolongedRestingToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/routinesToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The Activity comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		Methods.swipeLeft(driver);

		/* The body domain */
		driver.findElement(By.id("com.painchek.adult:id/paleToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/rapidToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/medicalToggle")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).click();
		driver.findElement(By.id("com.painchek.adult:id/edit_text")).sendKeys("The body comment");
		driver.findElement(By.id("com.painchek.adult:id/tvCaptionAssessmentCheck")).click();

		/* Click on display summary */
		driver.findElement(By.id("com.painchek.adult:id/bSummary")).click();

		/* Save Assessment */
		driver.findElement(By.id("com.painchek.adult:id/btn_save")).click();
		driver.findElement(By.id("com.painchek.adult:id/dialog_right_btn")).click();

		/* Create NRS Assessment for P4 */

		driver.findElement(By.id("com.painchek.adult:id/btn_asses_pain")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbNRSOptionSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbNRSAtRestSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/isbNRSLevel")).click();
		driver.findElement(By.id("com.painchek.adult:id/btSaveNRSAssessment")).click();
		driver.findElement(By.id("com.painchek.adult:id/dialog_right_btn")).click();

		/* Adding comment */
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Comments']")))
				.click();
		driver.findElement(By.id("com.painchek.adult:id/activityPatientBtnAddComment")).click();
		driver.findElement(By.id("com.painchek.adult:id/edt_comment")).sendKeys("Comment 4");
		driver.findElement(By.id("com.painchek.adult:id/btSave")).click();

		/* Adding Therapy */
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Pain Relief']")))
				.click();
		driver.findElement(By.id("com.painchek.adult:id/activityPatientBtnAddTherapy")).click();
		driver.findElement(By.id("com.painchek.adult:id/rbTherapyManually")).click();
		driver.findElement(By.id("com.painchek.adult:id/etName")).click();
		driver.findElement(By.id("com.painchek.adult:id/etName")).sendKeys("Heat Pack");
		driver.findElement(By.id("com.painchek.adult:id/etAdditionalRemarks")).click();
		driver.findElement(By.id("com.painchek.adult:id/etAdditionalRemarks")).sendKeys("None");
		driver.findElement(By.id("com.painchek.adult:id/btSave")).click();

		// Kill app
		driver.closeApp();
		/// launch app
		driver.launchApp();

		// Turn on Internet

		// Regular login by secondary user
		String email = properties.getProperty("email2");
		String password = properties.getProperty("password");
		driver.findElement(By.id("com.painchek.adult:id/btnRegularSignIn")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Username']")).sendKeys(email);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys(password);
		driver.findElement(By.id("com.painchek.adult:id/btnLogInPFragment")).click();

		// Accept terms and conditions or Setup QSI by Secondary user
		ActionUtil.handleElements(driver);

		// Update user profile details
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='My Profile']")).click();
		driver.findElement(By.id("com.painchek.adult:id/etJobTitle")).sendKeys("Carer");
		driver.findElement(By.id("com.painchek.adult:id/btSave")).click();

		// Search Patient P4
		driver.findElement(By.id("com.painchek.adult:id/tvPatientsDBBView")).click();
		driver.findElement(By.id("com.painchek.adult:id/search_field")).sendKeys("P4");
		driver.findElement(By.id("com.painchek.adult:id/ivOptions")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Edit']")).click();

		driver.findElement(By.id("com.painchek.adult:id/ptiNicknameNPFragment")).click();
		Actions action1 = new Actions(driver);
		action1.sendKeys("Joy").sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("com.painchek.adult:id/tvTitleBarNewPatient")).click();
		Methods.scrollUp(driver);
		driver.findElement(By.id("com.painchek.adult:id/bSaveNPFragment")).click();
		driver.findElement(By.id("com.painchek.adult:id/civPatientAvatar")).click();
		driver.findElement(By.id("com.painchek.adult:id/cbMixedAssessmentAlertCheckBox")).click();
		driver.findElement(By.id("com.painchek.adult:id/tvMixedAssessmentAlertOK")).click();

		// Create Assessment for P4 by secondary user
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

		/* Create NRS Assessment */
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Assessments']")))
				.click();
		driver.findElement(By.id("com.painchek.adult:id/btn_asses_pain")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbNRSOptionSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/btNext")).click();
		driver.findElement(By.id("com.painchek.adult:id/tbNRSAtRestSelect")).click();
		driver.findElement(By.id("com.painchek.adult:id/isbNRSLevel")).click();
		driver.findElement(By.id("com.painchek.adult:id/btSaveNRSAssessment")).click();
		driver.findElement(By.id("com.painchek.adult:id/dialog_right_btn")).click();
		driver.findElement(By.id("com.painchek.adult:id/tBackDashboard")).click();

		System.out.println("The P4 Test case passed ");

	}
}
