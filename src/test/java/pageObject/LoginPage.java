package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	// Locator
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']") WebElement btnLogin;

	
	
	
	//Action Methods
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
		
		public void clickLoginbtn() {
			
			btnLogin.click();
			
		}
		
		
public WebElement ElementLoginbtn() {
			
			
			return btnLogin;
			
		}
		
		
		
	}
	

