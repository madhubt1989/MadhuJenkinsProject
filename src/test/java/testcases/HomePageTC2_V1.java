package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;


public class HomePageTC2_V1 extends CommonClass{

	public HomePageTC2_V1() throws Exception {
		super();

	}

	HomePage pg;

	@DataProvider(name = "location")
	public Object[][] getDataApp() {

		System.out.println("=====Test Data is getting ready============");

		int rowcount = getRows("ABGData");

		Object[][] logins = new Object[rowcount][1];

		for (int i = 0; i < rowcount; i++) {

			logins[i][0] = readStringData("ABGData", i, 0);

		}

		return logins;

	}

	@BeforeClass
	public void startBrowser() {
	driver = new FirefoxDriver();
	driver.get("https://www.avis.com");	
	driver.manage().window().maximize();
	}

	@Test(dataProvider = "location")
	public void homePage(String picLoc) {

		pg = PageFactory.initElements(driver, HomePage.class);
		pg.enterPickUpLocation(picLoc);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selectAutoSuggestion("EWR");
		calendarDatePicker(true, 26, 12, 2016);
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		calendarDatePicker(false, 27, 12, 2016);
		
	
		
	
	}

}
