package com.automation.framework.screens;

import java.beans.ExceptionListener;
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
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseTopicsScreen extends ScreenBase {

	public ChooseTopicsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_topic_row_topic_tag")
	public List<AndroidElement> topic;
	
	
	@AndroidFindBy(id="flipboard.app:id/icon_button_text")
	public WebElement ContinueButton;

	
	public ChooseTopicsScreen chooseTopics(int topicCount)
	{
		for(int i=0;i<topicCount;i++)
		{
			ExtentListeners.testReport.get().log(Status.INFO, "Topics selected "+topic.get(i).getText());
			topic.get(i).click();
		}
		return this;
	}
	
	
	public SkipLoginScreen clickContinueButton()
	{
		ContinueButton.click();
		ExtentListeners.testReport.get().log(Status.INFO, "Clicked on skip button");
		return new SkipLoginScreen(driver);
	}

}
