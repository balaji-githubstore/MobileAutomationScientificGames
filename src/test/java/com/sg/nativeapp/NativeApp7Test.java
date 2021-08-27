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

	public static void main(String[] args) throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String page=driver.getPageSource();
		

		if (driver.findElementsByXPath("//*[@text='Dismiss']").size() > 0) {
			driver.findElementByXPath("//*[@text='Dismiss']").click();
		}

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		while(driver.findElementsByXPath("//*[@text='Arts and humanities']").size()==0)
		{
			driver.executeScript("mobile:shell", ImmutableMap.of("command","input touchscreen swipe 1000 1300 1000 1100"));
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@text='Arts and humanities']").click();

		
		String pageSource="";
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		while(driver.findElementsByXPath("//*[contains(@text,'Asia')]").size()==0)
		{
			pageSource=driver.getPageSource();
			
			driver.executeScript("mobile:shell", ImmutableMap.of("command","input touchscreen swipe 1000 1300 1000 1100"));
			
			if(pageSource.equals(driver.getPageSource()))
			{
//				throw new Exception(" element not available");
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[contains(@text,'Asia')]").click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
	}
}
