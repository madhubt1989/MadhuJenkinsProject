package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class ParametersPractice {
	
	WebDriver driver;
	
    @Parameters("app.browser")
	@Test
	public void launchApp(String browser){
		
		driver = new FirefoxDriver();
		driver.get("https://www.budget.com");
		
	}

}
