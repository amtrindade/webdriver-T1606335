package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class NavigationCacheTest extends BaseTest{
	
	@BeforeEach
	public void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/index.html");
	}

	
	@Test
	public void testNavigationCache() throws InterruptedException {
		WebElement menuCalculadora = getDriver().findElement(By.linkText("Calculadora"));
		menuCalculadora.click();
		
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		WebElement menuLocalizarTable = getDriver().findElement(By.linkText("Localizar Table"));
		menuLocalizarTable.click();
		
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
		getDriver().navigate().back();
		Thread.sleep(1000);
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().back();
		Thread.sleep(1000);
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		getDriver().navigate().forward();
		Thread.sleep(1000);
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().forward();
		Thread.sleep(1000);
		assertEquals("Trabalhando com tables", getDriver().getTitle());		
	}

}
