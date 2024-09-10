package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{

	public AccountRegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	//Locator

	@FindBy(xpath="//input[@name='firstname']") WebElement txtfiratname;

	@FindBy(xpath="//input[@name='lastname']") WebElement txtlastname;

	@FindBy(xpath="//input[@name='email']") WebElement txtemail;

	@FindBy(xpath="//input[@name='password']") WebElement txtpassword;


	@FindBy(xpath="//input[@name='agree']") WebElement chkagree;

	@FindBy(xpath="//button[@type='submit']") WebElement btncountinue;

	@FindBy(xpath="//div[@id='content']/h1") WebElement msgconfirm;
	
	@FindBy(xpath="//h1[normalize-space()='Register Account']") WebElement registrationpage;

	//Action Methods


	public void setFirstname(String fname) {

		txtfiratname.sendKeys(fname);

	}

	public void setLasttname(String lname) {

		txtlastname.sendKeys(lname);

	}

	public void setEmail(String email) {

		txtemail.sendKeys(email);

	}

	public void setPassword(String password) {

		txtpassword.sendKeys(password);

	}

	public void clickAgree() {
		
		chkagree.click();

	}

	public void clickContinue() {
		
		btncountinue.click();

	}
	
	public String getConfirmationMsg() {
		return msgconfirm.getText();
		
	}
	
	public WebElement getregistrationpage() {
		return registrationpage;
		
	}

}
