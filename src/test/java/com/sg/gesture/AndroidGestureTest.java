package com.synechron.gesture;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;

import io.appium.java_client.android.AndroidDriver;

public class AndroidGestureTest {
	//sms read 
	//scroll
	@Test
	public void swipeAppTest() throws Exception {

		System.out.println(LocalDateTime.now());
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		

		driver.findElementByXPath("//*[@text='Search']").click();
		driver.findElementByXPath("//*[@text='Arts and humanities']").click();

		Thread.sleep(2000);

		
		//working
		HashMap<String, Object> map = new HashMap<>();
		map.put("strategy", "accessibility id");
		map.put("selector", "Art of Asia");
		driver.executeScript("mobile: scroll", map);
		driver.findElementByAccessibilityId("Art of Asia").click();
		
		
		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("strategy", "-android uiautomator");
		map1.put("selector", "UiSelector().text(\"South Asia\")");
		driver.executeScript("mobile: scroll", map1);
		
		
		 System.out.println(driver.executeScript("mobile: batteryInfo"));
		 
		 System.out.println(driver.executeScript("mobile: batteryInfo").toString());
		 System.out.println(driver.executeScript("mobile: deviceInfo"));
		 System.out.println(driver.executeScript("mobile: getDeviceTime"));
		 System.out.println(driver.executeScript("mobile: getPermissions"));
		 
//		 System.out.println(driver.executeScript("mobile: getNotifications"));
		 
		 System.out.println(driver.executeScript("mobile: listSms",ImmutableMap.of("max",1)));
		 
		
		
	}
	
	@Test
	public void firstSMSRead() throws Exception {
		String temp=
			"{items=[{id=19979, address=VX-DOTKTK, person=null, date=1643116034051, read=0, status=-1, type=1, subject=null, body=Vote for the best marching contingent and tableau this Republic Day. Register and vote at www.mygov.in/rd2022 Express yourself!, serviceCenter=+919844047160}], total=18505}";
		
		temp=temp.replaceAll("=", ":");
		temp=temp.replaceAll("body:", "body:\"");
		temp=temp.replaceAll(", serviceCenter:", "\", serviceCenter:");
		
		System.out.println(temp);
		
		JSONObject obj = new JSONObject(temp);
		
		String b=obj.getJSONArray("items").get(0).toString();
		
		JSONObject obj1 = new JSONObject(obj.getJSONArray("items").get(0).toString());
		System.out.println(obj1.get("body"));
		 
	}
	
	
//	HashMap<String, Object> map = new HashMap<>();
//	map.put("left", 100);
//	map.put("top", 100);
//	map.put("width", 200);
//	map.put("height", 200);
//	map.put("direction", "down");
//	map.put("percent", "0.5");
//
//	driver.executeScript("mobile: swipeGesture", map);
//
//	driver.executeScript("mobile: swipeGesture", map);
//	
//	driver.executeScript("mobile: swipeGesture", map);
}
