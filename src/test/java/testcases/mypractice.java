package testcases;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;

public class mypractice extends HomePage{
	WebDriver driver;
	HomePage pg;
	List<WebElement> allDates;
	
	@Test
	public void startBrowser() {
		
		 driver = new FirefoxDriver();
		driver.get("https://www.avis.com");
		driver.findElement(By.id("PicLoc_value")).sendKeys("EWR");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	List<WebElement> list= 	driver.findElements(By.cssSelector(".res-inputFldBack > div:nth-child(1) > div:nth-child(1) > angucomplete-alt:nth-child(1) > div:nth-child(1) > div:nth-child(3)"));
		//System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			WebElement selectLoc = list.get(i);
			String selectLocText = selectLoc.getText();
			//System.out.println(selectLocText);
			if (selectLocText.contains("Newark Liberty Intl Airport")) {

				selectLoc.click();
				//System.out.println("The selected location from autcomplete is: " + selectLocText);
				break;
			}
		}
		
		calendarDatePicker(true, 30, 12, 2016);
		calendarDatePicker(false, 31, 12, 2016);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectFromDropDown("12:30 AM");
		
	}
	
	public void calendarDatePicker(boolean fromCalender, int date, int month, int year) {
		
		Calendar wanted = Calendar.getInstance();
		wanted.set(Calendar.MONTH, month);
		wanted.set(Calendar.YEAR, year);
		wanted.set(Calendar.DATE, date);
						
		pg = PageFactory.initElements(driver, HomePage.class);
		
		if (fromCalender) {
		
			pg.selectPicUpDate();
			allDates= pg.picDateList;
			

		} else {

			allDates= pg.picDateList;
			
		}

		for (WebElement ele : allDates) {
			String loopingDate = ele.getText();
			//System.out.println("looping Date is: " + loopingDate);

			if (loopingDate.equalsIgnoreCase(Integer.toString(date))) {
				//System.out.println("looping element is: " + ele);
				ele.click();
				break;
			}
		}
	}
	
	public void selectFromDropDown(String value){
	WebElement ele = driver.findElement(By.xpath("//select[@class='form-control res-inputTime ng-valid ng-not-empty ng-touched ng-dirty ng-valid-parse']"));
	ele.click();
		Select sle = new Select(ele);
		sle.selectByVisibleText(value);
	}
	
	
	
}
