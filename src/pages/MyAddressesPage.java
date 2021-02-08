package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addANewAddressButton;
	
	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//a[@title=\"Update\"]"));
	}
	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//a[@title=\"Delete\"]"));
	}
	public WebElement getAddANewAddressButton() {
		return driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
	}
	public void clickUpdateButton() {
		this.getUpdateButton().click();
	}
	public void clickDeleteButton() {
		this.getDeleteButton().click();
	}
	public void clickAddANewAddressButton() {
		this.getAddANewAddressButton().click();
	}
	
}
