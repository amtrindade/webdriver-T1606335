package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementsTest {
	
	public WebDriver driver;	

	@BeforeEach
	public void setUp() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		
		// Para windows
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}

	@AfterEach
	public void tearDown() throws Exception {
		//Tempo para visualização
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void testValidateTextField() {
		//1. Identificar um elemento
		WebElement tfName = driver.findElement(By.name("txtbox1"));
		
		//2. Fazer uma ação no elemento		
		tfName.sendKeys("Hello world test automation");	
		
		//3. Validar que o texto está escrito corretamente
		assertEquals("Hello world test automation", tfName.getAttribute("value"));		
	}
	
	@Test
	public void testValidateEnableDisableTextField() {
		//1. Identificar um elemento na tela
		WebElement tfEnable = driver.findElement(By.name("txtbox1"));
		WebElement tfDisable = driver.findElement(By.name("txtbox2"));
		
		//2. Validar que os elementos estão habilitado e desabilitado
		assertTrue(tfEnable.isEnabled());
		assertFalse(tfDisable.isEnabled());			
	}
	
	@Test
	public void testValidaRadioButton() {
		List<WebElement> listRadios = driver.findElements(By.name("radioGroup1"));
		
		assertEquals(4, listRadios.size());
		
		for (WebElement element : listRadios) {
			//System.out.println(element.getAttribute("value"));
			
			if (element.getAttribute("value").equals("Radio 3")) {
				element.click();
			}
		}		
		assertTrue(listRadios.get(2).isSelected());
		
		assertFalse(listRadios.get(0).isSelected());
		assertFalse(listRadios.get(1).isSelected());
		assertFalse(listRadios.get(3).isSelected());		
	}	
	
	@Test
	public void testValidateCheckBox() {
		List<WebElement> listCheckBoxes = driver.findElements(By.name("chkbox"));
		assertEquals(4, listCheckBoxes.size());
		
		for (WebElement element : listCheckBoxes) {
			
			if ((element.getAttribute("value").equals("Check 3")) 
					|| (element.getAttribute("value").equals("Check 4"))) {
				element.click();
			}
					
		}
		
//		listCheckBoxes.get(2).click();
//		listCheckBoxes.get(3).click();
		
		assertTrue(listCheckBoxes.get(2).isSelected());
		assertTrue(listCheckBoxes.get(3).isSelected());
		
		assertFalse(listCheckBoxes.get(0).isSelected());
		assertFalse(listCheckBoxes.get(1).isSelected());
	}
}
