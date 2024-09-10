package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass  {



	@Test(groups= {"sanity","regression"})
	public void verify_login()  {




		try
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			//Home Page
			logger.info("***********************Login Test started*****************");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***********************Clicked My Account*****************");
			hp.clickLoginLink();

			//Login Page
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));

			wait.until(ExpectedConditions.elementToBeClickable(lp.ElementLoginbtn()));

			lp.clickLoginbtn();
			logger.info("***********************Clicked Login Button*****************");

			//	Assert.assertTrue(lp.checkLoginMsgDisaplayed());

			//My Account Page

			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExists();


			Assert.assertEquals(targetpage, true,"Test failed.....");
			logger.info("***********************Finishe Login Test*****************");




		}
		catch(Exception e) 
		{
			Assert.fail();
			logger.info("***********************Login Test Failed*****************");

		}



	}
}


