package com.sg.serverautomation;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumDefaultServiceStart {

	public static void main(String[] args) {
		
		//always starts with default port 4723
		
		AppiumDriverLocalService service=AppiumDriverLocalService.buildDefaultService();  

		service.start();
		
		System.out.println(service.isRunning());
		System.out.println(service.getUrl());
	
		
		service.stop();
		
	}

}
