package openCartTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClassXML;
import openCartPageObjects.Address_Book_Add_Page;
import openCartPageObjects.Address_Book_Delete_Page;
import openCartPageObjects.Address_Book_Edit_Page;
import openCartPageObjects.Home_Page;
import openCartPageObjects.Login_Page;
import openCartPageObjects.My_Account_Page;

public class TC_008_Delete_Address_Test extends BaseClassXML{
	
	@Test (groups={"Sanity","Master"})
	public void Edit_Address()
	{
		try {
			logger.info("** TC_008_Delete_Address_Test Started **");
			Home_Page hp = new Home_Page(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			Login_Page lp = new Login_Page(driver);
			lp.setLoginEmail(prop.getProperty("userEmail"));
			lp.setLoginPwd(prop.getProperty("userPwd"));
			lp.clickLoginBtn();
			
			My_Account_Page map = new My_Account_Page(driver);
	        Assert.assertTrue(map.isMyAccountPageExists());
	        map.clickAddressBook();
	        
	        Address_Book_Add_Page abap = new Address_Book_Add_Page(driver);
	        
	        Assert.assertTrue(abap.AddressBookDisplayed()); 
	        
	        Address_Book_Delete_Page abd = new Address_Book_Delete_Page(driver);
	        abd.clickDeleteButton();
	    
	        Assert.assertEquals(abd.getDelAddressAddMsg(), "Your address has been successfully deleted");
	        Thread.sleep(2000);
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("** TC_008_Delete_Address_Test Finished **");
	}

}
