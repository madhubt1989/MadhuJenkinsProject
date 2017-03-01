package testcases;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;


public class HomePageTC extends CommonClass{

	public HomePageTC() throws Exception {
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

	@Test(dataProvider = "location", description="This TC verify Create Reservation and cancel Reservation")
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
		
		calendarDatePicker(true, 14, 01, 2017);
		
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		calendarDatePicker(false, 15, 01, 2017);
						
       pg.selectAge();
       pg.clickSelectMyCar();
       
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(pg.clickPayAtCounterButton));
       
       pg.clickPayAtCounterButton();
       pg.clickContinueButton();
       pg.enterFirstName();
       pg.enterlastName();
       pg.enterEmail();
      // pg.selectAirline();
      // pg.enterFlightNumber();
	   pg.clickReserveButton();
	   //pg.verifyErrorMessage();
	   wait.until(ExpectedConditions.visibilityOf(pg.confirmationMessage));
	   pg.verifyConfirmationMessageNumber();
	   pg.cancelReservatoin();
	
	}

}
