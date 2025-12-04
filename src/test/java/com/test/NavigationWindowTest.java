package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class NavigationWindowTest extends BaseTest{
	

	@BeforeEach
	public void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/index.html");
	}
	
	@Test
	public void testNavigationTabs() throws InterruptedException {
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement linkDragAndDrop = getDriver().findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		WebElement linkBookStore = getDriver().findElement(By.linkText("Book Store"));
		linkBookStore.click();
		
		Thread.sleep(5000);
		
		//Cria uma lista com as janelas abertas pelo teste
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		//navega entre as janelas abertas
		getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		assertEquals("Login", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(2));
		Thread.sleep(2000);
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());		
	}

}
