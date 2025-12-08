package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class CalculadoraTest extends BaseTest{
		
	public WebDriverWait wait;

	@BeforeEach
	public void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");	
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}

	@Test
	public void testSoma() throws InterruptedException {
		Random aleatorio = new Random();
		
		Integer valor1 = aleatorio.nextInt(100) + 1;
		Integer valor2 = aleatorio.nextInt(100) + 1;
		
		Integer totalSoma = valor1 + valor2;
		
		WebElement tfValor1 = getDriver().findElement(By.id("number1"));
		WebElement tfValor2 = getDriver().findElement(By.id("number2"));
		WebElement btnSomar = getDriver().findElement(By.id("somar"));
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		
		tfValor1.sendKeys(Integer.toString(valor1));
		tfValor2.sendKeys(Integer.toString(valor2));
		btnSomar.click();
		
		//espera pelo texto específico a ser disponibilizado no componente
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfTotal, Integer.toString(totalSoma)));
				
		assertEquals(Integer.toString(totalSoma), tfTotal.getAttribute("value"));
	}
	
	@Test
	public void testSubtracao() {
		Random aleatorio = new Random();
		
		Integer valor1 = aleatorio.nextInt(100) + 1;
		Integer valor2 = aleatorio.nextInt(100) + 1;
		Integer resultado = 0;
		
		WebElement tfValor1 = getDriver().findElement(By.id("number1"));
		WebElement tfValor2 = getDriver().findElement(By.id("number2"));
		WebElement btnSubtracao = getDriver().findElement(By.id("subtrair"));
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		
		
		if (valor1 > valor2) {
			resultado = valor1 - valor2;
			tfValor1.sendKeys(Integer.toString(valor1));
			tfValor2.sendKeys(Integer.toString(valor2));
		}
		else if(valor2 > valor1) {
			resultado = valor2 - valor1;
			tfValor1.sendKeys(Integer.toString(valor2));
			tfValor2.sendKeys(Integer.toString(valor1));
		}
		else {
			resultado = 0;
			tfValor1.sendKeys(Integer.toString(valor1));
			tfValor2.sendKeys(Integer.toString(valor2));
		}
		
		btnSubtracao.click();
				
		assertEquals(Integer.toString(resultado), tfTotal.getAttribute("value"));		
	}

}
