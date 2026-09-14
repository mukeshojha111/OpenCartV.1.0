package openCartTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import BaseTest.BaseClassGrid;
import BaseTest.BaseClassXML;
import openCartPageObjects.Home_Page;
import openCartPageObjects.Login_Page;
import openCartPageObjects.My_Account_Page;

public class TC_002_LoginTest extends BaseClassXML{
	
	@Test 
	public void verify_Login() throws InterruptedException
	{
		
		try {
			logger.info("** TC_002_LoginTest Started **");
			Home_Page hp = new Home_Page(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			Login_Page lp = new Login_Page(driver);
			lp.setLoginEmail(prop.getProperty("userEmail"));
			lp.setLoginPwd(prop.getProperty("userPwd"));
			lp.clickLoginBtn();
			
			My_Account_Page map = new My_Account_Page(driver);
	        Assert.assertTrue(map.isMyAccountPageExists());
	        Thread.sleep(1000);
	        map.clickLogout();
		} catch (Exception e) {
			logger.error(e);
			Assert.fail();
		}
		logger.info("** TC_002_LoginTest Finished**");
	}

}
