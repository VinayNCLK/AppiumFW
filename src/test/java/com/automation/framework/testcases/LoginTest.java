package com.automation.framework.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.framework.base.TestBase;
import com.automation.framework.screens.ChooseTopicsScreen;
import com.automation.framework.screens.LoginScreen;
import com.automation.framework.screens.SkipLoginScreen;

public class LoginTest extends TestBase {

	LoginScreen login;
	ChooseTopicsScreen chooseTopics;
	SkipLoginScreen skipLoginScreen;
	
	@BeforeTest
	public void init()
	{
		setUp();
		login = new LoginScreen(driver);
		chooseTopics = new ChooseTopicsScreen(driver);
		skipLoginScreen = new SkipLoginScreen(driver);
	}
	
	@AfterTest
	public void close()
	{
		tearDown();
	}
	

	
	@Test(priority=1)
	public void validateGetStartedButton()
	{
		login.clickGetStarted();
	}
	

	@Test(priority=2)
	public void chooseTopicsTest() throws InterruptedException
	{
		Thread.sleep(5000);
		chooseTopics.chooseTopics(4).clickContinueButton();
	}
	
	@Test(priority=3)
	public void skipLoginTest() throws InterruptedException
	{
		Thread.sleep(5000);
		skipLoginScreen.clickSkipButton();
	}
	
}
