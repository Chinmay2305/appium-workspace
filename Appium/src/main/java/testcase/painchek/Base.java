package testcase.painchek;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> driver;

	public static void initializeDriver(String Appname) throws IOException, InterruptedException {
		if (driver == null) {
			String filePath = System.getProperty("user.dir")
					+ ("\\src\\main\\java\\testcase\\painchek\\global.properties");

			// Load properties file
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);

			// Define app and newApp files
			File appDir = new File("src");
			File app = new File(appDir, (String) prop.get(Appname));

			// Initialize DesiredCapabilities object and set desired capabilities
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "5DDAKBJNDIV499CA");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, 60);
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("autoGrantPermissions", true);
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		}
	}

	public static AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}
}