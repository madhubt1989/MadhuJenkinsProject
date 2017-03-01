package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class CommonMethods {
	
	WebDriver driver;
	
	@Test
	public void datePicker(){
		
	List<WebElement> allDates=driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody"));
	
	for(WebElement ele:allDates){
		
		String date = ele.getText();
		
		if(date.equalsIgnoreCase("28"))
		{
			ele.click();
			break;
		}
	}
	
	}

}
