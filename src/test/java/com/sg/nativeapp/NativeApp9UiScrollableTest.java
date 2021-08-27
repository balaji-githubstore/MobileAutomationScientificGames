package com.sg.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp9UiScrollableTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (driver.findElementsByAndroidUIAutomator("UiSelector().text(\"Dismiss\")").size() > 0) {
			driver.findElementByAndroidUIAutomator("UiSelector().text(\"Dismiss\")").click();
		}
		
		
		//UiSelector().text("Arts and humanities") 
		
		String visibleText = "Arts";
        driver.findElementByAndroidUIAutomator
        ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
		
        
        visibleText = "Asia";
        driver.findElementByAndroidUIAutomator
        ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
		
	}

}

















