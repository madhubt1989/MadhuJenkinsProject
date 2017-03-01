package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.HomePage;

public class CommonClass {
	
	protected WebDriver driver;
	XSSFWorkbook wb;
	HomePage pg;
	List<WebElement> allDates;
	protected WebDriverWait wait;
	
	
//======this method starts the browser==================================================================	
	
	
	public void startBrowser() {
		driver = new FirefoxDriver();
		driver.get("https://www.avis.com");	
		driver.manage().window().maximize();
		}
	
	
//======this is common code to launch browser with url====================================================================
	
	
static String chromePath = "D:\\Madhu Backup\\Edureka\\Jars\\chromedriver_win32\\chromedriver.exe";
	
	
	public WebDriver startBrowser(String browserName, String url) {
		
		if (browserName.equalsIgnoreCase("firefox"))
						
		{
//			System.setProperty("webdriver.gecko.driver", firefoxPath);
			//driver = new MarionetteDriver();
			driver=new FirefoxDriver();
			
		} 
		
		else if(browserName.equalsIgnoreCase("IE"))
		 {
		//System.setProperty(webdriver.ie.driver, value);
		 }
		
		else 
		{
		System.setProperty("webdriver.chrome.driver", chromePath);
      	driver = new ChromeDriver();
			
		}
			
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		return driver;
	} 


	
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
	
	public CommonClass() throws Exception {

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
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			allDates= pg.picDateList;
			

		} else {
			
//			try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			pg.selectReturnDate();
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

	public void verifyUrl() {
		String actual = driver.getTitle();
		String expected = "Reservations";
		Assert.assertEquals(actual, expected);
	}

//=============this is common method to handle mouse hover=======================================================================================================================

	public void mouseHover(WebElement ele, List<WebElement> ele2, String text1) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		List<WebElement> links = ele2;
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String text = element.getAttribute("innerHTML");

			if (text.equalsIgnoreCase(text1)) {
				element.click();
				break;
			}

		}
	}

//=============this is common method to handle Radio button===============================================================================================================

	public void selectradioButton(WebElement ele) {
		boolean status = ele.isSelected();
		if (status = true) {
			ele.click();
		}
	}
}
