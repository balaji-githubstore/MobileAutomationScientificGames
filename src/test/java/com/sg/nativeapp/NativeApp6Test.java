package com.sg.nativeapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp6Test {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		if (driver.findElementsByXPath("//*[@text='Dismiss']").size() > 0) {
			driver.findElementByXPath("//*[@text='Dismiss']").click();
		}

		driver.findElementByXPath("//*[@text='Profile']").click();

		driver.findElementByXPath("//*[contains(@text,'Sign up')]").click();

		driver.findElementByXPath("//*[@text='First name']").sendKeys("bala");

		driver.findElementByXPath("//*[@text='Last name']").sendKeys("dina");

		driver.findElementByXPath("//*[@text='Birthday']").click();

		while (!driver.findElementByXPath("//*[@resource-id='android:id/numberpicker_input']").getText().equals("02")) {
			driver.findElementByXPath("//*[@resource-id='android:id/numberpicker_input']").click();
			driver.findElementByXPath("//*[@resource-id='android:id/numberpicker_input']").clear();
			driver.findElementByXPath("//*[@resource-id='android:id/numberpicker_input']").sendKeys("02");
		}

		while (!driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").getText().equals("Aug")) {
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").click();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").clear();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").sendKeys("Aug");
		}

		driver.findElementByXPath("//*[@text='OK']").click();

		driver.findElementByXPath("//*[@text='Email address']").sendKeys("hello@gmail.com");

		driver.findElementByXPath("//*[@text='Password']").sendKeys("king123");

		driver.findElementByXPath("//*[@text='CREATE']").click();

		Thread.sleep(5000);
		driver.quit();
	}
}
