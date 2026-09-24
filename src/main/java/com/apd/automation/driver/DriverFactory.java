package com.apd.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private WebDriver driver;
	
	public WebDriver getDriver()
	{
		if(driver == null)
		{
			driver = new ChromeDriver();
		}
		return driver;
	}
}
