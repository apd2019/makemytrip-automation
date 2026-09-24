package com.automation.tests;

import java.time.Duration;

//implement logic: if the site can not be loaded or shows error, implement a logic that could handle the error and re-run the script from scratch

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apd.automation.pages.FlightSearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * shadow DOM presence validation code
 * document.querySelector('#shadow-host').shadowRoot
 */

public class LoginTest {

	WebDriver driver;
	int i = 0;
	WebDriverWait wait;
//	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().fullscreen();
//		driver.get("https://www.makemytrip.com/");
//	}

	@BeforeTest
	void setUp() {

		ChromeOptions options = new ChromeOptions();
////		options.addArguments("--headless=new");
////		options.addArguments("--no-sandbox");
////		options.addArguments("--disable-dev-shm-usage");
//			options.addArguments("--disable-gpu");
//			options.addArguments("--user-data-dir=C:\\selenium-clean-profile");
//		driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		WebDriverManager.chromedriver().setup();

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

	}
	
	//TC001
	@Test(priority = 1)
	void openPage() {
		driver.get("https://www.makemytrip.com/");
	}

	
	/** Login Test */
	//TC002
	@Test(priority = 2)
	void closeAIPopup() 
	{
		try {
			WebElement popUpCloseBtn = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("img[alt='minimize']"))));
			popUpCloseBtn.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
/** ----------------------------------------------------------------------------------- */
	
	
	
	
	
	//TC003
	@Test(priority = 3)
	void clickLoginButton() 
	{	
		/**checking whether the modal is actually visible and covering the Login button*/
		System.out.println("========checking whether the modal is actually visible and covering the Login button========");
		List<WebElement> modals = driver.findElements(By.cssSelector(".modal"));
		for(WebElement modal : modals)
		{
			System.out.println("Displayed: " + modal.isDisplayed());
			System.out.println(modal.getAttribute("class"));
		}
		
		/**checking if the modal is actually visible*/
		System.out.println("=====================checking if the modal is actually visible====================");
		
		By imageSlider = By.cssSelector(".imageSlideContainer");		
		List<WebElement> elements = driver.findElements(imageSlider);		
		for(WebElement element : elements) 
		{
			System.out.println("Displayed: "+ element.isDisplayed());
			System.out.println("class: "+ element.getAttribute("class"));
		}
		
		
		
		
		/**inspect the exact intercepting element by its location, size etc.*/
		
		System.out.println("============inspecting the intercepting element============");
		
		By container = By.cssSelector(".imageSlideContainer");
		WebElement element = driver.findElement(container);
		
		System.out.println("Displayed: " + element.isDisplayed());
		System.out.println("Enabled: " + element.isEnabled());
		System.out.println("class: " + element.getAttribute("class"));
		System.out.println("location: " + element.getLocation());
		System.out.println("size: " + element.getSize());
		
		
		/**checking if an image slider modal is currently open and blocking Login button*/
		
		System.out.println("==========checking if an image slider modal is currently open and blocking Login button=============");
		By imageSlider1 = By.cssSelector(".imageSliderModal");
		List<WebElement> sliders = driver.findElements(imageSlider1);
		
		System.out.println("ImageSliderCount: "+ sliders.size());
		
		for(WebElement slider : sliders)
		{
			System.out.println("Displayed: " + slider.isDisplayed());
			System.out.println("class: " + slider.getAttribute("class"));
		}
		
		
		/**print the elements inside the modal using outerHTML*/
		System.out.println("==================printing the outerHTML of the modal==================");
		WebElement modal = driver.findElement(By.cssSelector(".imageSliderModal.modalLogin"));
		System.out.println(modal.getAttribute("outerHTML"));
		
		/**actual code to close the modal and click the login button*/
		By closeModal = By.cssSelector("[data-cy='closeModal']");
		
		//close the modal
		wait.until(ExpectedConditions.elementToBeClickable(closeModal)).click();
		
		//make sure the modal is actually gone
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".imageSliderModal")));
		
		//now click login		
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector(".makeFlex.hrtlCenter.font12.makeRelative.lhUser.userLoggedOut")));
		loginBtn.click();
	}

//	TC004
	@Test(priority = 4)
	void clickCountryDrpdwn() 
	{
		WebElement clickCountryDropdwn = driver.findElement(By.cssSelector("p[data-cy='MobileCodeDropDown_59']"));
		clickCountryDropdwn.click();
	}

//	@Test(priority = 5)
//	void enterCountryName() {
//		
//		WebElement countryNamefield = driver.findElement(By.cssSelector("input#enterCountry"));
//		countryNamefield.sendKeys("");
//
////		//selenium 4+ native support
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter Mobile Number']")));
////		WebElement host = driver.findElement(By.cssSelector("input[placeholder='Enter Mobile Number']"));
////		
////		SearchContext ShadowRoot = host.getShadowRoot();
////		
////		WebElement shadowElement = ShadowRoot.findElement(By.cssSelector("div[id='placeholder']"));
////		
////			shadowElement.sendKeys("india");

//
//		// using javascript executor
////		JavascriptExecutor js = (JavascriptExecutor) driver;
////		WebElement host = driver.findElement(By.cssSelector("input[placeholder='Enter Mobile Number']"));
////		WebElement phoneNumField = (WebElement) js
////				.executeScript("return arguments[0].shadowroot.querySelector('div[id='placeholder']')", host);
////		phoneNumField.click();
//		
//
//	}

	//TC005 - country select
	@Test(priority = 5)
	void selectExactCountry()
	{
		//it will select the exact country from the list of countries in the phone country dropdown list, if the country is not found, it will throw an exception

	
		System.out.println("==============running the selectcountry method====================");
		
		/** use country input text box */
		
		By countryInputBox= By.id("enterCountry");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(countryInputBox)).sendKeys("india");
		
		driver.findElement(By.xpath("//div/span[text()='India']")).click();
		
		
		
	}

//	-----------------------------------------------------------------------------------------------------------

	//TC006
	@Test(priority = 6)
	void fillUserName() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='cntrycode__overlay']")));
		WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-cy='userName']")));
		userName.sendKeys("8250531445");
		
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cy='continueBtn']")));
		System.out.println("Enabled: " + continueBtn.isEnabled());
		System.out.println("Disabled attribute: " + continueBtn.getAttribute("disabled"));
		System.out.println("Displayed: " + continueBtn.isDisplayed());
		System.out.println("============printing the outerHTML of Continue Button============");
		System.out.println("Button HTML: " + continueBtn.getAttribute("outerHTML"));
//		continueBtn.click();
		System.out.println("CLICK EXECUTED");
//		Thread.sleep(5000);
//		System.out.println(driver.findElement(By.tagName("body")).getText());
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		js.executeScript("arguments[0].addEventListener('click',function(){ console.log('Continue Click event fired');});", continueBtn);
		
//		js.executeScript("arguments[0].click();", continueBtn);
		continueBtn.click();
		Thread.sleep(2000);
		

	}
	
	//TC007
//	@Test(priority = 7)
	void clickCheckBox() throws InterruptedException {
		try {
			Thread.sleep(1000);
			// use shadowroot method to get the mobnumber field
			WebElement checkBox = driver.findElement(By.cssSelector(""));
			checkBox.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
	//TC008
//	@Test(priority = 7)
	void clickContinue()
	{
		
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-cy='continueBtn']")));	
		
		System.out.println("=========clicking continue button===============");
//		continueBtn.click();
		
		System.out.println("Enabled: " + continueBtn.isEnabled());
		System.out.println("Disabled attribute: " + continueBtn.getAttribute("disabled"));
		System.out.println("============printing the outerHTML of Continue Button============");
		System.out.println("Button HTML: " + continueBtn.getAttribute("outerHTML"));
//		System.out.println("Selected: " + continueBtn.isSelected());
//		System.out.println("Class: " + continueBtn.getAttribute("class"));
//		System.out.println("Parent Class: " + continueBtn.findElement(By.xpath(")));
	
		
		
		
			
		
		System.out.println("Enabled: " + continueBtn.isEnabled());
		System.out.println("Displayed: " + continueBtn.isDisplayed());
		
		By continueText = By.cssSelector("[data-cy='continueBtn'] span");
		
		wait.until(ExpectedConditions.elementToBeClickable(continueText)).click();
		
//		continueBtn.click();
		System.out.println("CLICK EXECUTED");
		System.out.println("CLICK COMPLETED");
		System.out.println(driver.findElements(By.cssSelector("[data-cy='continueBtn']")).size());
	}
	
	
//	@Test(priority= 8)
//	void verifyFlightPage()
//	{
//		FlightSearchPage fsp = new FlightSearchPage();
//	}
	
	
	
	

//	@AfterTest
	void tearDown() {
		WebDriverManager.chromedriver().reset();
		driver.quit();
	}

}
