package com.automation.framework.screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase {

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
	@AndroidFindBy(id="flipboard.app:id/bottom_nav_view_icon")
	public List<AndroidElement> bottomNavigation;
	
	
	
	public void selectBottomPannel(int screenNumber)
	{
		bottomNavigation.get(screenNumber-1).click();
	}
	
	
	
}
