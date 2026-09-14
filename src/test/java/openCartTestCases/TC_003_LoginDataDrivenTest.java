package openCartTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import BaseTest.BaseClassGrid;
import BaseTest.BaseClassXML;
import openCartPageObjects.Home_Page;
import openCartPageObjects.Login_Page;
import openCartPageObjects.My_Account_Page;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClassXML{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_Login_TDD(String email, String pwd, String exp) throws InterruptedException
	{
		try {
			logger.info("** TC_003_Login_TDD Started **");
			Home_Page hp = new Home_Page(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			Login_Page lp = new Login_Page(driver);
			lp.setLoginEmail(email);
			lp.setLoginPwd(pwd);
			lp.clickLoginBtn();
			
			My_Account_Page map = new My_Account_Page(driver);
		    Assert.assertTrue(map.isMyAccountPageExists());
		    
		    if(exp.equalsIgnoreCase("Valid"))
		    {
		    	   if(map.isMyAccountPageExists()==true)
		    	   {
		    		   map.clickLogout();
		    		   Assert.assertTrue(true);
		    		   
		    	   }
		    	   else
		    	   {
		    		   Assert.assertTrue(false);
		    	   }
		    }
		    
		    if(exp.equalsIgnoreCase("Invalid"))
		    {
		    	   if(map.isMyAccountPageExists()==true)
		    	   {
		    		   map.clickLogout();
		    		   Assert.assertTrue(false);
		    		   
		    	   }
		    	   else
		    	   {
		    		   Assert.assertTrue(true);
		    	   }
		    }
		} catch (Exception e) {
			
			Assert.fail();
		}
	    
	    logger.info("** TC_003_Login_TDD Finished**");
	}
	

}
