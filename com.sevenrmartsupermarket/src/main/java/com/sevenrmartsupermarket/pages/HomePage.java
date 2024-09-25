package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	
	WebDriver driver;
	
	GeneralUtility util = new GeneralUtility();
	
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement profileName;
	
	@FindBy(xpath="//div[@class='inner']//p[(text()='Sub Category')]//following::a[1]")
	private WebElement subcategory;
	
	
   @FindBy(xpath="//div[@class='inner']//p[(text()='Admin Users')]//following::a[1]")
   private WebElement adminusers;
   
 
   @FindBy(xpath="//div[@class='col-lg-3 col-6']//p[text()='Admin Users']")
   private WebElement adminusertile;
   
 
   @FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/user2-160x160.jpg']")
   private WebElement logo;
   

   @FindBy(xpath="//div[@class='small-box bg-info']//p[text()='Dashboard']")
   private WebElement Dashboard;
   
   @FindBy(xpath="//h1[@class='m-0 text-dark']")
   private WebElement adminheader;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() {
		return profileName.getText();	
	}
	
	public void clickOnSubcategory() {
		subcategory.click();
	}
	
	public void clickonadminusers() {
		adminusers.click();
	}
	
	public String getAdminPageheader() {
		return adminheader.getText();
	}
	public String getadminusersBackgroundcolor() {
		return util.get_CssValue(adminusertile, "background-color");
	}
	
	public String getlogosrcattribute() {	
		return util.get_Attribute(logo, "src");	
	}
	
	public String getDashboardbg() {
		return util.get_CssValue(Dashboard, "background-color");
	}
	
	public String getSubcategorybg() {
		return util.get_CssValue(subcategory, "background-color");
	}

}
