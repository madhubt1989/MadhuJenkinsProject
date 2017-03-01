package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import Pages.HomePage;

public class CommonClass2_V2 {
	
	WebDriver driver;
	XSSFWorkbook wb;
	HomePage pg;
	List<WebElement> allDates;
	

	
//======this is common code to select autosuggestion list====================================================================
	
	public void selectAutoSuggestion(String selectLocation)
	{
		 pg = PageFactory.initElements(driver, HomePage.class);
		 
		for (int i = 0; i < pg.locAutoSuggestion.size(); i++) {
			
			WebElement selectLoc = pg.locAutoSuggestion.get(i);
			String selectLocText = selectLoc.getText();
		
			if (selectLocText.contains(selectLocation)) {

				selectLoc.click();
				break;
			}
		}
		
	}

	
//============this is common code to handle excel list============================================================================
	
	public CommonClass2_V2() throws Exception {

		System.out.println("========= Excel file is loading=================");

		String location = "D:\\Madhu Backup\\Edureka\\Workspace\\com.learnautomation.selenium\\TestData\\AppData.xlsx";

		// excel located
		File src = new File(location);

		// convert data in binary/byte format
		FileInputStream fis = new FileInputStream(src);

		// XSSFWorkbook- This will be used .xlsx and HSSFWorkBook- .xls

		// Load the complete excel sheet
		wb = new XSSFWorkbook(fis);

		System.out.println("=============== Excel file is loaded and Ready to use=========================");
	}

	public String readStringData(String sheetName, int rowIndex, int columnIndex) {
		String data = wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();

		return data;
	}

	public int readNumericData(String sheetName, int rowIndex, int columnIndex) {
		int data = (int) wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();

		return data;
	}

	public int getRows(String sheetName) {
		int row = wb.getSheet(sheetName).getPhysicalNumberOfRows();

		return row;
	}

	public int getColumn(String sheetName, int row) {
		int col = wb.getSheet(sheetName).getRow(row).getLastCellNum();

		return col;
	}
	
//============this is common code to handle calander list===========================================================
	
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

			//pg.selectReturnDate();
			allDates= pg.picDateList;
			
		}

		for (WebElement ele : allDates) {
			String loopingDate = ele.getText();
			
			if (loopingDate.equalsIgnoreCase(Integer.toString(date))) {
				
				ele.click();
				break;
			}
		}
	}
	
//===============this is common code to handle Drop down==============================================================================	
	
	public void selectFromDropDown(String text, WebElement element){
		
			Select sle = new Select(element);
			sle.selectByVisibleText(text);
		}

//====================================================================================================================================

public void verifyUrl(){
	String actual  = driver.getTitle();
	String expected = "Reservations";
	Assert.assertEquals(actual, expected);
}

}
