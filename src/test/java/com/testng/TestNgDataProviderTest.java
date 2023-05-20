package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviderTest {
	
	
	@DataProvider(name = "testdata")
	public String[][] testData() {
		//excel code to fetch data
		String [][]data = {
				{"mgr123", "mgr!23"},
				{"mgr124", "mgr!21"},
		};
		return data;
	}
	
	@Test(dataProvider = "testdata")
	public void testDP(String userName, String password) {
		System.out.println("testing:"+ userName +"\t"+password);
	}
	
	
}
