package com.sg.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeAppTest {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "dinakaranbalaji1");
		caps.setCapability("browserstack.key", "6yXRE4nK1fyvTHWA2kPD");

		// Set URL of the application under test
		caps.setCapability("app", "bs://bd870e7157d2465fb2afe3fbd49ef4491e345be0");

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "Khan Academy Project");
		caps.setCapability("build", "Java Android Automation 1.0");
		caps.setCapability("name", "Sign in Test");

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://hub.browserstack.com/wd/hub"),
				caps);

		/* Write your Custom code here */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (driver.findElementsByXPath("//*[@text='Dismiss']").size() > 0) {
			driver.findElementByXPath("//*[@text='Dismiss']").click();
		}

		driver.findElementByXPath("//*[@text='Profile']").click();
		driver.findElementByXPath("//*[@text='Sign in']").click();
		driver.findElementByXPath("//*[contains(@text,'address')]").sendKeys("hello");
		driver.findElementByXPath("//*[@content-desc='Password']").sendKeys("hello123");
		driver.findElementByXPath("(//*[@text='Sign in'])[2]").click();

		String actualText = driver.findElementByXPath("//*[contains(@text,'Invalid')]").getText();
		System.out.println(actualText);

		// Invoke driver.quit() after the test is done to indicate that the test is
		// completed.
		driver.quit();

	}

}
