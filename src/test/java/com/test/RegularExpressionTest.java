package com.test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegularExpressionTest {
	
	public WebDriver driver;	

	@BeforeEach
	public void setUp() throws Exception {		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		
		driver = new FirefoxDriver();
		driver.get("https://www.geradordecpf.org/");
		//espera implicita
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testValidaCPFComMascara() {
		
		WebElement cbPonto = driver.findElement(By.id("cbPontos"));
		cbPonto.click();
		
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCpf = driver.findElement(By.id("numero"));
		String cpfGerado = tfCpf.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));	
	}
	
	@Test
	public void testValidaCPFSemMascara() {
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCpf = driver.findElement(By.id("numero"));
		String cpfGerado = tfCpf.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{11}$"));
	}

}
