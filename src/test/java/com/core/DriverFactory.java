package com.core;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		String browser = GlobalProperty.getProperty("webdriver.browser");
		
		if (driver == null) {
			
			if (browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();		
				driver = new FirefoxDriver();
			}
			else if(browser.equals("firefox-headless")) {
				WebDriverManager.firefoxdriver().setup();	
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1200x860");				
				driver = new FirefoxDriver(options);
			}
			else if (browser.equals("chrome")) {
				WebDriverManager.chromiumdriver().setup();
				driver = new ChromeDriver();				
			}
			else if (browser.equals("chrome-headless")) {
				WebDriverManager.chromedriver().setup();	
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1200x860");				
				driver = new ChromeDriver(options);
			}
			else {
				System.out.println("Browser inválido");
			}
								
			//Abrir o browser no monitor auxiliar
			Point point = new Point(-1500, 0); 
			driver.manage().window().setPosition(point);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
			
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
