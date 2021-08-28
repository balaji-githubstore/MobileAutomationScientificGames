package com.sg.serverautomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumDefaultServiceStart2 {

	public static void main(String[] args) throws MalformedURLException {

		// always starts with default port 4723
		AppiumDriverLocalService service = null;
		try {
			service = AppiumDriverLocalService.buildDefaultService();

			if (!service.isRunning()) {
				service.start();
			}

			System.out.println(service.isRunning());
			System.out.println(service.getUrl());

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "android");
			cap.setCapability("deviceName", "bala");
			cap.setCapability("app",
					"D:\\B-Mine\\Company\\Company\\Scientific Games3\\appium_workspace\\MobileAutomation\\apk\\Khan Academy_v6.3.0_apkpure.com.apk");

			AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(service, cap);

		} finally {
			service.stop();
		}

	}

}
