package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ContactPage
{
	AndroidDriver driver;

    public ContactPage(AndroidDriver driver)
    {
    	this.driver = driver;
    }
    
    // Create Contact
    private By title = AppiumBy.androidUIAutomator("new UiSelector().text(\"Create Contact\")");
    private By txtName = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
    private By spinnerCountry = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Spinner\")");
    private By txtPhone = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)");
    private By txtEmail = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
    private By btnSave = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")");
    
    private By lblName = AppiumBy.androidUIAutomator("new UiSelector().text(\"Name:\")");
    private By lblPhone = AppiumBy.androidUIAutomator("new UiSelector().text(\"Phone:\")");
    private By lblEmail = AppiumBy.androidUIAutomator("new UiSelector().text(\"Email:\")");
    
    private By btnEdit =AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
    private By btnDelete =AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(2)");
    private By txtSearch =AppiumBy.className("android.widget.EditText");
    
    public void enterName(String name)
    {
    	driver.findElement(txtName).clear();
        driver.findElement(txtName).sendKeys(name);
    }
    private By countryCode(String code)
    {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + code + "\")");
    }
    public void selectCountry(String countryCode)
    {
        driver.findElement(spinnerCountry).click();

        driver.findElement(countryCode(countryCode)).click();
    }
    public void enterPhone(String phone)
    {
    	driver.findElement(txtPhone).clear();
        driver.findElement(txtPhone).sendKeys(phone);
    }
    public void enterEmail(String email)
    {
    	driver.findElement(txtEmail).clear();
    	driver.findElement(txtEmail).sendKeys(email);
    }
    public void clickSave()
    {
    	driver.findElement(btnSave).click();
    }
    public void clickEdit()
    {
        driver.findElement(btnEdit).click();
    }
    public void clickDelete()
    {
    	driver.findElement(btnDelete).click();
    }
    
    public void addContact(String name,String country,String phone,String email)
    {
    	enterName(name);
        selectCountry(country);
        enterPhone(phone);
        enterEmail(email);
        clickSave();
    }
    
    public void editContact(String newName,String country,String phone,String email)
    {
    	clickEdit();
        enterName(newName);
        selectCountry(country);
        enterPhone(phone);
        enterEmail(email);
        clickSave();
    }
    
    public void deleteContact()
    {
    	clickDelete();
    }
    
    public void searchContact(String keyword)
    {
    	driver.findElement(txtSearch).clear();
        driver.findElement(txtSearch).sendKeys(keyword);
    }
    
    public void clearSearch()
    {
    	driver.findElement(txtSearch).clear();
    }
    
    public boolean isContactPresent(String name, String phone, String email)
    {
    	By namelocator = AppiumBy.androidUIAutomator("new UiSelector().text(\""+name+"\")");
        return driver.findElement(namelocator).isDisplayed();
    }
    
    public boolean isPhonePresent(String phone)
    {
    	By locator = AppiumBy.androidUIAutomator("new UiSelector().text(\""+phone+"\")");
        return driver.findElement(locator).isDisplayed();
    }
    
    public boolean isEmailPresent(String email)
    {
    	By locator = AppiumBy.androidUIAutomator("new UiSelector().text(\""+email+"\")");
        return driver.findElement(locator).isDisplayed();
    }
    
    public boolean isContactDeleted(String name)
    {
    	try
    	{
    		By locator = AppiumBy.androidUIAutomator("new UiSelector().text(\""+name+"\")");
            driver.findElement(locator);
            return false;
        }
        catch(Exception e)
    	{
        	return true;
        }
    }
}