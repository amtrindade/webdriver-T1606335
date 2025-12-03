package com.test;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculadoraTest {
	
	public WebDriver driver;	
	public WebDriverWait wait;

	@BeforeEach
	public void setUp() throws Exception {		
		//System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		
		WebDriverManager.firefoxdriver().setup();		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Abrir o browser no monitor auxiliar
		Point point = new Point(-1500, 0); 
		driver.manage().window().setPosition(point);
		
		//Inicializa o wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");	
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testSoma() throws InterruptedException {
		Random aleatorio = new Random();
		
		Integer valor1 = aleatorio.nextInt(100) + 1;
		Integer valor2 = aleatorio.nextInt(100) + 1;
		
		Integer totalSoma = valor1 + valor2;
		
		WebElement tfValor1 = driver.findElement(By.id("number1"));
		WebElement tfValor2 = driver.findElement(By.id("number2"));
		WebElement btnSomar = driver.findElement(By.id("somar"));
		WebElement tfTotal = driver.findElement(By.id("total"));
		
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
		
		WebElement tfValor1 = driver.findElement(By.id("number1"));
		WebElement tfValor2 = driver.findElement(By.id("number2"));
		WebElement btnSubtracao = driver.findElement(By.id("subtrair"));
		WebElement tfTotal = driver.findElement(By.id("total"));
		
		
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
