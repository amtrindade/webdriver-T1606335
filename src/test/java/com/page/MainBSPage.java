package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainBSPage {
	
	public Boolean isUserLogged() {
		WebElement divAvailable = getDriver().findElement(By.id("available"));
		return divAvailable.isDisplayed();		
	}
	
	public MainBSPage inputQuantityBook(String nameBook, String quantity) {
		WebElement tfQuantity = getDriver().findElement(By.xpath("//td[.='"+ nameBook +"']/..//input"));
		tfQuantity.sendKeys(quantity);
		return this;
	}
	
	public MainBSPage clickAddButton() {
		WebElement btnAdd = getDriver().findElement(By.xpath("//input[@value='Add']"));
		btnAdd.click();
		return this;		
	}
	
	public String getTotalValue() {
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		return tfTotal.getAttribute("value");
	}

}
