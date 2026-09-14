package openCartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Password_Page extends Base_Page{

	public Password_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//legend[text()='Your Password']")
	WebElement labelYourPwd;
	
	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(className = "btn-primary")
	WebElement btnContiue;

	@FindBy (css=".alert-success")
	WebElement msgSuccessForPwdUpdate; //Success: Your password has been successfully updated.
	
	
	public boolean isLabelPwdDisplayed()
	{
		try {
			return (labelYourPwd.isDisplayed());
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public void setUpdatePassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmUpdatePassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void clickContinueOnChngPwd()
	{
		btnContiue.click();
	}
	
	public String getUpdatePasswordMsg()
	{
		try {
			return msgSuccessForPwdUpdate.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
}
