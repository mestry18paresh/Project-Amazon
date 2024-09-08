package com.amazon;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserTest {

	private WebDriver driver;
	String bName;

	@BeforeClass
	@Parameters("browser")
	public void setUpBrowser(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			bName = "Chrome";
			break;
		case "edge":
			driver = new EdgeDriver();
			bName = "Edge";
			break;
		}
	}

	@Test
	public void testExample() {
		driver.get("https://www.amazon.in/");
		// Add your test logic here
		System.out.println("Page title is: " + driver.getTitle());
	}

	@AfterMethod
	public void AfterMethod() throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		org.openqa.selenium.io.FileHandler.copy(file, new File(bName + "_ScreenShot" + ".jpeg"));
		

	}

	@AfterClass
	public void Quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}