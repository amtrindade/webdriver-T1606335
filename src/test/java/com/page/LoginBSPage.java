package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginBSPage {
	
	public LoginBSPage open(String url) {
		getDriver().get(url);		
		return this;
	}
	
	public LoginBSPage inputUserName(String userName) {
		WebElement tfUser = getDriver().findElement(By.name("user"));
		tfUser.sendKeys(userName);		
		return this;
	}
	
	public LoginBSPage inputPass(String pass) {
		WebElement tfPass = getDriver().findElement(By.name("password"));
		tfPass.sendKeys(pass);		
		return this;
	}
	
	public MainBSPage clickBtnLogin() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();		
		return new MainBSPage();
	}
	
	public MainBSPage genericLogin(String userName, String password) {
		inputUserName(userName);
		inputPass(password);
		return clickBtnLogin();		
	}
	

}
