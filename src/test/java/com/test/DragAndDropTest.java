package com.test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropTest {
	
	public WebDriver driver;	

	@BeforeEach
	public void setUp() throws Exception {		
		//System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		
		WebDriverManager.firefoxdriver().setup();		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Abrir o browser no monitor auxiliar
		Point point = new Point(-1500, 0); 
		driver.manage().window().setPosition(point);
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");		
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testDragAndDrop() throws InterruptedException {
		WebElement divOrigin = driver.findElement(By.id("draggable"));
		WebElement divTarget = driver.findElement(By.id("droppable"));
		
		assertEquals("Drop here", divTarget.getText());
		
		new Actions(driver).dragAndDrop(divOrigin, divTarget).perform();
		
		assertEquals("Dropped!", divTarget.getText());
		
		Thread.sleep(2000);
		
		new Actions(driver).dragAndDropBy(divOrigin, 200, 200).perform();
	}
	
	

}
