package com.guru99.main.test;

import com.guru99.page.objects.HomePage;
import com.guru99.page.objects.LoginPage;
import com.guru99.page.objects.NewCustomerPage;

public class MainScript extends CommonScript {

	public static void main(String[] args) {
		LoginPage loginPageObject = new LoginPage(driver);
		HomePage homePageObject=new HomePage(driver);
		NewCustomerPage newCustomerPageObject=new NewCustomerPage(driver);

		loginPageObject.setUserName("mgr123");
		loginPageObject.setPassword("mgr!23");
		loginPageObject.clickLoginButton();	
		homePageObject.clickNewCustomerLink();
		newCustomerPageObject.setCustomerName("Chandan Kumar");
		
	}

}
