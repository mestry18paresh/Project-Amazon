package com.Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AMAZON {
	WebDriver driver;

	@Test
	public void f() {

		driver.get("https://www.amazon.in/");
		String title = driver.getTitle();
		System.out.println("The page title is: " + title);
		// Add assertions to verify the title or other page elements
	}
	
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();

		if (browser.equalsIgnoreCase("chrome")) {
			cap.setBrowserName("chrome");
		} else if (browser.equalsIgnoreCase("edge")) {
			cap.setBrowserName("MicrosoftEdge");
		}
		
		

		// URL of the Selenium Grid Hub
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

	}



	@AfterTest
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}

	}

}
