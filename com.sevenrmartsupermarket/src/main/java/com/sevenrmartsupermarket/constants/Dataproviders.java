package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class Dataproviders {
	
	ExcelReader excelreader = new ExcelReader();
	
	@DataProvider(name="logindetails")
	public Object[][] Login()
	{
		/**to fetch data from excel file**/
		excelreader.setExcelFile("Login Credentials","Adminusers");
		return excelreader.getMultidimentionalData(3, 3);
		
	}
   
}
