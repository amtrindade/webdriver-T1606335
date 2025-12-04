package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.core.BaseTest;

public class WebElementsTest extends BaseTest{
		

	@BeforeEach
	public void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}

	@Test
	public void testValidateTextField() {
		//1. Identificar um elemento
		WebElement tfName = getDriver().findElement(By.name("txtbox1"));
		
		//2. Fazer uma ação no elemento		
		tfName.sendKeys("Hello world test automation");	
		
		//3. Validar que o texto está escrito corretamente
		assertEquals("Hello world test automation", tfName.getAttribute("value"));		
	}
	
	@Test
	public void testValidateEnableDisableTextField() {
		//1. Identificar um elemento na tela
		WebElement tfEnable = getDriver().findElement(By.name("txtbox1"));
		WebElement tfDisable = getDriver().findElement(By.name("txtbox2"));
		
		//2. Validar que os elementos estão habilitado e desabilitado
		assertTrue(tfEnable.isEnabled());
		assertFalse(tfDisable.isEnabled());			
	}
	
	@Test
	public void testValidaRadioButton() {
		List<WebElement> listRadios = getDriver().findElements(By.name("radioGroup1"));
		
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
		List<WebElement> listCheckBoxes = getDriver().findElements(By.name("chkbox"));
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
	
	@Test
	public void testValidateDropDownSingle() throws InterruptedException {
		WebElement dropDownSingle = getDriver().findElement(By.name("dropdownlist"));		
		Select selectSingle = new Select(dropDownSingle);
		
		selectSingle.selectByIndex(1);
		Thread.sleep(1000);
		selectSingle.selectByValue("item4");
		Thread.sleep(1000);
		selectSingle.selectByVisibleText("Item 7");
		
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());
	}
	
	@Test
	public void testValidateDropDownMultiSelect() throws InterruptedException {
		WebElement dropDownMultiSelect = getDriver().findElement(By.name("multiselectdropdown"));
		Select selectMulti = new Select(dropDownMultiSelect);
		
		selectMulti.selectByVisibleText("Item 5");
		Thread.sleep(1000);
		selectMulti.selectByVisibleText("Item 8");
		Thread.sleep(1000);
		selectMulti.selectByVisibleText("Item 9");
		
		List<WebElement> valuesSelect = selectMulti.getAllSelectedOptions();
		
		assertEquals(3, valuesSelect.size());
		
		assertEquals("Item 5", valuesSelect.get(0).getText());
		assertEquals("Item 8", valuesSelect.get(1).getText());
		assertEquals("Item 9", valuesSelect.get(2).getText());
		
		Thread.sleep(2000);
		selectMulti.deselectByVisibleText("Item 8");
		
		valuesSelect = selectMulti.getAllSelectedOptions();
		
		assertEquals(2, valuesSelect.size());
		assertEquals("Item 5", valuesSelect.get(0).getText());
		assertEquals("Item 9", valuesSelect.get(1).getText());
	}
	
	@Test
	public void testIFrame() {
		//Entra no iframe
		getDriver().switchTo().frame("frame1");
		
		WebElement tfIframe = getDriver().findElement(By.id("tfiframe"));
		tfIframe.sendKeys("Antonio Trindade");
		assertEquals("Antonio Trindade", tfIframe.getAttribute("value"));
		
		//Volta para o contexto original
		getDriver().switchTo().defaultContent();
	}
	
	@Test
	public void testAlertTypes() throws InterruptedException {
		WebElement btnAlert = getDriver().findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Thread.sleep(2000);
		
		Alert alert = getDriver().switchTo().alert();
		assertEquals("Eu sou um alerta!", alert.getText());
		alert.accept();		
		
		WebElement btnConfirm = getDriver().findElement(By.name("confirmbtn"));
		btnConfirm.click();
		
		Thread.sleep(2000);
		Alert confirm = getDriver().switchTo().alert();
		assertEquals("Pressione um botão!", confirm.getText());
		confirm.dismiss();
	}
	
	@Test
	public void testPromptAlerts() throws InterruptedException {
		WebElement btnPrompt = getDriver().findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Thread.sleep(2000);
		Alert prompt = getDriver().switchTo().alert();
		assertEquals("Digite o ano:", prompt.getText());
		prompt.sendKeys("2025");
		prompt.accept();
		
		Thread.sleep(2000);
		Alert confirm = getDriver().switchTo().alert();
		assertEquals("O ano é 2025?", confirm.getText());
		confirm.accept();
		
		Thread.sleep(2000);
		Alert alert = getDriver().switchTo().alert();
		assertEquals("Feito!", alert.getText());
		alert.accept();
	}	
}
