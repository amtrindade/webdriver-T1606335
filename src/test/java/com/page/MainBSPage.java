package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainBSPage {
	
	public Boolean isUserLogged() {
		WebElement divAvailable = getDriver().findElement(By.id("available"));
		return divAvailable.isDisplayed();		
	}

}
