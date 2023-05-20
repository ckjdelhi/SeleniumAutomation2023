package com.test.drivers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\chand\\Desktop\\selenium\\screenshot\\"+fileName+".jpg"));
	}
	public static WebElement findElement(WebDriver driver, By by) {
		return driver.findElement(by);
	}
}
