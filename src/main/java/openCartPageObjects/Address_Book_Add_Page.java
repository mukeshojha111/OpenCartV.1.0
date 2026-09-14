package openCartPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Address_Book_Add_Page extends Base_Page {

	public Address_Book_Add_Page(WebDriver driver) {
		super(driver);
	}

	// Add Address Locators
	@FindBy(xpath = "//h2[text()='Address Book Entries']")
	WebElement HeaderAddressBookEntries;

	@FindBy(xpath = "//p[text()='You have no addresses in your account.']")
	WebElement isAddressAvailable;

	@FindBy(xpath = "//a[text()='New Address']")
	WebElement btnNewAddress;

	@FindBy(css = "#input-firstname")
	WebElement txtFirstName;

	@FindBy(id = "input-lastname")
	WebElement txtLastName;

	@FindBy(id = "input-company")
	WebElement txtCompanyName;

	@FindBy(id = "input-address-1")
	WebElement txtAdd1;

	@FindBy(id = "input-address-2")
	WebElement txtAdd2;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(id = "input-postcode")
	WebElement txtPostalCode;

	@FindBy(xpath = "//select[@id='input-country']")
	WebElement countryDrowdown;

	@FindBy(xpath = "//select[@id='input-zone']")
	WebElement regionStateDropdown;

	@FindBy(css = ".btn-primary")
	WebElement btnAddAddressContiue;

	@FindBy(css = ".alert-success")
	WebElement msgSuccessForAddAddress;

	// Edit Address Locators
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr")
	List<WebElement> tableCount;

	@FindBy(xpath = "//a[text()='Edit']")
	List<WebElement> btnEditAddress;

	@FindBy(xpath = "//h2[text()='Edit Address']")
	WebElement HeaderEditAddress;

	@FindBy(css = ".alert-success")
	WebElement msgSuccessForEditAddress;

	public boolean AddressBookDisplayed() {
		try {
			return HeaderAddressBookEntries.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickNewAddess_Adr() {
		btnNewAddress.click();
	}

	public void setFirstName_Adr(String fName) {
		txtFirstName.click();
		txtFirstName.sendKeys(fName);
	}

	public void setlastName__Adr(String lName) {
		txtLastName.click();
		txtLastName.sendKeys(lName);
	}

	public void setCmpnyName__Adr(String compName) {
		txtCompanyName.click();
		txtCompanyName.sendKeys(compName);
	}

	public void setAdd1__Adr(String address1) {
		txtAdd1.click();
		txtAdd1.sendKeys(address1);
	}

	public void setAdd2__Adr(String address2) {
		txtAdd2.click();
		txtAdd2.sendKeys(address2);
	}

	public void setCity__Adr(String cityName) {
		txtCity.click();
		txtCity.sendKeys(cityName);
	}

	public void setPinCode__Adr(String pincode) {
		txtPostalCode.click();
		txtPostalCode.sendKeys(pincode);
	}

	public void setCountry__Adr(String countryName) {
		Select select = new Select(countryDrowdown);
		select.selectByVisibleText(countryName);
	}

	public void setRegionState__Adr(String regionStateName) {
		Select select = new Select(regionStateDropdown);
		select.selectByVisibleText(regionStateName);
	}

	public void clickContinue() {

		btnAddAddressContiue.click();
	}

	public String getAddAddressAddMsg() {
		try {
			return msgSuccessForAddAddress.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

//Edit Address Actions

	public String isAddressAvailable() {
		try {
			return (isAddressAvailable.getText());
		} catch (Exception e) {

			return (e.getMessage());
		}
	}

	public void clickEditButton() {
		if (isAddressAvailable().equalsIgnoreCase("You have no addresses in your account.")) {
			System.out.println("Enter atleast one address to edit");
		} else {
			for (int i = 0; i < tableCount.size(); i++) {
				btnEditAddress.get(0).click();
			}
		}
	}

	public boolean EditAddress() {
		try {
			return HeaderEditAddress.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getEditAddressAddMsg() {
		try {
			return msgSuccessForAddAddress.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
