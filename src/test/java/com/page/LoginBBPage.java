package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginBBPage {

	public LoginBBPage open(String url) {
		getDriver().get(url);		
		return this;
	}

	public RegisterBBPage clickRegistrar() {
		WebElement btnRegistrar = getDriver().findElement(By.xpath("//button[.='Registrar']"));
		btnRegistrar.click();
		return new RegisterBBPage();
	}
	
	public LoginBBPage inputEmail(String mail) {
		WebElement tfEmail = getDriver().findElement(By
				.xpath("//div[@class='card__login']//input[@name='email']"));
		tfEmail.sendKeys(mail);
		return this;
	}
	
	public LoginBBPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By
				.xpath("//div[@class='card__login']//input[@name='password']"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public HomeBBPage clickAcessar() {
		WebElement btnAcessar = getDriver().findElement(By.xpath("//button[.='Acessar']"));
		btnAcessar.click();
		return new HomeBBPage();
	}

}
