package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;

public class HomeTest extends  Base {
	
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategory;
	
	@Test
	public void adminUsersPageNavigation() {
		
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.clickonadminusers();
		String actualtext=homepage.getAdminPageheader();
		String expectedtext="Admin Users";
		Assert.assertEquals(actualtext, expectedtext);
		
	}
	
	@Test
	public void verifyDashboardbgcolor() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String actualcolor =homepage.getDashboardbg();
		System.out.println(actualcolor);
		String expectedcolor="";
		Assert.assertEquals(actualcolor, expectedcolor);
	}
	
	@Test
	public void verifySubcategorybgcolor() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String color=homepage.getSubcategorybg();
		System.out.println(color);
	}
	
	@Test(groups ={"Smoke","Regression"})
	public void verifyUserLogo() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String value = homepage.getlogosrcattribute();
		System.out.println(value);	
	}
	
    @Test(groups ={"Smoke","Regression"})
    public void subCategoryNavigation() {
    	loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
	    homepage.clickOnSubcategory();
	    String actualheader= subcategory.subCategoryPageheader();
	    String expectedheader ="List Sub Categories";
	    Assert.assertEquals(actualheader, expectedheader);
	    
    }
}
