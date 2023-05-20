package com.testng;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.drivers.DriverManager;

public class FirstTest {
 WebDriver driver= null;
 ExtentReports extent = null;
 @BeforeClass
 public void beforeClassTest() {
	 System.out.println("Before class message");
 }
 
  @BeforeTest
  public void beforeTest() {
	  extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("target-output/Spark.html");
	  extent.attachReporter(spark);
	  
	 System.out.println("Before test message");
	 driver = DriverManager.getDriver("chrome");
  }


  @Test(priority = 0, groups="t1")
  public void openBrowser() {
	  ExtentTest t1= extent.createTest("openBrowser testcase");
	  driver.get("https://demo.guru99.com/v4/");
	  //Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
	  if(driver.getTitle().equals("Guru99 Bank Home Page111")) {
		  t1.log(Status.PASS, "Able to open guru99 url and matched title. it passed!");
	  }else {
		  t1.log(Status.FAIL, "Not Able to open guru99 url and not matched title. it failed!");
	  }
  }
 
  @Test(priority = 1, dependsOnMethods = "openBrowser", groups="t1")
  public void enterUserName() {
	  ExtentTest t1= extent.createTest("enterUserName testcase");
	  driver.findElement(By.name("uid")).sendKeys("mgr123");
	  Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
	  t1.log(Status.PASS, "Able to fill username. it passed!");
  }
  
  @Test(dependsOnGroups = "t1")
  public void test() {
	  
  }
 
  @AfterTest
  public void afterTest() {
	  driver.quit();
	  extent.flush();
  }

}
