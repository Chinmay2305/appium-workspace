//Open particular app page/activity directly using app package and activity name
package chinmay;

import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.android.Activity;

public class Section7_41_OpenParticularAppPage extends BaseTest
{
	@Test
	public void Miscellaneous()
	{
		//APP PACKAGE - APP NAME - only 1 package name always, for all screens
		//APP ACITVITY - each page is "one activity"
		//Open app directly on an activity - Preference/3. Preference Dependencies
		
		//To find these parameters - package and activity name, first open desired page in android studio emulator. Then type following in CMD:
		//adb shell dumpsys window | findstr "mCurrentFocus"
		
		Activity a = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
//		driver.startActivity(a);		
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
	}
}