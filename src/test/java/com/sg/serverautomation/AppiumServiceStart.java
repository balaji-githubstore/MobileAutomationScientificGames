package com.sg.serverautomation;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServiceStart {

	public static void main(String[] args) {
		
		//port -5300 
		//enable relaxed security 
		
		AppiumServiceBuilder builder=new AppiumServiceBuilder()
				.usingAnyFreePort()
				.withLogFile(new File("appiumlog.log"))
				.withArgument(GeneralServerFlag.RELAXED_SECURITY)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				//below for mac machine
//				.withAppiumJS("/usr/local/bin/appium")
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		
		service.start();
		
		System.out.println(service.isRunning());
		System.out.println(service.getUrl());
		
		service.stop();

	}

}
