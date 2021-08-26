package com.sg.webapps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WebAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException  {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "C:\\Components\\chromedriver.exe");	//driver detail based on the version
		cap.setCapability("udid", "f43c4160");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://magento.com/"); //no time limit
		
		driver.findElementByXPath("//*[text()='Sign in']").click();
		
		driver.findElementByXPath("//*[@id='email']").sendKeys("balaji0017@gmail.com"); //0.5s to check for the presence
	
		driver.findElementByXPath("//*[@id='pass']").sendKeys("balaji@12345");
		
		if(driver.isKeyboardShown())
		{
			driver.hideKeyboard();
		}
		
		//click on continue
		driver.findElementByXPath("//*[@id='send2']").click();
		
		//wait for logout present 
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Log Out']")));
		
		//print the title 
		String title = driver.getTitle();
		System.out.println(title);
		//click on logout
		driver.findElementByXPath("//*[text()='Log Out']").click();
		
		Thread.sleep(5000);
		driver.quit(); 

	}

}



