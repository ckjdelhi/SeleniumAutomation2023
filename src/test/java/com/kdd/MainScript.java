package com.kdd;

public class MainScript {

	public static void main(String[] args) throws Exception {
		Utility utility = new Utility();
		String [][]data = utility.fetchDataFromExcel();
		for(int i=1;i<data.length;i++) {
			String function = data[i][3];
			String locator = data[i][4];
			String locatorValue = data[i][5];
			String parameter = data[i][6];
			System.out.println(function +"\t"+locator+"\t"+locatorValue+"\t"+parameter);
			if(function.equals("openBrowser")) {
				utility.openBrowser();
			}else if(function.equals("fillTextBox")) {
				utility.fillTextBox(locator, locatorValue, parameter);
			}else if(function.equals("clickButton")) {
				utility.clickButton(locator, locatorValue);
			}
		}
	}

}
