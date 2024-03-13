package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
	WebDriver driver;
	public GoogleSearch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//textarea[@name='q']") public WebElement searchBox;
	@FindBy(xpath="(//input[@name='btnK'])[1]") public WebElement seacrhBtn;
	@FindBy(xpath="//a//h3[text()='Facebook - log in or sign up']") WebElement searchItem;
	
	public void searchgoogle(String searchinput) {
		try {
			searchBox.sendKeys(searchinput);
			seacrhBtn.click();
			Thread.sleep(6000);
		}
		catch(Exception e){
			System.out.println("Exception caught"+ e.getMessage());
		}
	}
	
	public void clickUrl() {
		try {
			searchItem.click();
		}
		catch(Exception e) {
			System.out.println("Exception caught"+ e.getMessage());
		}
	}

}
