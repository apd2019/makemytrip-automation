package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThreadLocalTest {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void setDriver(WebDriver driverInstance	) {
		driver.set(driverInstance);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@Test
	void openPage() {
		WebDriverManager.chromedriver().reset();
		
	}

}
