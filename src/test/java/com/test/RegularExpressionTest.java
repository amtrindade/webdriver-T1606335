package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class RegularExpressionTest extends BaseTest{
		
	@BeforeEach
	public void setUp() throws Exception {
		getDriver().get("https://www.geradordecpf.org/");		
	}

	@Test
	public void testValidaCPFComMascara() {
		
		WebElement cbPonto = getDriver().findElement(By.id("cbPontos"));
		cbPonto.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCpf = getDriver().findElement(By.id("numero"));
		String cpfGerado = tfCpf.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));	
	}
	
	@Test
	public void testValidaCPFSemMascara() {
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCpf = getDriver().findElement(By.id("numero"));
		String cpfGerado = tfCpf.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^\\d{11}$"));
	}

}
