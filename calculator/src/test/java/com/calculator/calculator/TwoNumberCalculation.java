package com.calculator.calculator;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwoNumberCalculation extends BaseTest
{
	@Test
	public void Search() throws InterruptedException, IOException
	{
		AppiumDriverLocalService service = new AppiumServiceBuilder().usingAnyFreePort().build();
        service.start();
		
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		WebElement editText = driver.findElement(AppiumBy.className("android.widget.EditText"));
		double n1 = 300;
		Double n2 = 5.0;
//		Double n2 = (Double) null;
		String operation = "/";
		
		String[] digits1 = getDigits(n1);
		for(String digit1:digits1)
		{
			driver.findElement(By.xpath("//android.widget.Button[@text='"+digit1+"']")).click();
		}

		driver.findElement(By.xpath("//android.widget.Button[@text='"+operation+"']")).click();
		
		Double actualanswer=null;
		if(n2==null)
		{
			switch (operation)
			{
			case "\u221A":
				actualanswer = Math.sqrt(n1);
				break;			
			case "1/x":
	             if (n1 != 0)
	             {
	            	 actualanswer = (double) 1 / n1;
	             }
	             else
	             {
	            	 System.out.println("Division by 0 not allowed");
	             }
	             break;
			case "sin":
				actualanswer = Math.sin(Math.toRadians(n1));
				break;
			case "cos":
				actualanswer = Math.cos(Math.toRadians(n1));
				break;
			case "tan":
				actualanswer = Math.round(Math.tan(Math.toRadians(n1)) * 1000000000.0) / 1000000000.0;
				break;
			}
		}
		else
		{
			String[] digits2 = getDigits(n2);
			for(String digit2:digits2)
			{
				driver.findElement(By.xpath("//android.widget.Button[@text='"+digit2+"']")).click();
			}
			
			switch (operation)
			{
			case "+":
				 actualanswer = (double) (n1 + n2);
	             break;
	         case "-":
	             actualanswer = (double) (n1 - n2);
	             break;
	         case "*":
	             actualanswer = (double) (n1 * n2);
	             break;
	         case "/":
	             if (n2 != 0)
	             {
	            	 actualanswer = (double) n1 / n2;
	             }
	             else
	             {
	            	 System.out.println("Division by 0 not allowed");
	             }
	         case "%":
	        	 actualanswer = (double) (n1*n2)/100;
	        	 break;
	         case "^":
	        	 actualanswer = (double) (Math.pow(n1, n2));
	        	 break;
			}
		}
		
		driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();	
		Thread.sleep(3000);
		
		Double printedanswer = Double.parseDouble(editText.getText());
		if(actualanswer.equals(printedanswer))
		{
			createFile(String.valueOf(actualanswer), String.valueOf(printedanswer), "Working fine");
		}
		else
		{
			createFile(String.valueOf(actualanswer), String.valueOf(printedanswer), "Not Working fine");
		}
		
		if(driver!=null)
		{
			driver.quit();
		}
		if(service.isRunning())
		{
			service.stop();
		}
	}
}