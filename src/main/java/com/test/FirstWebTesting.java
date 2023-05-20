package com.test;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.test.drivers.DriverManager;
import com.test.drivers.Utility;

/*
 * Wait:
 * 1.implicit wait
 * 2.explicit wait
 * 3.Fluent wait
 */
public class FirstWebTesting {

	public static void main(String[] args) throws Exception {
		WebDriver driver = DriverManager.getDriver("chrome");
		//Home Page
		driver.get("https://demo.guru99.com/v4/");
		Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
		driver.findElement(By.name("uid")).sendKeys("mgr123");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("mgr!23");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).submit();
		//Thread.sleep(3000);
		Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
		//New Customer
		driver.findElement(By.linkText("New Customer")).click();
		driver.findElement(By.name("name")).sendKeys("Chandan Kumar");
		driver.findElements(By.name("rad1")).get(0).click();
//		List<WebElement> genders=driver.findElements(By.name("rad1"));
//		genders.forEach(p -> {
//			if(p.getAttribute("value").equals("f")) {
//				p.click();
//			}
//		});
		driver.findElement(By.id("dob")).sendKeys("01012000");
	
		//New Account
		//driver.findElement(By.linkText("New Account")).click();
		driver.get("https://demo.guru99.com/v4/manager/addAccount.php");
		if(driver.getCurrentUrl().contains("google_vignette")) {
			driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();
		}
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("12344");
		WebElement elAccount = driver.findElement(By.name("selaccount"));
		Select select = new Select(elAccount);
		select.selectByIndex(1);
		Date d=new Date();
		Utility.takeScreenshot(driver, "new_account"+d.getTime());
	}
}
