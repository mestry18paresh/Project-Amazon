package com.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserTest {

    private WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
    }

    @Test
    public void testExample() {
        driver.get("https://www.amazon.in/");
        // Add your test logic here
        System.out.println("Page title is: " + driver.getTitle());
    }
    
    @AfterTest
    public void afterTest() {
    	
    	
    	
    }
    
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}