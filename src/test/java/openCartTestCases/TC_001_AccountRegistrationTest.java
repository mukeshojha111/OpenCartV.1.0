package openCartTestCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import BaseTest.BaseClassGrid;
import BaseTest.BaseClassXML;
import openCartPageObjects.New_Account_Registration_Page;
import openCartPageObjects.Home_Page;

public class TC_001_AccountRegistrationTest extends BaseClassXML {

	@Test
	public void verify_account_registration() {

		try {
			logger.info("*** TC_001_AccountRegistration Started ***");
			Home_Page hp = new Home_Page(driver);
			New_Account_Registration_Page regPage = new New_Account_Registration_Page(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account..");
			hp.clickRegister();
			logger.info("Clicked on Registation..");
			regPage.setFirstName(randomString().toUpperCase());
			logger.info("Added first Name");
			regPage.setLastName(randomString().toUpperCase());
			logger.info("Added last Name");
			regPage.setEmail(randomString() + "@test.com");
			logger.info("Added Email");
			regPage.setTelephone(randomNumber());
			logger.info("Added Telephone");
			String password = randomPassword();
			regPage.setPassword(password);
			logger.info("Added password");
			regPage.setConfirmPassword(password);
			logger.info("Added confirmed password");
			regPage.setPolicy();
			logger.info("Agreed on Policy");
			regPage.clickContinue();
			logger.info("Clicked on contine button");
			Assert.assertEquals(regPage.getConfirmationMsg(), "Your Account Has Been Created!");

		} catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("debugging");
			Assert.fail();
		}

		logger.info("*** TC_001_AccountRegistration Finished ***");
	}

}
