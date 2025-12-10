package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.HomeBBPage;
import com.page.LoginBBPage;
import com.page.RegisterBBPage;

public class LoginBBTest extends BaseTest{
	
	private RegisterBBPage registerPage;
	private LoginBBPage loginPage;
	private HomeBBPage homePage;
	
	String email = "target@target.com.br";
	String pass = "123";
	
	@BeforeEach
	public void setUp() throws InterruptedException {
		loginPage = new LoginBBPage();
		loginPage.open("https://bugbank.netlify.app/#");
		registerPage = loginPage.clickRegistrar();
		registerPage.inputEmail(email);
		registerPage.inputName("TargetTrust 01");
		registerPage.inputPassword(pass);
		registerPage.inputConfirmationPassword(pass);
		Thread.sleep(1000);
		registerPage.clickToggleSaldo();
		registerPage.clickCadastrar();
		loginPage = registerPage.clickClose();
	}
	
	@Test
	public void testLoginValid() {
		loginPage.inputEmail(email);
		loginPage.inputPassword(pass);
		homePage = loginPage.clickAcessar();
		assertEquals("Olá TargetTrust 01,", homePage.getUserLogged());	
	}
}
