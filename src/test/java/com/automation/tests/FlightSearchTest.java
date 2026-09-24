package com.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apd.automation.pages.FlightSearchPage;

@Test
public class FlightSearchTest 

{
	WebDriver driver;
	WebDriverWait wait;
	FlightSearchPage fsp;
	
	
	@BeforeTest
	void setUp() {

//		ChromeOptions options = new ChromeOptions();
////		options.addArguments("--headless=new");
////		options.addArguments("--no-sandbox");
////		options.addArguments("--disable-dev-shm-usage");
//			options.addArguments("--disable-gpu");
//			options.addArguments("--user-data-dir=C:\\selenium-clean-profile");
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver(); //should be initiated before the page objects are created
//		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com");

	}
	
	@Test(priority=1, groups = {"smoke"})
	void closeLoginPopup()
	{
		By closeButton = By.xpath("//span[@data-cy='closeModal']");
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		driver.findElement(closeButton).click();
	}
	
//	@Test(priority=2)
//	void OpenMMTFlightSearch()
//	{		
//		By flightSearchTab = By.xpath("(//a[contains(@class,'headerIcons')])[1]");
//		wait.until(ExpectedConditions.elementToBeClickable(flightSearchTab)).click();	
//		System.out.println(driver.findElement(flightSearchTab).getText());
//	}
//	
//	@Test(priority=3)
//	void verifyOneWayIsSelected() 
//	{
//		By radioButton = By.xpath("//li[@data-cy='oneWayTrip']");
//		wait.until(ExpectedConditions.elementToBeClickable(radioButton));
//		System.out.println(driver.findElement(radioButton).getText());
//	}
	
	
	@Test(priority = 2)
	void testFlow()
	{
		fsp = new FlightSearchPage(driver);
		fsp.clickOneWay();
		WebElement oneWayRadioButton = driver.findElement(By.cssSelector("//li[@data-cy='oneWayTrip']"));
		
		System.out.println(oneWayRadioButton.isSelected());
	}
	
	
	
	
	
	
}
