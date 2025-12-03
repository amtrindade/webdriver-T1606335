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

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsTest {
	
	public WebDriver driver;	

	@BeforeEach
	public void setUp() throws Exception {		
		//System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		
		WebDriverManager.firefoxdriver().setup();		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Abrir o browser no monitor auxiliar
		Point point = new Point(-1500, 0); 
		driver.manage().window().setPosition(point);
		
		driver.get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");		
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testRealizaCheckBox() {
		String nome = "Ana Paula da Silva";
		
		WebElement chk = driver.findElement(By.xpath("//*[.='"+ nome +"']/../td/input"));
		chk.click();
		assertTrue(chk.isSelected());
		
	}
	
	@Test
	public void testEmailParaReserva() {
		WebElement tdEmail = driver.findElement(By.xpath("//td[.='Milene Mendes Beck']/../td[2]"));
		String email = tdEmail.getText();
		
		WebElement tfEmailParaReserva = driver.findElement(By.id("txt01"));
		tfEmailParaReserva.sendKeys(email);
		assertEquals("milene@gmail.com", tfEmailParaReserva.getAttribute("value"));
	}

}
