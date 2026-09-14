package openCartTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClassGrid;
import BaseTest.BaseClassXML;
import openCartPageObjects.Home_Page;
import openCartPageObjects.Login_Page;
import openCartPageObjects.My_Account_Info_Page;
import openCartPageObjects.My_Account_Page;

public class TC_004_EditMyAccount_Test extends BaseClassXML{
	
	@Test (groups={"Sanity","Master"})
	public void EditMyAccount()
	{
		try {
			logger.info("** TC_004_EditMyAccount_Test Started **");
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
	        map.clickEditInfo();
	        
	        My_Account_Info_Page maip = new My_Account_Info_Page(driver);
	        Assert.assertTrue(maip.personalDetailsDisplayed());
	        
	        maip.setFirstNameInfo(prop.getProperty("FirstName"));
	        maip.setLastNameInfo(prop.getProperty("LastName"));
	        maip.setEmailInfo(prop.getProperty("userEmail"));
	        maip.setTelInfo(prop.getProperty("Telephone"));
	        maip.clickContinueInfo();
	        Assert.assertEquals(maip.getAccountUpdateMsg(), "Success: Your account has been successfully updated.");
	}
		catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("debugging");
			Assert.fail();
		}
		logger.info("** TC_004_EditMyAccount_Test Finished **");
	}		
}
