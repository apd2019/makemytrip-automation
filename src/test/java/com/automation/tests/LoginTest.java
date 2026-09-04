package com.automation.tests;

import java.time.Duration;

//implement logic: if the site can not be loaded or shows error, implement a logic that could handle the error and re-run the script from scratch

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * shadow DOM presence validation code
 * document.querySelector('#shadow-host').shadowRoot
 */

public class LoginTest {

	WebDriver driver;
	int i = 0;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().fullscreen();
//		driver.get("https://www.makemytrip.com/");
//	}

	@BeforeTest
	void setUp() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);

		WebDriverManager.chromedriver().setup();

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	void openPage() {
		driver.get("https://www.makemytrip.com/");
	}

	/** Login Test */

	@Test(priority = 2)
	void closeAIPopup() throws InterruptedException {

		try {
			Thread.sleep(6000);
			WebElement popUpCloseBtn = driver.findElement(By.cssSelector("img[alt='minimize']"));
			popUpCloseBtn.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
/** ----------------------------------------------------------------------------------- */
	
	
	
	
	
	
	@Test(priority = 3)
	void clickLoginButton() {

		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//li[@class='makeFlex hrtlCenter font12 makeRelative lhUser userLoggedOut']")));
		loginBtn.click();
	}

	@Test(priority = 4)
	void selectCountryDrpdwn() throws InterruptedException {

		WebElement selectCountryDrpdwn = driver.findElement(By.cssSelector("p[data-cy='MobileCodeDropDown_59']"));
		selectCountryDrpdwn.click();

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

	@Test(priority = 5)
	void selectExactCountry() throws InterruptedException {
		//it will select the exact country from the list of countries in the phone country dropdown list, if the country is not found, it will throw an exception

		Thread.sleep(5000);
		System.out.println("==============running the selectcountry method====================");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cntrycode__list div.li")));

//		System.out.println(attributeChecker1.getAttribute("class"));

		// find the list > iterate over each option in the list > select an option

//		List<WebElement> listOfCountry = driver
//				.findElements(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));

//		List<WebElement> listOfCountry = driver.findElements(By.cssSelector("div.cntrycode__list div.li"));
//		
//		boolean found = false;

		// for each country in the listOfCountry

		/** using enhanced for() loop */
//		for (WebElement country : listOfCountry) {
//			country.getText();
//			// get each country everytime
		//// String countryName = country.getText();
//			if (country.getText().contains("AlandIslands")) {
//				WebElement selectCountryFromList = driver
//						.findElement(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span"));
//				selectCountryFromList.click();
//				return;
//			}
//
//		}

		// using normal for() loop index based

//		for (int i = 0; i < listOfCountry.size(); i++) {
//			WebElement eachCountryInTheList = listOfCountry.get(i);
		//// System.out.println(eachCountryInTheList.getText());
//
//			if (eachCountryInTheList.getText().contains("AlandIslands")) {
//				System.out.println("==================== The filtered country name is => "
//						+ eachCountryInTheList.getText() + " ============================");
//				WebElement selectCountryFromList = driver
//						.findElement(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span"));
//				selectCountryFromList.click();
//			}
//		}

		// using iterator
//		int i = 0;
//		Iterator<WebElement> it = listOfCountry.iterator();
//		while (it.hasNext()) {
//			WebElement e = it.next();
//			System.out.println(e.getText());
//			if (e.getText().contains("India (+91)")) {
//				System.out.println("==================== The filtered country name is => " + e.getText()
//						+ " ============================");
//				WebElement selectCountryFromList = driver
//						.findElement(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));
//				selectCountryFromList.click();
//			}
//		}

		// scroll to the country and select

		// find the list > iterate over each option in the list > select an option

//		List<WebElement> listOfCountry = driver
//				.findElements(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));

//		List<WebElement> listOfCountry = driver.findElements(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));

//		List<WebElement> listOfCountry = driver.findElements(By.cssSelector("div.cntrycode__list div.li"));
//
//		boolean found = false;
//		
//		String keyword = "India";
//		// for each country in the listOfCountry
//
//		/** using enhanced for() loop */
//		for (WebElement country : listOfCountry) {
////			country.getText();
////			 get each country everytime
//			String countryName = country.getText().trim();
//			
//			if (countryName.toLowerCase().contains(keyword.toLowerCase())) {
//				country.click();
//				found = true;
//				
//			}
//
//		} 

//		use this positional selector for retrieving the country name only
		// to target the middle span that contains the country name
//		WebElement nameSpan = country.findElements(By.tagName("span")).get(1); // second span = name+code

		/**
		 * Advanced => use Java Streams to express this same "did we find one" logic
		 * more concisely, without a manual boolean flag:
		 */

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cntrycode__list div.li")));
		List<WebElement> countryList = driver.findElements(By.cssSelector("div.cntrycode__list div.li"));

		boolean found = false;

		for (WebElement country : countryList) {
			// the name+code both live in the first <span> e.g. "India (+91)"
			WebElement nameSpan = country.findElement(By.cssSelector("span:not(.flagContainer):not(.phoneCode)"));

			String fullText = nameSpan.getText().trim();

//			Strip off the trailing "(+xx)" phone coe to isolate just the name
			String countryNameOnly = fullText.replaceAll("\\s*?\\(\\+\\d+\\)\\s*$", "").trim();

			if (countryNameOnly.equalsIgnoreCase("india")) {
				country.click();
				found = true;
				break;
			}
		}

		if (!found) {
			throw new NoSuchElementException("no exact country match found for: " + "India");
		}
	}

//	-----------------------------------------------------------------------------------------------------------

	@Test(priority = 6)
	void fillUserName() throws InterruptedException {
		WebElement clickMobField = driver.findElement(By.xpath("//input[@data-cy='userName']"));
		clickMobField.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='cntrycode__overlay']")));
		// use shadowroot method to get the mobnumber field
		WebElement userName = driver.findElement(By.cssSelector("input[data-cy='userName']"));
		userName.sendKeys("8250531445");
	}

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
//	
//	@Test(priority = 7)
//	void clickContinue() throws InterruptedException {
//		Thread.sleep(4000);
//		WebElement continueBtn = driver.findElement(By.cssSelector("button[data-cy='continueBtn']"));
//		continueBtn.click();
//	}

//	@AfterTest
	void tearDown() {
		WebDriverManager.chromedriver().reset();
		driver.quit();
	}

}
