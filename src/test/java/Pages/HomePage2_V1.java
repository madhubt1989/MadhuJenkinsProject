package Pages;

import java.util.List;

import org.apache.bcel.generic.LCONST;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.CommonClass;



public class HomePage2_V1 extends CommonClass{

	public HomePage2_V1() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "PicLoc_value")
	WebElement pickUpLocation;
	@FindBy(css=".angucomplete-dropdown-visible > div:nth-child(3) > div:nth-child(3)")
	public
	List<WebElement> locAutoSuggestion;
	@FindBy(css = "#from") public WebElement pickUpDate;
	@FindBy(xpath = "//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a") public List<WebElement> picDateList;
				     
	@FindBy(xpath = "//div[@id='ui-datepicker-div']/div[2]/table/tbody")
	List<WebElement> allDate;
	@FindBy(css = ".form-control.res-inputTime.ng-pristine.ng-valid.ng-not-empty.ng-touched")
	WebElement pickUpTime;
	@FindBy(css = "#DropLoc_value")
	WebElement dropLocation;
	@FindBy(css = "#to")
	WebElement returnDate;
	@FindBy(css = ".form-control.res-inputTime.ng-pristine.ng-untouched.ng-valid.ng-not-empty")
	WebElement dropTime;
	//@FindBy(css = ".ageDrop") public WebElement age;  
	
	@FindBy(xpath = "//select[@id='reservationModel.personalInfoRQ.age']") public WebElement age;
	@FindBy(css = ".residencyClass")
	WebElement residency;
	@FindBy(css = ".res-wizardFld.form-controlD")
	WebElement avisWizardNumber;
	@FindBy(css = ".res-discFld.form-controlD")
	WebElement discountCodes;
	@FindBy(css = "#res-home-vehicle-type")
	WebElement vehicleType;
	@FindBy(css = "#res-home-select-car")
	WebElement selectMyCar;
	
	
	public void enterPickUpLocation(String picLoc) {
		pickUpLocation.sendKeys(picLoc);		
	}


	public void selectPicUpDate() {
		pickUpDate.click();

	}
	
	public void selectReturnDate(){
		returnDate.click();
	}
	

	public void selectAge(){
		selectFromDropDown("24", age);
	}
	
	public void clickSelectMyCar(){
		selectMyCar.click();
	}

//=============Step2 Locators===================================================================================================================
	
	@FindBy(xpath = "//div[div[h3[contains(text(),'Economy')]]]/following-sibling::div//a[contains(text(),'Pay at Counter')]")
	WebElement clickPayAtCounterButton;
	
	public void clickPayAtCounterButton(){
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickPayAtCounterButton.click();

	}
	
//=============Step3 Locators===================================================================================================================
	
	@FindBy(css ="#res-extras-continue-top") WebElement clickContinueButton;
	
	public void clickContinueButton(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickContinueButton.click();
	}
	
//=============Step4 Locators===================================================================================================================
	
	@FindBy(css ="#firstname") WebElement firstName;
	@FindBy(css ="#lastname") WebElement lastName;
	@FindBy(css ="#email") WebElement email;
	@FindBy(css ="#airlineobj") WebElement selectAirline;
	@FindBy(xpath ="//input[@name='flightnumberMob']") WebElement flightNumber;
	@FindBy(css="#submit_button") WebElement clickReserveButton;
	
	public void enterFirstName(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		firstName.sendKeys("Madhu");
	}
	
	public void enterlastName(){
		lastName.sendKeys("B");
	}
	
	public void enterEmail(){
		email.sendKeys("Madhu@test.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectAirline(){
		selectFromDropDown("SOUTHWEST AIRLINES", selectAirline);
	}
	
	public void enterFlightNumber(){
		flightNumber.sendKeys("F123");
	}
	
	public void clickReserveButton(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickReserveButton.click();
	}
}
