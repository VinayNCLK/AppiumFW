package com.automation.framework.utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollUtils {

	
	
	public static void swipping_leftToRight(AndroidDriver driver, int startX,int endx)
	{
		Dimension dis = driver.manage().window().getSize();
		int yaxis = dis.height / 2;
		TouchAction act = new TouchAction(driver);
		act.longPress(ElementOption.point(startX, yaxis)).moveTo(ElementOption.point(endx, yaxis)).release().perform();
	}
	
	public static void swipping_RightToLeft(AndroidDriver driver, int startX,int endx)
	{
		Dimension dis = driver.manage().window().getSize();
		int yaxis = dis.height / 2;
		TouchAction act = new TouchAction(driver);
		act.longPress(ElementOption.point(endx, yaxis)).moveTo(ElementOption.point(startX, yaxis)).release().perform();
	}
	
	
	public static void scrolling_bottomToTop(AndroidDriver driver, int starty,int endy)
	{
		Dimension dis = driver.manage().window().getSize();
		int xaxis = dis.width / 2;
		TouchAction act = new TouchAction(driver);
		act.longPress(ElementOption.point(xaxis, starty)).moveTo(ElementOption.point(xaxis, endy)).release().perform();
	}
	
	public static void scrolling_topToBottom(AndroidDriver driver, int starty,int endy)
	{
		Dimension dis = driver.manage().window().getSize();
		int xaxis = dis.width / 2;
		TouchAction act = new TouchAction(driver);
		act.longPress(ElementOption.point(xaxis, endy)).moveTo(ElementOption.point(xaxis, starty)).release().perform();
	}
	
	public static WebElement scrollToText(AndroidDriver driver, String text)
	{
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))");
	}
	
	
	public static AndroidElement scrollToElement(By by, AndroidDriver driver)
	{
	
		AndroidElement element = null;
		int noOfTimes = 10;
		Dimension size = driver.manage().window().getSize();
		int startX = (int)(size.width/2);
		int startY = (int)(size.height-10);
		int endY = 10;
		
		for(int i=0;i<noOfTimes;i++)
		{
			try {
				new TouchAction(driver).longPress(ElementOption.point(startX, startY)).moveTo(ElementOption.point(startX, endY)).release().perform();
				System.out.println("Number of times scrolled "+i+1);
				element = (AndroidElement) driver.findElement(by);
				i = noOfTimes;
				//break;
			}
			catch (NoSuchElementException e) {
				// TODO: handle exception
				System.out.println("Element not found ");
			}
		}
		
		return element;
		
	}
	
	
}
