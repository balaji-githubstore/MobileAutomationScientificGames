package com.sg.nativeapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp1Test {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app","C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		if(driver.findElementsByXPath("//*[@text='Dismiss']").size()>0)
		{
			driver.findElementByXPath("//*[@text='Dismiss']").click();
		}
		
		driver.findElementByXPath("//*[@text='Profile']").click();
		
		//click on sign in
		driver.findElementByXPath("//*[@text='Sign in']").click();
		//send username 
		driver.findElementByXPath("//*[contains(@text,'address')]").sendKeys("hello");
		//send password 
		driver.findElementByXPath("//*[@content-desc='Password']").sendKeys("hello123");
		//click on login
		driver.findElementByXPath("(//*[@text='Sign in'])[2]").click();
		//get the error message --> gettext();
		
		String actualText=driver.findElementByXPath("//*[contains(@text,'Invalid')]").getText();
		System.out.println(actualText);
		
		
		driver.quit();
	}

}
