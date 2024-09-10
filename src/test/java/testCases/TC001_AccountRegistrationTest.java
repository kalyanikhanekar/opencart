package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegisterPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	

	
	
	@Test(groups= {"sanity"})
	public void verify_aacoutnt_registration() throws InterruptedException {
		try {
		logger.info("*************Strting registration test case*************");
		
		HomePage hp=new HomePage(driver);
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		
		
		hp.clickMyAccount();
		logger.info("*************Clicked account link*************");
		System.out.print("Account click");
		Thread.sleep(5000);
		hp.clickRegisterLink();
		System.out.print("Register link click");
		
		//String pass="kalyani12";
		
		
		
		logger.info("*************Clicked registraion link*************");
		AccountRegisterPage arp=new AccountRegisterPage(driver);
		mywait.until(ExpectedConditions.visibilityOfAllElements(arp.getregistrationpage()));// wait till account registration page open
		
		arp.setFirstname(getRrandomString());
		arp.setLasttname(getRrandomString());
		arp.setEmail(getRrandomString()+"@gmail.com");
		
		arp.setPassword(getRrandomString()+getRrandomNumber());
		
		arp.clickAgree();
		
			
		arp.clickContinue();
		
		
		
		
		String msg=arp.getConfirmationMsg();
		
		Assert.assertEquals(msg,"Register Account");
		
		
		
		}catch(Exception e) {
			logger.error("Test Failed");
			//logger.debug("Debug logs...");
			Assert.fail();
		}
		logger.info("*************Finished*************");
	}
		
	
}
