package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;

public class SubCategoryTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage SubPage;

	@Test
	public void verifySubCategoryheader() {

		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		SubPage = new SubCategoryPage(driver);

		loginpage.login();
		homepage.clickOnSubcategory();
		String actualheader = SubPage.subCategoryPageheader();
		String expectedheader = "List Sub Categories";
		Assert.assertEquals(actualheader, expectedheader);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void clickOnNew() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		SubPage = new SubCategoryPage(driver);

		loginpage.login();
		homepage.clickOnSubcategory();

		SubPage.clickOnNew();
		String pageheader = "Add 1Sub Category";
		String actualheader = SubPage.newPageheader();
		Assert.assertEquals(pageheader, actualheader);

	}

	@Test(groups = "Smoke")
	public void enterSubCategoryInfo() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		SubPage = new SubCategoryPage(driver);

		loginpage.login();
		homepage.clickOnSubcategory();
        
		SubPage.clickOnNew().addCategory("Appliance").addSubCategory("Phone").clickOnSave();
		String successmsg= "";
	}

	
	@Test
	public void verifyImageUpload() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		SubPage = new SubCategoryPage(driver);

		loginpage.login();
		homepage.clickOnSubcategory();
		
		SubPage.imageupload();
	}
}
