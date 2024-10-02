package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.Dataproviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();

	@Test(groups = "Smoke")
	public void verifyLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		/** Faker class **/
		String name = GeneralUtility.getRandomFirstName();
		System.out.println(name);
		String actualprofilename = homepage.getProfileName();
		String expectedprofilename = "Admin";
		Assert.assertEquals(actualprofilename, expectedprofilename);
	}

	@Test
	public void verifyRememberme() {
		loginpage = new LoginPage(driver);
		loginpage.isRemembermeCheckbox();
		Assert.assertTrue(true);
	}

	@Test(groups = { "Smoke", "Regression" })
	public void verifyInvalidcredentials() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "123");
		String message=loginpage.isInvalidCredentials();
		System.out.println(message);
		String actualtext=message.substring(9);
		String expectedtext = "Invalid Username/Password";
		Assert.assertEquals(actualtext, expectedtext);
	}

	/** login using data provider **/
	@Test(dataProvider = "logindetails", dataProviderClass = Dataproviders.class)
	public void verifyLogin(String Username, String password,String expectedprofileName) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login(Username, password);
		String actualprofilename=homepage.getProfileName();
		System.out.println(actualprofilename);
		Assert.assertEquals(actualprofilename, expectedprofileName);
		
	}
}
