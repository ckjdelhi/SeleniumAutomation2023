package com.testng;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.drivers.DriverManager;

public class FirstTest2 {
 WebDriver driver= null;

 @BeforeClass
 public void beforeClassTest() {
	 System.out.println("Before class message");
 }
 
  @BeforeTest
  public void beforeTest() {
	 System.out.println("Before test message");
	 driver = DriverManager.getDriver("chrome");
  }


  @Test(priority = 0)
  public void openBrowser() {
	  driver.get("https://demo.guru99.com/v4/");
	  Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
  }
 
  @Test(priority = 1)
  public void enterUserName() {
	  driver.findElement(By.name("uid")).sendKeys("mgr123");
	  Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
  }
  
 
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
