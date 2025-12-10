package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.core.BaseTest;
import com.page.LoginBBPage;
import com.page.RegisterBBPage;

public class RegisterBBTest extends BaseTest{
	
	private RegisterBBPage registerPage;
	private LoginBBPage loginPage;
	
	@BeforeEach
	public void setUp() {
		loginPage = new LoginBBPage();
		loginPage.open("https://bugbank.netlify.app/#");
	}
	
	@Test
	public void testRegisterAccount() throws InterruptedException {
		registerPage = loginPage.clickRegistrar();
		registerPage.inputEmail("target@target.com.br");
		registerPage.inputName("TargetTrust 01");
		registerPage.inputPassword("123");
		registerPage.inputConfirmationPassword("123");
		//TODO refazer espera explicita
		Thread.sleep(1000);
		registerPage.clickToggleSaldo();
		registerPage.clickCadastrar();
		
		assertTrue(registerPage.isPartialMessageExist("foi criada com sucesso"));	
	}

}
