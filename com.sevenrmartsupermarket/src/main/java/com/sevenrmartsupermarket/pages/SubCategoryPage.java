package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {
	
	WebDriver driver;
	
	PageUtility pageutil = new PageUtility(driver);
	
	WaitUtility waitutility;
	
	@FindBy(xpath="//h1[text()='List Sub Categories']")
	private WebElement subcategoryheader;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement addsubcategory;
	
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	private WebElement category;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement subcategory;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebutton;
	
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement choosefile;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement subcategorysuccessmessage;
	
	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

   public String subCategoryPageheader() {
	   
	  return subcategoryheader.getText();
   }
	
   public SubCategoryPage clickOnNew() {
	   newbutton.click();
	   return this;  
   }
   public String newPageheader() {
	   return addsubcategory.getText();
	  
   }
   
   public SubCategoryPage addCategory(String categoryitem) {
	   
	   pageutil.selectByVisibletext(category, categoryitem);
	   return this;
   }
   
   public SubCategoryPage addSubCategory(String subCategory) {
	   subcategory.sendKeys(subCategory);
	   return this;
   }
 
   public SubCategoryPage clickOnSave() {
	   
	   waitutility= new WaitUtility(driver);
	   waitutility.waitforElementtobeClickable(savebutton);
	   savebutton.click();
	   return this;
   }
   
   public void imageupload() {
	   String path = "C:\\Users\\_\\git\\repository2\\com.sevenrmartsupermarket\\src\\main\\resources\\Images";
	   choosefile.sendKeys(path);
   }
 
   
}
