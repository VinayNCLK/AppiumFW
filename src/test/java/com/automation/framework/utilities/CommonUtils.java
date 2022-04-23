package com.automation.framework.utilities;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	
	private static AppiumDriver<MobileElement> driver;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String DEVICE_NAME;
	private static String AUTOMATION_NAME;
	private static String APPLICATION_PACKAGE;
	private static String APPLICATION_ACTIVITY;
	private static String APP_PATH;
	private static String APPIUM_SERVER_PORT;
	private static int IMPLICIT_WAIT;
	private static Properties prop = new Properties();
	private static FileInputStream fis;
	
	
	public static void loadAndroidConfProp(String loadPropertiesFile)
	{
		try
		{
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/automation/framework/resources/"+loadPropertiesFile);
		prop.load(fis);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		AUTOMATION_NAME = prop.getProperty("automation.name");
		APPLICATION_PACKAGE = prop.getProperty("application.Package");
		APPLICATION_ACTIVITY = prop.getProperty("application.Activity");
		APP_PATH = prop.getProperty("app.path");
		APPIUM_SERVER_PORT = prop.getProperty("appium.server.port");
		IMPLICIT_WAIT = Integer.parseInt(prop.getProperty("implicit.wait"));
		
	}
	
	
	public static void setAndroidCapabilites()
	{
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		capabilities.setCapability("appPackage", APPLICATION_PACKAGE);
		capabilities.setCapability("appActivity", APPLICATION_ACTIVITY);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		//capabilities.setCapability("app",System.getProperty("user.dir")+"/src/test/resources/applicationfiles/"+APP_PATH);
	}
	
	public static void loadIOSConfProp(String loadPropertiesFile)
	{
		try
		{
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/automation/framework/resources/"+loadPropertiesFile);
		prop.load(fis);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		AUTOMATION_NAME = prop.getProperty("automation.name");
		APP_PATH = prop.getProperty("app.path");
		APPIUM_SERVER_PORT = prop.getProperty("appium.server.port");
		IMPLICIT_WAIT = Integer.parseInt(prop.getProperty("implicit.wait"));
		
	}
	
	
	public static void setIOSCapabilites()
	{
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		capabilities.setCapability("app",APP_PATH);
	}
	
	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException
	{
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:"+APPIUM_SERVER_PORT+"/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		return driver;
	}
	
	public static AppiumDriver<MobileElement> getIOSDriver() throws MalformedURLException
	{
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:"+APPIUM_SERVER_PORT+"/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
		return driver;
	}
	
}
