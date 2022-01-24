package com.clearcode.nativeapps;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NativeApp5ZoomTest2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "60d899e5");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);

		 TouchAction touch1=new TouchAction(driver);
		 TouchAction touch2=new TouchAction(driver);

		 touch1.longPress(PointOption.point(500, 950))
		 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		 .moveTo(PointOption.point(500, 600));

		 touch2.longPress(PointOption.point(500, 1200))
		 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		 .moveTo(PointOption.point(500, 1700));

		 MultiTouchAction multi=new MultiTouchAction(driver);
	
//		 multi.add(touch1).add(touch2).perform();
		 
		 for(int i=1;i<=3;i++)
		 {
			 multi.add(touch1).add(touch2).perform();
		 }
		
	}

}
