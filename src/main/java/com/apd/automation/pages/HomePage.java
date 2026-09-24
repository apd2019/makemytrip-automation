package com.apd.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apd.automation.utils.WaitUtils;

public class HomePage {

	//needs access to the browser
	private WebDriver driver; 
	private WaitUtils wu;
	
	
	/** all page objects here*/
	
	private By flightsTab = By.cssSelector("[data-cy='oneWayTrip']");

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		this.wu = new WaitUtils(driver);
	}
	
	
	/** all actions here*/
	
	public void clickFlights()
	{
		wu.waitForClickability(flightsTab);
		driver.findElement(flightsTab).click();
	}
	
	
	
}
