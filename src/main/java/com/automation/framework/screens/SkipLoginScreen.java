package com.automation.framework.screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.base.ScreenBase;
import com.aventstack.extentreports.Status;

import extentListeners.ExtentListeners;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SkipLoginScreen extends ScreenBase {

	public SkipLoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
	
	@AndroidFindBy(id="flipboard.app:id/icon_button_text")
	public WebElement SkipLoginButton;
	
	
	
	public HomeScreen clickSkipButton()
	{
		SkipLoginButton.click();
		ExtentListeners.testReport.get().log(Status.INFO, "Clicked on skipped button");
		return new HomeScreen(driver);
	}
		
}
