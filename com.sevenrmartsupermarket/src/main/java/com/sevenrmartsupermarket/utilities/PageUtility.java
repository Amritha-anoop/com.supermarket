package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	/** globally declaring objects so that we don't have to declare inside class **/
	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void selectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public String selectByVisibletext(WebElement category, String visibletext) {
		Select select = new Select(category);
		 select.selectByVisibleText(visibletext);
		 return visibletext;
	}

	public void mouseClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();

	}

	/** javascript executor code implement **/
	public void jsScrollToElement(WebElement element) {

		/** to scroll down till a webelement is visible **/
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void jsClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void scrollAndClick(WebElement element) {
		int index = 0;
		
		while(!isClicked(element)) {
			while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + index + ")");
		    index = index+5;
		}
	}
	}
	public boolean isClicked(WebElement element) {
		
		try {
			
			element.click();
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}

	public void rightClick(WebElement element) {

		Actions actions = new Actions(driver);
		WebElement rightclick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		actions.contextClick(rightclick).build().perform();

		/**
		 * Double click WebElement doubleclick =
		 * driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		 * actions.doubleClick(doubleclick).build().perform();
		 * driver.switchTo().alert().accept();
		 **/
	}

	public void imageupload(WebElement element) {

	}
}
