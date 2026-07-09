package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SplashPage {

    AndroidDriver driver;

    public SplashPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //======================
    // Locators
    //======================

    private By appTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"My First App\")");
    private By contactsTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTACTS\")");
    private By author = AppiumBy.androidUIAutomator("new UiSelector().text(\"Author: Chinmay Agrawal\")");


    //======================
    // Methods
    //======================

    public boolean isAppTitleDisplayed() {
        return driver.findElement(appTitle).isDisplayed();
    }

    public boolean isContactsDisplayed() {
        return driver.findElement(contactsTitle).isDisplayed();
    }

    public boolean isAuthorDisplayed() {
        return driver.findElement(author).isDisplayed();
    }

    public String getAppTitle() {
        return driver.findElement(appTitle).getText();
    }

    public String getContactsTitle() {
        return driver.findElement(contactsTitle).getText();
    }

    public String getAuthor() {
        return driver.findElement(author).getText();
    }

}