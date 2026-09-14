package openCartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_Account_Info_Page extends Base_Page{

	public My_Account_Info_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//legend[text()='Your Personal Details']")
	WebElement msgPersonalDetails;
	
	@FindBy (id="input-firstname")
	WebElement txtfName;
	
	@FindBy (id="input-lastname")
	WebElement txtlName;
	
	@FindBy (id="input-email")
	WebElement txtEmailId;
	
	@FindBy (id="input-telephone")
	WebElement txtTeleNo;
	
	@FindBy (css=".btn-primary")
	WebElement btnInfoContiue;
	
	@FindBy (css=".alert-success")
	WebElement msgSuccessForAccountUpdate;

	
	public boolean personalDetailsDisplayed()
	{
		try {
			return msgPersonalDetails.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void setFirstNameInfo(String fNameInfo)
	{
		txtfName.clear();
		txtfName.sendKeys(fNameInfo);
	}
	
	public void setLastNameInfo(String lNameInfo)
	{
		txtlName.clear();
		txtlName.sendKeys(lNameInfo);
	}
	
	public void setEmailInfo(String EmailInfo)
	{
		txtEmailId.clear();
		txtEmailId.sendKeys(EmailInfo);
	}
	
	public void setTelInfo(String TelInfo)
	{
		txtTeleNo.clear();
		txtTeleNo.sendKeys(TelInfo);
	}
	
	public void clickContinueInfo()
	{
		btnInfoContiue.click();
	}
	
	public String getAccountUpdateMsg()
	{
		try {
			return msgSuccessForAccountUpdate.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
