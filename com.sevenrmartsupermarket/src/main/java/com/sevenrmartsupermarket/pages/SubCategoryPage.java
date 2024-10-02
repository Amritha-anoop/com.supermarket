package com.sevenrmartsupermarket.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {

	WebDriver driver;

	PageUtility pageutil;

	WaitUtility waitutility;

	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement subcategoryheader;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement addsubcategory;

	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement category;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement subcategory;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;

	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefile;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement subcategorysuccessmessage;
	
	@FindBy(xpath="//a[@type='button']")
	private WebElement cancel;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement search;
	
	@FindBy(xpath="//tbody//tr//td[text()='Laptop']")
	private WebElement searchresult;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement subcategorysearch;
	
	@FindBy(xpath="//a[@type='button']")
	private WebElement reset;
	
	@FindBy(xpath="//h4[text()='List Sub Categories']")
	private WebElement subcategoriesheader;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageutil = new PageUtility(driver);
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
		waitutility = new WaitUtility(driver);
		waitutility.waitforElementtobeClickable(savebutton);
		//savebutton.click();
		pageutil.scrollAndClick(savebutton);
		return this;
	}

	public SubCategoryPage imageupload () {
		pageutil.imageUpload(choosefile, "Image1.jpg");
		return this;
	}
	
	public String subCategoryPagealert() {
		String msg = subcategorysuccessmessage.getText();
		return msg;	
	}
    
	public SubCategoryPage clickCancel() {
		cancel.click();
		return this;
	}
	
	public SubCategoryPage clickSearch() {
		search.click();
		return this;
	}
	public SubCategoryPage searchCategory(String subcategoryitem) {
		pageutil.selectByVisibletext(category, subcategoryitem);
		return this;
	}
	public SubCategoryPage enterSubcategory(String subCategory) {
		subcategory.sendKeys(subCategory);
		return this;
	}
	public String checkSearchResult() {
	  return searchresult.getText();
	  
	}
	public SubCategoryPage categorySearchclick() {
		subcategorysearch.click();
		return this;
	}
	public SubCategoryPage resetClick() {
		reset.click();
		return this;	
	}
	public String subcategoriespageHeader() {
		return subcategoriesheader.getText();
	}
}
