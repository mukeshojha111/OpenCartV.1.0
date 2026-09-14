package openCartPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Address_Book_Edit_Page extends Base_Page {

	public Address_Book_Edit_Page(WebDriver driver) {
		super(driver);
	}

	// Edit Address Locators

	@FindBy(xpath = "//p[text()='You have no addresses in your account.']")
	WebElement isAddressAvailable;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr")
	List<WebElement> tableCount;

	@FindBy(xpath = "//a[text()='Edit']")
	List<WebElement> btnEditAddress;

	@FindBy(xpath = "//h2[text()='Edit Address']")
	WebElement HeaderEditAddress;
	

	@FindBy(css = "#input-firstname")
	WebElement txtEditFirstName;

	@FindBy(id = "input-lastname")
	WebElement txtEditLastName;

	@FindBy(id = "input-company")
	WebElement txtEditCompanyName;

	@FindBy(id = "input-address-1")
	WebElement txtEditAdd1;

	@FindBy(id = "input-address-2")
	WebElement txtEditAdd2;

	@FindBy(name = "city")
	WebElement txtEditCity;

	@FindBy(id = "input-postcode")
	WebElement txtEditPostalCode;

	@FindBy(xpath = "//select[@id='input-country']")
	WebElement EditCountryDrowdown;

	@FindBy(xpath = "//select[@id='input-zone']")
	WebElement EditRegionStateDropdown;

	@FindBy(css = ".btn-primary")
	WebElement btnEditAddressContiue;

	@FindBy(css = ".alert-success")
	WebElement msgSuccessForEditAddress;

	
//Edit Address Actions

	public String isAddressAvailable() {
		try {
			return (isAddressAvailable.getText());
		} catch (Exception e) {

			return (e.getMessage());
		}
	}

	public void clickEditButton() {
		if (isAddressAvailable() !=null) {
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


	public void setEditFirstName_Adr(String fName) {
		//txtEditFirstName.click();
		txtEditFirstName.clear();
		txtEditFirstName.sendKeys(fName);
	}

	public void setEditlastName__Adr(String lName) {
		//txtEditLastName.click();
		txtEditLastName.clear();
		txtEditLastName.sendKeys(lName);
	}

	public void setEditCmpnyName__Adr(String compName) {
		//txtEditCompanyName.click();
		txtEditCompanyName.clear();
		txtEditCompanyName.sendKeys(compName);
	}

	public void setEditAdd1__Adr(String address1) {
		//txtEditAdd1.click();
		txtEditAdd1.clear();
		txtEditAdd1.sendKeys(address1);
	}

	public void setEditAdd2__Adr(String address2) {
		//txtEditAdd2.click();
		txtEditAdd2.clear();
		txtEditAdd2.sendKeys(address2);
	}

	public void setEditCity__Adr(String cityName) {
		txtEditCity.click();
		txtEditCity.clear();
		txtEditCity.sendKeys(cityName);
	}

	public void setEditPinCode__Adr(String pincode) {
	//	txtEditPostalCode.click();
		txtEditPostalCode.clear();
		txtEditPostalCode.sendKeys(pincode);
	}

	public void setEditCountry__Adr(String countryName) {
		Select select = new Select(EditCountryDrowdown);
		select.selectByVisibleText(countryName);
	}

	public void setEditRegionState__Adr(String regionStateName) {
		Select select = new Select(EditRegionStateDropdown);
		select.selectByVisibleText(regionStateName);
	}

	public void clickEditContinue() {

		btnEditAddressContiue.click();
	}
	
	public String getEditAddressAddMsg() {
		try {
			return msgSuccessForEditAddress.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
