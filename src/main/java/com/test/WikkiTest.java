package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.test.drivers.DriverManager;

public class WikkiTest {

	public static void main(String[] args) {
		WebDriver driver = DriverManager.getDriver("chrome");
		driver.get("https://www.wikipedia.org/");
		WebElement el = driver.findElement(By.id("searchLanguage"));
		Select language=new Select(el);
		System.out.println(language.getOptions().size());
		//language.selectByIndex(2);
		language.selectByValue("bn");
		//language.selectByVisibleText("हिन्दी");
	}

}
