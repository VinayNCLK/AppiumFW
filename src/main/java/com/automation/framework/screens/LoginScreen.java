package com.automation.framework.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.base.ScreenBase;
import com.aventstack.extentreports.Status;

import extentListeners.ExtentListeners;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBase{

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="flipboard.app:id/icon_button_text")
	public WebElement GetStartedButton;
	
	
	public ChooseTopicsScreen clickGetStarted()
	{
		GetStartedButton.click();
		ExtentListeners.testReport.get().log(Status.INFO, "Clicked on get started button");
		return new ChooseTopicsScreen(driver);
	}
	
	
}
