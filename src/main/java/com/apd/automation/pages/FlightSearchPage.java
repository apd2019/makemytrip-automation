package com.apd.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apd.automation.utils.WaitUtils;

/**
 * First test cases 
 1. Select One Way
2. Enter From
3. Select From suggestion
4. Enter To
5. Select To suggestion
6. Select departure date
7. Click Search
 */

public class FlightSearchPage {
	
	
	private WebDriver driver;
	private WaitUtils wu;
	
	//One Way element locator
	private By oneWayRadioButton = By.cssSelector("li[data-cy='oneWayTrip']");
	
	//Enter From locator > select from suggestion
	private By enterOrigin = By.cssSelector("input[data-cy='fromCity']");
	private By suggestionLocator = By.xpath("(//span[@class='revampedPillText'])[3]");
	
	public FlightSearchPage(WebDriver driver)
	{
		this.driver = driver;
		this.wu = new WaitUtils(driver);
	}
	
	
	//One way click
	public void clickOneWay()
	{
		wu.waitForClickability(oneWayRadioButton);
		driver.findElement(oneWayRadioButton).click();
	}
	
	
	
	
	

}
