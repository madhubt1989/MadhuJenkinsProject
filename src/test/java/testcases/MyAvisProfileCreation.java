package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Pages.MyAvisProfile;

public class MyAvisProfileCreation extends CommonClass{
	
	//MyAvisProfile av;
	MyAvisProfile av;
	WebDriverWait wait;

	public MyAvisProfileCreation() throws Exception {
		super();
	}
	
	public void mouseHover(WebElement ele, List<WebElement> ele2, String text1){
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		List<WebElement> links=ele2;
		//System.out.println("Total no of values: " + links.size());
		for(int i=0;i<links.size();i++){
			WebElement element = links.get(i);
			//String text = links.get(i).getText();
		    String text = element.getAttribute("innerHTML");
			//String text = element.getText();
		   // System.out.println("List name: " + text);
		    
		    if(text.contains(text1)){
		    	element.click();
		    	break;
		    }
		    
		    }
	}
	
@Test(description="This TC verifies creation of My Avis Profile")
public void verifyMyAvisProfileCreatoin() {
	
	startBrowser();
	av = PageFactory.initElements(driver, MyAvisProfile.class);
	mouseHover(av.carsservices, av.clickMyAvis, "My Avis / Wizard");
	av.clickMyAvisWizard();
	av.selectFromDropDown("I do not have an Avis Wizard Number", av.wizardNumberDropDown);
	av.clickContinueButton();
	av.myAvisEnrollment();
	
}
	
}
