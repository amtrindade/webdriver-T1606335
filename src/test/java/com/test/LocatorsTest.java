package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class LocatorsTest extends BaseTest{
		

	@BeforeEach
	public void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");		
	}
	
	@Test
	public void testRealizaCheckBox() {
		String nome = "Ana Paula da Silva";
		
		WebElement chk = getDriver().findElement(By.xpath("//*[.='"+ nome +"']/../td/input"));
		chk.click();
		assertTrue(chk.isSelected());
		
	}
	
	@Test
	public void testEmailParaReserva() {
		WebElement tdEmail = getDriver().findElement(By.xpath("//td[.='Milene Mendes Beck']/../td[2]"));
		String email = tdEmail.getText();
		
		WebElement tfEmailParaReserva = getDriver().findElement(By.id("txt01"));
		tfEmailParaReserva.sendKeys(email);
		assertEquals("milene@gmail.com", tfEmailParaReserva.getAttribute("value"));
	}

}
