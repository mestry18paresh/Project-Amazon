package com.project;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Shopping_sites {
	WebDriver driver;

	@Test(priority = 1)
	public void Amazon() {

		driver.get("https://www.amazon.in/");

	}

	@Test(priority = 2)
	public void Filpkart() {

		driver.get("https://www.flipkart.com/");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println(driver.getTitle());
	}
	
	

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
