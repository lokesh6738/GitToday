package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage extends HomePage{
	
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
    WebElement searchInput;
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> items ;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	public void enterSearchItem(String inputValue){
		searchInput.sendKeys(inputValue);
		searchBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void getReturnedItems() {
		for(WebElement item:items) {
			System.out.println(item.getText());
		}
	}
	
	public void clickItem() {
		items.get(0).click();
	}
	
}
