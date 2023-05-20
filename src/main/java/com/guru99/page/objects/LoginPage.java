package com.guru99.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.drivers.Utility;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//Web Elements
	By userNameWL=By.name("uid");
	By passwordWL = By.cssSelector("input[name='password']");
	By loginBtnWL = By.xpath("//input[@name='btnLogin']");
	
	public void setUserName(String userName) {
		driver.findElement(userNameWL).sendKeys(userName);
	}
	public void setPassword(String password) {
		Utility.findElement(driver, passwordWL).sendKeys(password);
	}
	public void clickLoginButton() {
		Utility.findElement(driver,loginBtnWL).submit();
	}
	
	
}
