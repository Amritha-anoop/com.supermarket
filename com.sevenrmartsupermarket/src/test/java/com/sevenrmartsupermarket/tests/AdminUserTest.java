package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;


public class AdminUserTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;

	AdminUsersPage adminPage;
	
	@Test
	public void verifyAdminUsersPageNavigation() {
		loginpage = new LoginPage(driver);
		homepage = 	loginpage.login();
		homepage.clickonadminusers();
		String actualtext = homepage.getAdminPageheader();
		String expectedtext = "Admin Users";
		Assert.assertEquals(actualtext, expectedtext);
	}
	@Test
	public void verifyNewNavigation() {
		loginpage = new LoginPage(driver);
		homepage = 	loginpage.login();
		homepage.clickonadminusers();
		adminPage = new AdminUsersPage(driver);
		adminPage.clickNew();
		String actualheader = adminPage.adminPageHeader();
		String expectedheader ="Admin Users Informations";
		Assert.assertEquals(actualheader, expectedheader);
	}
	@Test
	public void enterAdminUserInfo() {
		loginpage = new LoginPage(driver);
		homepage = 	loginpage.login();
		adminPage= homepage.clickonadminusers().clickNew().enterUsername("Amritha123").enterPassword("Test1234").selectUsertype("Admin").clickSavebutton();
	}
	

}
