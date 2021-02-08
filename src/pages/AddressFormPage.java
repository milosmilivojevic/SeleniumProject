package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressFormPage {
	WebDriver driver;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement addressInputField;
	WebElement cityInputField;
	WebElement postalCodeInputField;
	WebElement saveButton;

	public AddressFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getPostalCodeInputField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	public void enterFirstName(String firstName) {
		this.getFirstNameInputField().clear();
		this.getFirstNameInputField().sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		this.getLastNameInputField().clear();
		this.getLastNameInputField().sendKeys(lastName);
	}
	public void enterAddress(String address) {
		this.getAddressInputField().clear();
		this.getAddressInputField().sendKeys(address);
	}
	public void enterCity(String city) {
		this.getCityInputField().clear();
		this.getCityInputField().sendKeys(city);
	}
	public void enterPostalCode(String postalCode) {
		this.getPostalCodeInputField().clear();
		this.getPostalCodeInputField().sendKeys(postalCode);
	}
	public void clickSaveButton() {
		this.getSaveButton().click();
	}
}
