package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.LoginBSPage;
import com.page.MainBSPage;

public class AddCartBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private MainBSPage mainPage;

	@BeforeEach
	public void setUp() {
		loginPage = new LoginBSPage();
		loginPage.open("http://sahitest.com/demo/training/login.htm");
		mainPage = loginPage.genericLogin("test", "secret");
	}
	
	@Test
	public void testAddProductCart() {
		mainPage.inputQuantityBook("Core Java", "5");
		mainPage.inputQuantityBook("Ruby for Rails", "7");
		mainPage.inputQuantityBook("Python Cookbook", "2");
		mainPage.clickAddButton();
		
		assertEquals("3600", mainPage.getTotalValue());
	}
	
}
