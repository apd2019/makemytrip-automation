package com.automation.tests;

public class LoginTestDump_DoNotInclude {

//	System.out.println(attributeChecker1.getAttribute("class"));

	// find the list > iterate over each option in the list > select an option

//	List<WebElement> listOfCountry = driver
//			.findElements(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));

//	List<WebElement> listOfCountry = driver.findElements(By.cssSelector("div.cntrycode__list div.li"));
//	
//	boolean found = false;

	// for each country in the listOfCountry

	/** using enhanced for() loop */
//	for (WebElement country : listOfCountry) {
//		country.getText();
//		// get each country everytime
	//// String countryName = country.getText();
//		if (country.getText().contains("AlandIslands")) {
//			WebElement selectCountryFromList = driver
//					.findElement(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span"));
//			selectCountryFromList.click();
//			return;
//		}
//
//	}

	// using normal for() loop index based

//	for (int i = 0; i < listOfCountry.size(); i++) {
//		WebElement eachCountryInTheList = listOfCountry.get(i);
	//// System.out.println(eachCountryInTheList.getText());
//
//		if (eachCountryInTheList.getText().contains("AlandIslands")) {
//			System.out.println("==================== The filtered country name is => "
//					+ eachCountryInTheList.getText() + " ============================");
//			WebElement selectCountryFromList = driver
//					.findElement(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span"));
//			selectCountryFromList.click();
//		}
//	}

	// using iterator
//	int i = 0;
//	Iterator<WebElement> it = listOfCountry.iterator();
//	while (it.hasNext()) 
//	{
//		WebElement e = it.next();
//		System.out.println(e.getText());
//		if (e.getText().contains("India (+91)")) {
//			System.out.println("==================== The filtered country name is => " + e.getText()
//					+ " ============================");
//			WebElement selectCountryFromList = driver
//					.findElement(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));
//			selectCountryFromList.click();
//		}
//	}

	// scroll to the country and select

	// find the list > iterate over each option in the list > select an option

//	List<WebElement> listOfCountry = driver
//			.findElements(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));

//	List<WebElement> listOfCountry = driver.findElements(By.xpath("//div[@class='li makeFlex hrtlCenter font12']/span[2]"));

//	List<WebElement> listOfCountry = driver.findElements(By.cssSelector("div.cntrycode__list div.li"));
//
//	boolean found = false;
//	
//	String keyword = "India";
//	// for each country in the listOfCountry
//
//	/** using enhanced for() loop */
//	for (WebElement country : listOfCountry) 
//	{
////		country.getText();
////		 get each country everytime
//		String countryName = country.getText().trim();
//		
//		if (countryName.toLowerCase().contains(keyword.toLowerCase())) {
//			country.click();
//			found = true;
//			
//		}
//
//	} 

//	use this positional selector for retrieving the country name only
	// to target the middle span that contains the country name
//	WebElement nameSpan = country.findElements(By.tagName("span")).get(1); // second span = name+code

	/**
	 * Advanced => use Java Streams to express this same "did we find one" logic
	 * more concisely, without a manual boolean flag:
	 */
	
	/**using enhanced for loop*/
	

//	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cntrycode__list div.li")));
//	List<WebElement> countryList = driver.findElements(By.cssSelector("div.cntrycode__list div.li"));
//
//	boolean found = false;
//
//	for (WebElement country : countryList) 
//	{
//		// the name+code both live in the first <span> e.g. "India (+91)"
//		WebElement nameSpan = country.findElement(By.cssSelector("span:not(.flagContainer):not(.phoneCode)"));
//
//		String fullText = nameSpan.getText().trim();
//
////		Strip off the trailing "(+xx)" phone coe to isolate just the name
//		String countryNameOnly = fullText.replaceAll("\\s*?\\(\\+\\d+\\)\\s*$", "").trim();
//
//		if (countryNameOnly.equalsIgnoreCase("india")) {
//			country.click();
//			found = true;
//			break;
//		}
//	}
//
//	if (!found) {
//		throw new NoSuchElementException("no exact country match found for: " + "India");
//	}
//	
//	WebElement personalAcTab= driver.findElement(By.xpath("//li[@data-cy='personalLogin']"));
//	new Actions(driver).moveToElement(personalAcTab).click().perform();
//	
//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.cntrycode__list div.li")));
//	
//	WebElement clickMobField = driver.findElement(By.xpath("//input[@data-cy='userName']"));
//	clickMobField.click();
	
	
	
	
	
	/**------------------------------------------------------------------------------------------------------*/
	
	
	
	
	/** use country code to select */
	
//	By indiaOption = By.xpath("//div[contains(@class,'cntrycode__list')]" 
//						+"//div[contains(@class,'li')]"
//						+".//span[normalize-space()='IN']");
//						
//	
//	wait.until(ExpectedConditions.elementToBeClickable(indiaOption)).click();
}
