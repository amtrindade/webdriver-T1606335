package com.test;

import com.core.BaseTest;
import com.page.LoginBSPage;
import com.page.MainBSPage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class LoginBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private MainBSPage mainPage;
	
	@Test
	public void testLoginValid() {
		loginPage = new LoginBSPage();
		loginPage.open("http://sahitest.com/demo/training/login.htm");
		
		loginPage.inputUserName("test");
		loginPage.inputPass("secret");		
		mainPage = loginPage.clickBtnLogin();
		
		assertTrue(mainPage.isUserLogged());
	}

}
