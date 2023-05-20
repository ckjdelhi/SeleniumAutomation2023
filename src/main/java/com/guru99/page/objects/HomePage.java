package com.guru99.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.drivers.Utility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By newCustomerLinkWL = By.linkText("New Customer");
	By editCustomerLinkWL = By.linkText("Edit Customer");
	By newAccountLinkWL = By.linkText("New Account");
	
	public void clickNewCustomerLink() {
		Utility.findElement(driver, newCustomerLinkWL).click();	
		//driver.findElement(newCustomerLinkWL).click();
	}
	public void clickEditCustomerLink() {
		Utility.findElement(driver, editCustomerLinkWL).click();	
	}
	public void clickNewAccountLink() {
		Utility.findElement(driver, newAccountLinkWL).click();	
	}
	
}
