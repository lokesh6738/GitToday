package com.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.AddtoCartPage;
import com.pages.HomePage;
import com.pages.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Test_Amazon {
	
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    AddtoCartPage addToCartPage;
   
       
	@BeforeSuite
	public void launchwebsite()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		homePage = new HomePage(driver);
		homePage.SignIn("8977436643", "8977436643");
	}
	
	@Test(priority=0,enabled=true)
	public void searchProduct() 
	{
		homePage = new HomePage(driver);
		homePage.verifyTitle();
		homePage.selectCategory();
		//homePage.enterSearchValue();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyProduct() 
	{
		searchPage = new SearchPage(driver);
		searchPage.enterSearchItem("HP Pavilion");
		searchPage.getReturnedItems();
		searchPage.clickItem();
	}
	
	@Test(priority=2,enabled=true)
	public void addToCart() throws InterruptedException 
	{
		addToCartPage = new AddtoCartPage(driver);
		addToCartPage.addToCart();
		
	}
	
	@AfterSuite
	public void CloseChrome()
	{
		driver.quit();
	}
	
}
