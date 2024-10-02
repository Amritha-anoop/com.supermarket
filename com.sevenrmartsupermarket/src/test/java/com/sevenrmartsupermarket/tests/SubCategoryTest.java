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

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifySubCategoryheader() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		SubPage = homepage.clickOnSubcategory();
		String actualheader = SubPage.subCategoryPageheader();
		String expectedheader = "List Sub Categories";
		Assert.assertEquals(actualheader, expectedheader);
	}

	@Test
	public void clickOnNew() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		SubPage.clickOnNew();
		String pageheader = "Add Sub Category";
		String actualheader = SubPage.newPageheader();
		Assert.assertEquals(pageheader, actualheader);
	}

	@Test(groups = "Smoke")
	public void enterSubCategoryInfo() {
		loginpage = new LoginPage(driver);
		homepage=loginpage.login();
		SubPage=homepage.clickOnSubcategory().clickOnNew().addCategory("Electronics")
				.addSubCategory("lap").imageupload().clickOnSave();
		String expectedsuccessmsg = "Sub Category Created Successfully";
		String successmsg = SubPage.subCategoryPagealert();
		String actualsuccessmsg = successmsg.substring(9);
		Assert.assertEquals(actualsuccessmsg, expectedsuccessmsg);
		}
   
	@Test
	public void verifyCancelButton() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		SubPage = homepage.clickOnSubcategory().clickOnNew().clickCancel();
		String actualheader = SubPage.subCategoryPageheader();
		String expectedheader = "List Sub Categories";
		Assert.assertEquals(actualheader, expectedheader);
		
	}
	@Test
	public void verifySearch() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		SubPage=homepage.clickOnSubcategory().clickSearch().searchCategory("Electronics").enterSubcategory("Laptop").categorySearchclick();
		String actualresult = SubPage.checkSearchResult();
		String expectedresult = "Laptop";
		Assert.assertEquals(actualresult, expectedresult);
	}
	@Test
	public void verifyReset() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		SubPage=homepage.clickOnSubcategory().clickSearch().searchCategory("Electronics").enterSubcategory("Laptop").categorySearchclick()
				.resetClick();
		String actualheader=SubPage.subcategoriespageHeader();
		String expectedheader= "List Sub Categories";
		Assert.assertEquals(actualheader, expectedheader);		
	}
}
