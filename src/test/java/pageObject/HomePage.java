package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	

	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Constructor
	
	public HomePage(WebDriver driver) {
		super(driver);
	
	}
	
	
	//Locator
	@FindBy(xpath="//span[text()='My Account']") WebElement my_account;
	@FindBy(xpath="//span[text()='My Account']/parent::a/following-sibling::ul/li[1]/a") WebElement register;
	@FindBy(xpath="//span[text()='My Account']/parent::a/following-sibling::ul/li[2]/a") WebElement login;
	
	
	
	
	//Action methods
	
	public void clickMyAccount() throws InterruptedException {
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(my_account));
		JavascriptExecutor js=(JavascriptExecutor)driver;

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", my_account);
		
		System.out.print("Account in home page");
		Thread.sleep(3000);
		//my_account.click();
	}
	
	
	public void clickRegisterLink() {
		
		
		js.executeScript("arguments[0].click();", register);
	//	register.click();
		
	}
	
	public void clickLoginLink() {
		js.executeScript("arguments[0].click();", login);
	}

}
