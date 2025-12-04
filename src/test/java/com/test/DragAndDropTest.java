package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.core.BaseTest;

public class DragAndDropTest extends BaseTest{	

	@BeforeEach
	public void setUp() throws Exception {				
		getDriver().get("https://jqueryui.com/resources/demos/droppable/default.html");		
	}

	@Test
	public void testDragAndDrop() throws InterruptedException {
		WebElement divOrigin = getDriver().findElement(By.id("draggable"));
		WebElement divTarget = getDriver().findElement(By.id("droppable"));
		
		assertEquals("Drop here", divTarget.getText());
		
		new Actions(getDriver()).dragAndDrop(divOrigin, divTarget).perform();
		
		assertEquals("Dropped!", divTarget.getText());
		
		Thread.sleep(2000);
		
		new Actions(getDriver()).dragAndDropBy(divOrigin, 200, 200).perform();
	}
}
