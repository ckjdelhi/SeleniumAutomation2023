package com.test;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/chand/Desktop/alert.html");
		//driver.findElement(By.name("uid")).sendKeys("mgr123");
		//driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345");
		//driver.findElement(By.xpath("//input[@name='btnLogin']")).submit();
		Alert alertObj = driver.switchTo().alert();
		System.out.println(alertObj.getText());//User or Password is not valid
		alertObj.sendKeys("chandan kumar");
		alertObj.accept();
		//Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
		
	}

}
