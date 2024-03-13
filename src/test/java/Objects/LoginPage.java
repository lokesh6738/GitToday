package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends GoogleSearch {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="email") WebElement username;
	@FindBy(id="pass") WebElement password;
	@FindBy(name="login") WebElement loginBtn;
	
	public void enterCredentials(String usr,String pwd) {
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginBtn.click();
	}

	

}
