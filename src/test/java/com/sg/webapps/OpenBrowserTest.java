package com.sg.webapps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OpenBrowserTest {

	public static void main(String[] args) throws MalformedURLException  {
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "C:\\Components\\chromedriver.exe");	//driver detail based on the version
		cap.setCapability("udid", "f43c4160");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.get("https://magento.com/");
		

	
		

	}

}
