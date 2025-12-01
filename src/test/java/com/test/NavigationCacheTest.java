package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCacheTest {
	
	public WebDriver driver;	

	@BeforeEach
	public void setUp() throws Exception {		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		
		driver = new FirefoxDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/index.html");
		//espera implicita
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testNavigationCache() throws InterruptedException {
		WebElement menuCalculadora = driver.findElement(By.linkText("Calculadora"));
		menuCalculadora.click();
		
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		WebElement menuLocalizarTable = driver.findElement(By.linkText("Localizar Table"));
		menuLocalizarTable.click();
		
		assertEquals("Trabalhando com tables", driver.getTitle());
		
		driver.navigate().back();
		Thread.sleep(1000);
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().back();
		Thread.sleep(1000);
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		driver.navigate().forward();
		Thread.sleep(1000);
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().forward();
		Thread.sleep(1000);
		assertEquals("Trabalhando com tables", driver.getTitle());		
	}

}
