package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.HomePage;



public class ABG_PageFactory {

	WebDriver driver;
	
	public HomePage getHomePage(){
	return PageFactory.initElements(driver, HomePage.class);
	}

	
}
