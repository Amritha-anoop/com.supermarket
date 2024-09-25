package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {

	WebDriver driver;	
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@type='text']")
	private WebElement userNameField;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signInButton;
	
	@FindBy(xpath="//label[@for='remember']")
	private WebElement remembermecheckbox;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible'])")
	private WebElement alert;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream inputStream=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(inputStream);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
		}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
		}
	
	public void clickOnSiginButton() {
		signInButton.click();
		}
	
	public String isInvalidCredentials() {
		String expectedtext = alert.getText();
		return expectedtext ;
	}
	
	public void isRemembermeCheckbox() {
		
	  boolean status = remembermecheckbox.isEnabled();
	  System.out.println(status);
	  if(status == true) {
		  remembermecheckbox.click();
	  }	
	
	}
	
	public HomePage login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSiginButton();
		/**returns object of HomePage**/
		return new HomePage(driver);	
		}
	
	/**FUNCTION TO CALL WITHOUT PARAMETER FOR LOGIN**/
	public void login() {
		
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSiginButton();
		}

	
	
	}
	

