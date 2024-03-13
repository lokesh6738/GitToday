package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddtoCartPage extends SearchPage{
	
	
	@FindBy(xpath="(//input[@name='submit.add-to-cart'])[2]")
    WebElement button_AddtoCart;
	@FindBy(xpath="//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")
	WebElement proceedBtn;
	@FindBy(xpath="//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")
	WebElement Continue;
	
	public AddtoCartPage(WebDriver driver)
	{
		super(driver);
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void addToCart() throws InterruptedException
	{
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button_AddtoCart);
		WebDriverWait w = new WebDriverWait(driver,10);
		button_AddtoCart.click();
		w.until(ExpectedConditions.visibilityOf(proceedBtn));
		proceedBtn.click();
		Continue.click();
	}
	
	
	
}
