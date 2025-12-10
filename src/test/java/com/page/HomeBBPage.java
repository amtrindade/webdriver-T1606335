package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.core.DriverFactory.getDriver;

public class HomeBBPage {
	
	public String getUserLogged() {
		WebElement labelName = getDriver().findElement(By.id("textName"));
		return labelName.getText();		
	}

}
