package openCartPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Address_Book_Delete_Page extends Base_Page {

	public Address_Book_Delete_Page(WebDriver driver) {
		super(driver);
	}

	// Edit Address Locators

	@FindBy(xpath = "//p[text()='You have no addresses in your account.']")
	WebElement isAddressAvailable;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr")
	List<WebElement> tableCount;

	@FindBy(xpath = "//a[text()='Delete']")
	List<WebElement> btnDeleteAddress;

	@FindBy(css = ".alert-success")
	WebElement msgSuccessForDeleteAddress;

	
//Delete Address Actions

	public String isAddressAvailable() {
		try {
			return (isAddressAvailable.getText());
		} catch (Exception e) {

			return (e.getMessage());
		}
	}
	

	public void clickDeleteButton() {
		if (isAddressAvailable() !=null) {
			for (int i = 0; i < tableCount.size(); i++) {
				btnDeleteAddress.get(0).click();
			}
		}
	}

	
	public String getDelAddressAddMsg() {
		try {
			return msgSuccessForDeleteAddress.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
