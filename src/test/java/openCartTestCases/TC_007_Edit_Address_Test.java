package openCartTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClassXML;
import openCartPageObjects.Address_Book_Add_Page;
import openCartPageObjects.Address_Book_Edit_Page;
import openCartPageObjects.Home_Page;
import openCartPageObjects.Login_Page;
import openCartPageObjects.My_Account_Page;

public class TC_007_Edit_Address_Test extends BaseClassXML{
	
	@Test (groups={"Sanity","Master"})
	public void Edit_Address()
	{
		try {
			logger.info("** TC_007_Edit_Address_Test Started **");
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
	        
	        Address_Book_Add_Page abp = new Address_Book_Add_Page(driver);
            Assert.assertTrue(abp.AddressBookDisplayed());
	        
	        Address_Book_Edit_Page abep = new Address_Book_Edit_Page(driver);
	        abep.clickEditButton();
	        abep.setEditFirstName_Adr(prop.getProperty("FirstName2"));
	        abep.setEditlastName__Adr(prop.getProperty("LastName2"));
	        abep.setEditCmpnyName__Adr(prop.getProperty("companyName2"));
	        abep.setEditAdd1__Adr(prop.getProperty("Address11"));
	        abep.setEditAdd2__Adr(prop.getProperty("Address21"));
	        abep.setEditCity__Adr(prop.getProperty("CityName2"));
	        abep.setEditPinCode__Adr(prop.getProperty("Pincode2"));
	        abep.setEditCountry__Adr(prop.getProperty("CountryName2"));
	        abep.setEditRegionState__Adr(prop.getProperty("RegionStateName2"));
	        abep.clickEditContinue();
	        Assert.assertEquals(abep.getEditAddressAddMsg(), "Your address has been successfully updated");
	        Thread.sleep(2000);
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("** TC_007_Edit_Address_Test Finished **");
	}

}
