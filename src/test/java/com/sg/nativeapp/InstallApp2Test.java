package com.sg.nativeapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InstallApp2Test {

	public static void main(String[] args) throws MalformedURLException {
	
		File file=new File("apk/Khan Academy_v6.3.0_apkpure.com.apk");
		String apkFilePath= file.getAbsolutePath();

		System.out.println(apkFilePath);
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app",apkFilePath);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		
	}

}
