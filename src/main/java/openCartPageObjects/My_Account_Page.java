package openCartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_Account_Page extends Base_Page{

	public My_Account_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy (xpath="//aside[@id='column-right']//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy (xpath="//aside[@id='column-right']//a[text()='Edit Account']")
	WebElement lnkEditAccount;
	
	@FindBy (xpath = "//aside[@id='column-right']//a[text()='Password']")
	WebElement lnkPassword;
	
	@FindBy (xpath = "//aside[@id='column-right']//a[text()='Address Book']")
	WebElement lnkAddressBook;
	
	public boolean isMyAccountPageExists()
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public void clickEditInfo()
	{
	   lnkEditAccount.click();
	}
	
	public void clickChngPwd()
	{
		lnkPassword.click();
	}
	
	public void clickAddressBook()
	{
		lnkAddressBook.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

	
	
}
