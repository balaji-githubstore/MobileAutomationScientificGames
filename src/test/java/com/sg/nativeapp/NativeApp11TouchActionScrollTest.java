package com.sg.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NativeApp11TouchActionScrollTest {

	
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

		Thread.sleep(5000);
		
		//527,1313 
		TouchAction action=new TouchAction(driver);
				
		action.press(PointOption.point(989, 1369)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(1005,1096)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
		
		action.press(PointOption.point(989, 1369)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(1005,1096)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
		
		
		action.press(PointOption.point(989, 1369)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(1005,1096)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
		
		action.press(PointOption.point(989, 1369)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(1005,1096)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
		
	}
}








