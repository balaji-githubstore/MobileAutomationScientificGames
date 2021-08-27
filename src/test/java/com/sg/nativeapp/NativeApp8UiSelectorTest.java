package com.sg.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp8UiSelectorTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app","C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		if(driver.findElementsByAndroidUIAutomator("UiSelector().text(\"Dismiss\")").size()>0)
		{
			driver.findElementByAndroidUIAutomator("UiSelector().text(\"Dismiss\")").click();
		}
		
		driver.findElementByAndroidUIAutomator("UiSelector().description(\"Profile tab\")").click();
		
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Sign in\")").click();
		
		driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"address\")").sendKeys("ggg");

		driver.findElementByAndroidUIAutomator("UiSelector().descriptionContains(\"Pass\")").sendKeys("ggg");

		//two uiselector method
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Sign in\").index(0)").click();
		
		String actualText=driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"Sign in\")").getText();
		System.out.println(actualText);
		
		
		
		driver.quit();
	
	}
}










