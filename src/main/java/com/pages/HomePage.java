package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class HomePage {
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement signIn;
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement username;
	@FindBy(id="continue")
	WebElement Continue;
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	WebElement password;
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement list_Category;
	@FindBy(id="nav-search-dropdown-card")
	WebElement button_List;
	@FindBy(id="signInSubmit")
	WebElement signinBtn;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement txtBox_Search;
	@FindBy(id="nav-search-submit-button")
	WebElement button_Search;
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void SignIn(String usrname,String pwd) {
		signIn.click();
		username.sendKeys(usrname);
		Continue.click();
		password.sendKeys(pwd);
		signinBtn.click();
	}
	
	public void verifyTitle(){
		String title = driver.getTitle();
		if(title.equals("amazon")){
			System.out.println("Amazon india opened");
		}
		Assert.assertEquals("amazon",title);
	}
	
	public void selectCategory()
	{
		//button_List.click();
		Select select = new Select(list_Category);
		select.selectByVisibleText("Computers & Accessories");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
}
