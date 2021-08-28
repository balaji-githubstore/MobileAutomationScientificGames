package com.sg.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp12OpenAppTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		
//		cap.setCapability("appPackage","org.khanacademy.android");
//		cap.setCapability("appActivity","org.khanacademy.android.ui.library.MainActivity");
		
		cap.setCapability("appPackage","com.application.zomato");
		cap.setCapability("appActivity","com.application.zomato.activities.Splash");
		
		cap.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

	}

}
