package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	
	WebDriver driver;
	
	PageUtility pageutil;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")
	private WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']")
	private WebElement usertypefield;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement save;
	@FindBy(xpath="//h3[@class='card-title']")
	private WebElement categoryheader;		
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageutil = new PageUtility(driver);
	}
    
	public AdminUsersPage clickNew() {
		newbutton.click();
		return this;
	}
	
	public AdminUsersPage enterUsername(String username) {
		usernamefield.sendKeys(username);
		return this;
		
	}
	
	public AdminUsersPage enterPassword(String password) {
		passwordfield.sendKeys(password);
		return this;
		
	}
	
	public AdminUsersPage selectUsertype(String usertype) {
		pageutil.selectByVisibletext(usertypefield, usertype);
		return this;
	}
	public AdminUsersPage clickSavebutton() {
		save.click();
		return this;
	}
	public String adminPageHeader() {
		return categoryheader.getText();
		
	}
	
	
	
}
	

