package openCartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Base_Page {

	public Home_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement linkmyAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement linkRegister;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement linkLogin;

	public void clickMyAccount() {
		linkmyAccount.click();
	}

	public void clickRegister() {
		linkRegister.click();
	}

	public void clickLogin() {
		linkLogin.click();
	}

}