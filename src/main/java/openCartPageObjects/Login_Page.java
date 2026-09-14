package openCartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Base_Page{
	
	public Login_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "#input-email")
	WebElement txtEmailAddress;
	
	@FindBy(id = "input-password")
	WebElement txtLoginPwd;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnLogin;
	
	public void setLoginEmail(String userEmail)
	{
		txtEmailAddress.sendKeys(userEmail);
	}
	
	public void setLoginPwd(String userPwd)
	{
		txtLoginPwd.sendKeys(userPwd);
	}
	
	public void clickLoginBtn()
	{
		btnLogin.click();
	}
	
	
}
