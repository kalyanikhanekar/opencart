package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(groups= {"sanity","regression","smoke"},dataProvider="Logindata", dataProviderClass=DataProviders.class)//required due to this is in another class
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException {

		System.out.println("Enter Logindd");
		
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
				logger.info("***********************Clicked My Account*****************");
			hp.clickLoginLink();

			//Login Page
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLoginbtn();
				logger.info("***********************Clicked Login Button*****************");

			//	Assert.assertTrue(lp.checkLoginMsgDisaplayed());

			//My Account Page

			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExists();

				logger.info("***********************isMyAccountPageExists()*****************");



			if(exp.equalsIgnoreCase("valid")) {
				if(targetpage==true) {
					macc.clickLogout();
					Assert.assertTrue(true);

				}

			}

			if(exp.equalsIgnoreCase("invalid")) {

				if(targetpage==true) {
					macc.clickLogout();
					Assert.assertTrue(false);

				}

			}

			logger.info("***********************Finishe Login Test*****************");
		}


		//Assert.assertEquals(targetpage, true,"Test failed.....");
		


		catch(Exception e) 
		{
			Assert.fail();
			logger.info("***********************Login Test Failed*****************");
			System.out.print("exception "+e);

		}




	}
}

