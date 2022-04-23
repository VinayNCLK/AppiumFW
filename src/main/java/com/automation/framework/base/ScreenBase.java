package com.automation.framework.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenBase {

	
	public static AppiumDriver<MobileElement> driver;
	
	public ScreenBase(AppiumDriver<MobileElement> driver)
	{
		this.driver = driver;
	}
	
	public void hideKeyword()
	{
		driver.hideKeyboard();
	}
}
