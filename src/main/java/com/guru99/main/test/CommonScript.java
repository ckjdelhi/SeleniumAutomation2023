package com.guru99.main.test;

import org.openqa.selenium.WebDriver;

import com.test.drivers.DriverManager;

public class CommonScript {
	public static WebDriver driver = DriverManager.getDriver("chrome");
	
	static {
		driver.get("https://demo.guru99.com/v4/");
	}
	
}
