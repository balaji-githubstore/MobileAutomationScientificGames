package com.sg.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class NativeApp10TouchActionUsingCoordTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if (driver.findElementsByXPath("//*[@text='Dismiss']").size() > 0) {
			driver.findElementByXPath("//*[@text='Dismiss']").click();
		}
		
		
		Point p= driver.findElementByXPath("//*[contains(@text,'Sign in')]").getLocation();
		
		System.out.println(p.x);
		System.out.println(p.y);
		
		//527,1313 
		TouchAction action=new TouchAction(driver);
		
//		action.tap(PointOption.point(527,1313)).perform();
//		
//		action.tap(PointOption.point(527,1313)).perform();
//		
//		action.tap(PointOption.point(527,1313)).perform();
//		action.tap(PointOption.point(527,1313)).perform();
		
	    WebElement ele=     driver.findElementByXPath("//*[contains(@text,'Sign in')]");
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(ele)).withTapsCount(5)).perform();
		
		
		action.longPress(PointOption.point(527,1313)).perform();
		
		action.longPress
		(LongPressOptions.longPressOptions()
				.withElement(
						ElementOption.element(ele))
				.withDuration(Duration.ofSeconds(5))).perform();
		
		
				
	}
}







