package com.automation.framework.base;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.automation.framework.utilities.AppiumServer;
import com.automation.framework.utilities.CommonUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {

	public  AppiumDriver<MobileElement> driver;
	public static String loadProperties = "Android_Flipboard.properties";
	//public static String loadProperties = "IOS_Flipboard.properties";
	public static Logger log = Logger.getLogger(TestBase.class);
	
	
	public void setUp()
	{
		AppiumServer.start();
		if(driver == null)
		{
			PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/com/automation/framework/resources/log4j.properties");
			if(loadProperties.startsWith("Android_"))
			{
				CommonUtils.loadAndroidConfProp(loadProperties);
				log.info(loadProperties+" Propeties file loaded for android.....");
				CommonUtils.setAndroidCapabilites();
				try {
					driver = CommonUtils.getAndroidDriver();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (loadProperties.startsWith("IOS_")) {
				
				PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/com/automation/framework/resources/log4j.properties");
				if(loadProperties.startsWith("IOS_"))
				{
					CommonUtils.loadIOSConfProp(loadProperties);
					log.info(loadProperties+" Propeties file loaded for ios.....");
					CommonUtils.setIOSCapabilites();
					try {
						driver = CommonUtils.getIOSDriver();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public void tearDown()
	{
		
		
		log.info("Test case execution completed........");
		AppiumServer.stop();	
	}
	
	
	
	
	
}
