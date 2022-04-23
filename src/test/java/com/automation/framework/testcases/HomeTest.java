package com.automation.framework.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.framework.base.TestBase;
import com.automation.framework.screens.ChooseTopicsScreen;
import com.automation.framework.screens.HomeScreen;
import com.automation.framework.screens.LoginScreen;
import com.automation.framework.screens.SkipLoginScreen;

public class HomeTest extends TestBase {

	LoginScreen login;
	ChooseTopicsScreen chooseTopics;
	SkipLoginScreen skipLoginScreen;
	HomeScreen homeScreen;
	
	@BeforeTest
	public void init()
	{
		setUp();
		login = new LoginScreen(driver);
		chooseTopics = new ChooseTopicsScreen(driver);
		skipLoginScreen = new SkipLoginScreen(driver);
		homeScreen = new HomeScreen(driver);
	}
	
	@AfterTest
	public void close()
	{
		tearDown();
	}
	

	
	@Test(priority=1)
	public void selectBottomNav() throws InterruptedException
	{
		login.clickGetStarted().chooseTopics(4).clickContinueButton();
		Thread.sleep(5000);
		skipLoginScreen.clickSkipButton();
		homeScreen.selectBottomPannel(3);
	}
	
}
