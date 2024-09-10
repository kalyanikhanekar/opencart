package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']") WebElement loginverify_msg;
	@FindBy(xpath="//div/a[text()='Logout']") WebElement btnlogout;


	public boolean isMyAccountPageExists() {


		try {
			return (loginverify_msg.isDisplayed());


		}catch(Exception e) {
			return false;
		}

	}
	
	public void clickLogout() {
		btnlogout.click();
		
	}
}
