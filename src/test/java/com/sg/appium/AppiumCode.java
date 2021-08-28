package com.sg.appium;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumCode {

	public static void main(String[] args) throws InterruptedException, IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
//		cap.setCapability("app", "D:\\B-Mine\\Company\\Company\\Scientific Games3\\appium_workspace\\MobileAutomation\\apk\\Khan Academy_v6.3.0_apkpure.com.apk");

		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");

		cap.setCapability("unlockType", "pattern");
		cap.setCapability("unlockKey", "35968");

		cap.setCapability("autoLaunch", "false");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.startRecordingScreen();

		if (driver.isAppInstalled("org.khanacademy.android")) {
			driver.launchApp();
		} else {
			driver.installApp("C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
		}

		driver.runAppInBackground(Duration.ofSeconds(50));

		Thread.sleep(5000);

		driver.activateApp("org.khanacademy.android");

		System.out.println(driver.getSessionDetails());

		System.out.println(driver.getCurrentPackage());
		System.out.println(driver.currentActivity());

		System.out.println(driver.getDeviceTime());

		System.out.println(driver.getAutomationName());

		System.out.println(driver.isDeviceLocked());
		System.out.println(driver.isBrowser());

		driver.openNotifications();

		String encoded = driver.stopRecordingScreen();

		byte[] decoded = Base64.getDecoder().decode(encoded);
		FileOutputStream file=new FileOutputStream("video/video_"+LocalDate.now().toString()+".mp4");
		file.write(decoded);
		
		file.flush();
		
		driver.quit();

	}

}
