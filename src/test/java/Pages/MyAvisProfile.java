package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testcases.CommonClass;

public class MyAvisProfile extends CommonClass{

	public MyAvisProfile() throws Exception {
		super();
	
	}
	//WebDriverWait wait;

	@FindBy(xpath = "//ul[@id='nav-offcanvas']/li[5]/a")
	public WebElement carsservices;
	@FindBy(xpath= ".//*[@id='nav-offcanvas']/li[5]/ul/li") public List<WebElement> clickMyAvis;
	@FindBy(xpath="//ul[@class='dropdown-submenu auth-wizard']//a[text()='My Avis / Wizard']")
	public 
	WebElement clickMyAvisWizard;
	@FindBy(css="#wizardoption") public WebElement wizardNumberDropDown;
	@FindBy(css=".updateButton.floatright") WebElement clickContinue;
	@FindBy(css="#fullname") WebElement selecthonorific;
	@FindBy(xpath="//input[@id='profileForm.firstName']") WebElement firstName;
	@FindBy(xpath="//input[@id='profileForm.lastName']") WebElement lastName;
	@FindBy(xpath="//input[@id='profileForm.userName']") WebElement createUsername;
	@FindBy(xpath="//input[@id='profileForm.passwd']") WebElement password;	
	@FindBy(xpath="//input[@id='profileForm.reenterPasswd']") WebElement retypePassword;
	@FindBy(xpath="//select[@id='reminder']") WebElement passwordReminder;	
	@FindBy(xpath="//input[@id='profileForm.passwdReminderAnswer']") WebElement reminderAnswer;
	@FindBy(xpath="//select[@id='dateselect']") WebElement dobMonth;
	@FindBy(xpath="//select[@name='profileForm.dobDay']") WebElement dobDay;
	@FindBy(xpath="//select[@name='profileForm.dobYear']") WebElement dobYear;
	@FindBy(xpath="//input[@id='profileForm.addressLine1']") WebElement addressLine1;
	@FindBy(xpath="//input[@id='profileForm.city']") WebElement city;
	@FindBy(xpath="//select[@id='state']") WebElement state;
	@FindBy(xpath="//input[@id='profileForm.postalCode']") WebElement zipCode;  
	@FindBy(xpath="//input[@id='profileForm.emailAddress']") WebElement email;
	@FindBy(xpath="//input[@id='profileForm.reTypeEmailAddress']") WebElement retypeEmail;
	@FindBy(xpath="//div[contains(text(),'do not send me any email offers')]/input") WebElement communicationRadioButtion;
	@FindBy(xpath="//div[contains(text(),'I do not want electronic receipts')]/input") WebElement eReceiptRadioButtion;
	@FindBy(xpath="//input[@id='profileForm.telephone']") WebElement phoneNumber;
	@FindBy(xpath="//input[@id='smsOptRadio']	") WebElement textMessageNotifications;
	@FindBy(xpath="//select[@id='dlstate']") WebElement dl_state;
	@FindBy(xpath="//input[@id='profileForm.licenseNumber']") WebElement licenseNumber;
	@FindBy(xpath="//a[@title='Continue to Next Step']") WebElement clickContinueButton;
	@FindBy(xpath="//a[@id='enrollOrRegister']") WebElement clickRegisterNow;
	@FindBy(xpath="//div[@class='infohdrcnt fullWidth']/h3/label") WebElement postRegistrationText;
	@FindBy(xpath="//article[@class='yrinforental']/p[4]/strong/span") WebElement yourUserName;
	@FindBy(xpath="//article[@class='yrinforental']/p[5]/strong/span") WebElement yourWizardNumber;
	
	
	
	public void hoverOnCarServices(){
		
		mouseHover(carsservices, clickMyAvis, "My Avis / Wizard");
	}
	
	public void clickMyAvisWizard(){
		clickMyAvisWizard.click();
	}
	
	public void clickContinueButton(){
		clickContinue.click();
	}
	
	public void verifyPostRegistrationText(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		String actualText = postRegistrationText.getText();
		System.out.println("acutalText: " + actualText);
		String exceptedText = "THANK YOU FOR REGISTERING FOR MY AVIS";
		Assert.assertEquals(actualText, exceptedText, "actual and expected is not matching");
	}
	
	
	public void myAvisEnrollment(){
		
		selectFromDropDown("Mr", selecthonorific);
		firstName.sendKeys("Salman1");
		lastName.sendKeys("Khan1");
		createUsername.sendKeys("sk12345");
		password.sendKeys("V@live2010!!");
		retypePassword.sendKeys("V@live2010!!");
		selectFromDropDown("What is the name of your favorite pet?", passwordReminder);
		reminderAnswer.sendKeys("Lucky");
		selectFromDropDown("April", dobMonth);
		selectFromDropDown("13", dobDay);
		selectFromDropDown("1989", dobYear);
		addressLine1.sendKeys("address1");
		city.sendKeys("city");
		selectFromDropDown("Georgia", state);
		zipCode.sendKeys("30002");
		email.sendKeys("test@gmail.com");
		retypeEmail.sendKeys("test@gmail.com");
		selectradioButton(communicationRadioButtion);
		selectradioButton(eReceiptRadioButtion);
		phoneNumber.sendKeys("8622443583");
		selectradioButton(textMessageNotifications);
		selectFromDropDown("Georgia", dl_state);
		licenseNumber.sendKeys("DL12345");
		clickContinueButton.click();
		clickRegisterNow.click();
		verifyPostRegistrationText();
		System.out.println("UserName: " + yourUserName.getText());
		System.out.println("WizardNumber: " + yourWizardNumber.getText());
		
		
	}
	
	
}
