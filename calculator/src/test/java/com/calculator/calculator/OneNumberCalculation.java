package com.calculator.calculator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneNumberCalculation extends BaseTest
{
	@Test
	public void Calculate() throws InterruptedException, IOException
	{
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		WebElement editText = driver.findElement(AppiumBy.className("android.widget.EditText"));
		int n = 23;
		String operation = "\u221A";
		//"\u221A" - sqrt
		
		if(n>9)
		{
			String number = Integer.toString(n);
			for(int i=0;i<number.length();i++)
			{
				char digit = number.charAt(i);
				driver.findElement(By.xpath("//android.widget.Button[@text='"+digit+"']")).click();
				Thread.sleep(300);
			}
		}
		else
		{
			driver.findElement(By.xpath("//android.widget.Button[@text='"+n+"']")).click();
		}
		
		driver.findElement(By.xpath("//android.widget.Button[@text='"+operation+"']")).click();	
		driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();	
		Thread.sleep(3000);
		
		Double actualanswer=null;
		switch (operation)
		{
		case "\u221A":
			actualanswer = Math.sqrt(n);
			break;			
		case "1/x":
             if (n != 0)
             {
            	 actualanswer = (double) 1 / n;
             }
             else
             {
            	 System.out.println("Division by 0 not allowed");
             }
             break;
		case "sin":
			actualanswer = Math.sin(Math.toRadians(n));
			break;
		case "cos":
			actualanswer = Math.cos(Math.toRadians(n));
			break;
		case "tan":
			actualanswer = Math.tan(Math.toRadians(n));
			break;
		default:
			System.out.println("Operation not supported");
			break;
		}
		
		Double printedanswer = Double.parseDouble(editText.getText());
		if(actualanswer.equals(printedanswer))
		{
			createFile(String.valueOf(actualanswer), String.valueOf(printedanswer), "Working fine");
		}
		else
		{
			createFile(String.valueOf(actualanswer), String.valueOf(printedanswer), "Not Working fine");
		}
	}
}