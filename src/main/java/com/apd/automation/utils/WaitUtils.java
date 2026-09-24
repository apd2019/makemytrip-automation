package com.apd.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private WebDriverWait wait;
	
	public WaitUtils(WebDriver driver)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void waitForVisibility(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForClickability(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
}
