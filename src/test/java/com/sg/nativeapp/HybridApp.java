package com.sg.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HybridApp {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");

		cap.setCapability("appPackage", "com.ltts.myts");
		cap.setCapability("appActivity", "android.support.customtabs.trusted.LauncherActivity");
		cap.setCapability("chromedriverExecutable", "C:\\Components\\chromedriver.exe"); // driver detail based on the
																							// version

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(driver.getContext());

		Set<String> contexts = driver.getContextHandles();

		for (String context : contexts) {
			System.out.println(context);
			// switch to context
			// logic to check for //*[@id='txtUsername']
			driver.context(context);
			if (driver.findElementsByXPath("//*[@id='txtUsername']").size() > 0) {
				break;
			}
		}

//		driver.context("WEBVIEW_chrome");

		System.out.println(driver.getContext());
		driver.findElementByXPath("//*[@id='txtUsername']").sendKeys("44545");
		driver.findElementByXPath("//*[@id='txtPassword']").sendKeys("44545");
		driver.findElementByXPath("//*[@id='submit']").click();
	}

}
