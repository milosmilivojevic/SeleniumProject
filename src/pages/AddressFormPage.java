package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressFormPage {
	WebDriver driver;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement addressInputField;
	WebElement cityInputField;
	WebElement postalCodeInputField;
	WebElement mobilePhoneInputField;
	WebElement addressTitle;
	WebElement saveButton;
	Select stateDropdownMenu = new Select(driver.findElement(By.id("id_state")));

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
	public WebElement getMobilePhoneInputField() {
		return driver.findElement(By.id("phone_mobile"));
	}
	
	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
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
	public void selectState(String state) {
		stateDropdownMenu.selectByVisibleText(state);
	}
	public void enterCity(String city) {
		this.getCityInputField().clear();
		this.getCityInputField().sendKeys(city);
	}
	public void enterPostalCode(String postalCode) {
		this.getPostalCodeInputField().clear();
		this.getPostalCodeInputField().sendKeys(postalCode);
	}
	public void enterMobilePhoneNumber(String mobilePhoneNumber) {
		this.getPostalCodeInputField().clear();
		this.getPostalCodeInputField().sendKeys(mobilePhoneNumber);
	}
	public void enterAddressTitle(String addressTitle) {
		this.getAddressTitle().clear();
		this.getAddressTitle().sendKeys(addressTitle);
	}
	public void clickSaveButton() {
		this.getSaveButton().click();
	}
}
