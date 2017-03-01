package utility;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

public class BrowserFactory {

	static WebDriver driver;
	
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

}
