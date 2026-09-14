package openCartTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClassGrid;
import BaseTest.BaseClassXML;
import openCartPageObjects.Home_Page;
import openCartPageObjects.Login_Page;
import openCartPageObjects.My_Account_Info_Page;
import openCartPageObjects.My_Account_Page;
import openCartPageObjects.Password_Page;

public class TC_005_ChangeAccountPassword_Test extends BaseClassXML{
	
	@Test (groups={"Sanity","Master"})
	public void ChangeAccountPassword()
	{
		try {
			logger.info("** TC_005_ChangeAccountPassword_Test Started **");
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
	        map.clickChngPwd();
	        
	        Password_Page pp = new Password_Page(driver);
	        Assert.assertTrue(pp.isLabelPwdDisplayed());
	        pp.setUpdatePassword(prop.getProperty("userPwd"));
	        pp.setConfirmUpdatePassword(prop.getProperty("userPwd"));
	        pp.clickContinueOnChngPwd();
	        Assert.assertEquals(pp.getUpdatePasswordMsg(), "Success: Your password has been successfully updated.");
	}
		catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("debugging");
			Assert.fail();
		}
		logger.info("** TC_005_ChangeAccountPassword_Test Finished**");
	}		
}
