package openCartPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Page {
	
WebDriver driver;
WebDriverWait wait;	
	public Base_Page(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ElementToBeClickable(WebElement By)
	{
		wait.until(ExpectedConditions.elementToBeClickable(By));
	}
	
}
