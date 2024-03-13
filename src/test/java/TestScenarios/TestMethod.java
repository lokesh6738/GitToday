package TestScenarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.GoogleSearch;
import Objects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethod {
	WebDriver driver;
	//GoogleSearch gs;
	LoginPage lp;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void SearchOperation() {
//		 gs= new GoogleSearch(driver);
//		gs.searchgoogle("facebook");
		lp= new LoginPage(driver);
		lp.searchgoogle("facebook");
		lp.clickUrl();
	}
	
	
	@Test(priority=1)
	public void login() {
		lp.enterCredentials("lokesh", "lokesh");
	}
	
	@AfterTest
	public void aftertest() {
		//driver.quit();
	}

}
