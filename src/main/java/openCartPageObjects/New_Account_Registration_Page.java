package openCartPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class New_Account_Registration_Page extends Base_Page {

	public New_Account_Registration_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#input-firstname")
	WebElement txtFirstName;

	@FindBy(id = "input-lastname")
	WebElement txtLastName;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(css = "#input-telephone")
	WebElement txtTelephone;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;

	@FindBy(name = "agree")
	WebElement chkPolicy;

	@FindBy(className = "btn-primary")
	WebElement btnContiue;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfimation;

	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}

	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}

	public void setEmail(String emailID) {
		txtEmail.sendKeys(emailID);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void setPolicy() {
		chkPolicy.click();
	}

	public void clickContinue() {
		btnContiue.click();
	}

	public String getConfirmationMsg() {
		try {
			return msgConfimation.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
