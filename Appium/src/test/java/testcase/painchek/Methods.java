package testcase.painchek;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Methods {

	// Generate a random string of characters
	public static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder randomString = new StringBuilder();
		Random rnd = new Random();
		while (randomString.length() < length) {
			int index = (int) (rnd.nextFloat() * characters.length());
			randomString.append(characters.charAt(index));
		}
		return randomString.toString();
	}

	// Perform a left swipe on the screen
	public static void swipeLeft(AppiumDriver<AndroidElement> driver) {
		Dimension size = driver.manage().window().getSize();
		int startX = (int) (size.width * 0.8);
		int endX = (int) (size.width * 0.2);
		int startY = size.height / 2;

		new TouchAction<>(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(endX, startY))
				.release().perform();
	}

	// Perform a scroll up action
	public static void scrollUp(AppiumDriver<AndroidElement> driver) {
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2; // X coordinate remains in the middle of the screen
		int startY = (int) (size.height * 0.8); // Start Y coordinate (near the bottom)
		int endY = (int) (size.height * 0.2); // End Y coordinate (near the top)

		new TouchAction<>(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(startX, endY))
				.release().perform();
	}
}
