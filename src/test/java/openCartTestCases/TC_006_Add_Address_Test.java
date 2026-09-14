package openCartTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClassXML;
import openCartPageObjects.Address_Book_Add_Page;
import openCartPageObjects.Home_Page;
import openCartPageObjects.Login_Page;
import openCartPageObjects.My_Account_Page;

public class TC_006_Add_Address_Test extends BaseClassXML{
	
	@Test (groups={"Sanity","Master"})
	public void Add_Address()
	{
		try {
			logger.info("** TC_006_Add_Address_Test Started **");
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
	        abap.clickNewAddess_Adr();
	        abap.setFirstName_Adr(prop.getProperty("FirstName"));
	        abap.setlastName__Adr(prop.getProperty("LastName"));
	        abap.setCmpnyName__Adr(prop.getProperty("companyName"));
	        abap.setAdd1__Adr(prop.getProperty("Address1"));
	        abap.setAdd2__Adr(prop.getProperty("Address2"));
	        abap.setCity__Adr(prop.getProperty("CityName"));
	        abap.setPinCode__Adr(prop.getProperty("Pincode"));
	        abap.setCountry__Adr(prop.getProperty("CountryName"));
	        abap.setRegionState__Adr(prop.getProperty("RegionStateName"));
	        abap.clickContinue();
	        Assert.assertEquals(abap.getAddAddressAddMsg(), "Your address has been successfully added");
		}
		catch (Exception e) {
			logger.error(e);
			Assert.fail();
		}
		logger.info("** TC_006_Add_Address_Test Finished **");
	}

}
