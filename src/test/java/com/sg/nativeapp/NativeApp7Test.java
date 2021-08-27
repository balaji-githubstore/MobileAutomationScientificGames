package com.sg.nativeapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp7Test {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (driver.findElementsByXPath("//*[@text='Dismiss']").size() > 0) {
			driver.findElementByXPath("//*[@text='Dismiss']").click();
		}

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		while(driver.findElementsByXPath("//*[@text='Arts and humanities']").size()==0)
		{
			//scroll
			HashMap<String, String> map=new HashMap<>();
			map.put("command", "input touchscreen swipe 1000 1300 1000 1100");
			driver.executeScript("mobile:shell", map);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@text='Arts and humanities']").click();

		
		driver.findElementByXPath("//*[contains(@text,'Asia')]").click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
	}
}
