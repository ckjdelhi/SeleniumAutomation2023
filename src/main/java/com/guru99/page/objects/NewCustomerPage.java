package com.guru99.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver driver;
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//By nameWL= By.name("name");
	@FindBy(name = "name")
	WebElement nemeWL;
	
	public void setCustomerName(String string) {
		//driver.findElement(nameWL).sendKeys(string);	
		nemeWL.sendKeys(string);
	}
}
