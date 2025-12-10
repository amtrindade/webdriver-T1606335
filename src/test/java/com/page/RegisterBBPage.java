package com.page;

import static com.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterBBPage {
	private WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
	
	public RegisterBBPage inputEmail(String email) {
		WebElement tfEmail = getDriver().findElement(By
				.xpath("//div[@class='card__register']//input[@name='email']"));
		tfEmail.sendKeys(email);
		return this;
	}
	
	public RegisterBBPage inputName(String name) {
		WebElement tfName = getDriver().findElement(By.name("name"));
		tfName.sendKeys(name);
		return this;
	}
	
	public RegisterBBPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By
				.xpath("//div[@class='card__register']//input[@name='password']"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public RegisterBBPage inputConfirmationPassword(String pass) {
		WebElement tfConfirmation = getDriver().findElement(By.name("passwordConfirmation"));
		tfConfirmation.sendKeys(pass);
		return this;
	}
	
	public RegisterBBPage clickToggleSaldo() {
		String locator = "toggleAddBalance";		
		WebElement toggleSaldo = getDriver().findElement(By.id(locator));
		//TODO refazer a espera específica
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		toggleSaldo.click();
		return this;
	}
	
	public RegisterBBPage clickCadastrar() {
		WebElement btnCadastrar = getDriver().findElement(By.xpath("//button[.='Cadastrar']"));
		btnCadastrar.click();
		return this;
	}
	
	public Boolean isPartialMessageExist(String partialMessage) {
		WebElement message = getDriver().findElement(By.id("modalText"));
		return partialMessage.contains(message.getText());		
	}
	
	public LoginBBPage clickClose() {
		WebElement btnClose = getDriver().findElement(By.id("btnCloseModal"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseModal")));
		btnClose.click();
		return new LoginBBPage();
	}

}

