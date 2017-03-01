package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	WebDriver driver;
	@Parameters({"app.browser", "app.url"})
	@Test
	public void testBrowser(String browser,String url){
		
		if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Madhu Backup\\Edureka\\Jars\\chromedriver_win32\\chromedriver_win32_2.25\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.get(url);
		driver.quit();
	}
}
