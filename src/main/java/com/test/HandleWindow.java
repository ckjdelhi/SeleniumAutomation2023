package com.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.drivers.DriverManager;

public class HandleWindow {

	public static void main(String[] args) {
		WebDriver driver = DriverManager.getDriver("chrome");
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).submit();
		String mainWindow = driver.getWindowHandle();
		System.out.println("Current page name= "+ mainWindow);
		driver.findElement(By.linkText("Apple iPhone 14 (128 GB) - Midnight")).click();
		
		
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		if (windows.size()>1) {
			String child = windows.get(1);
			if (!mainWindow.equals(child)) {
				driver.switchTo().window(child);
			} 
		}
		
		//or
		
//      Set<String> allOpenedWindow = driver.getWindowHandles();
//		for(String childWin: allOpenedWindow) {
//			if(!mainWindow.equals(childWin)) {
//				driver.switchTo().window(childWin);
//				break;
//			}
//		}
		//child page codes
		
		
		//switch back to main page
		driver.switchTo().window(mainWindow);

	}

}
