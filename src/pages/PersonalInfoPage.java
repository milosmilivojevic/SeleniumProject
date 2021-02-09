package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {
	WebDriver driver;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement emailInputField;
	WebElement currentPasswordInputField;
	WebElement saveButton;

	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}
	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}
	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getCurrentPasswordInputField() {
		return driver.findElement(By.id("old_passwd"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}
	public void enterFirstName(String firstName) {
		this.getFirstNameInputField().clear();
		this.getFirstNameInputField().sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		this.getLastNameInputField().clear();
		this.getLastNameInputField().sendKeys(lastName);
	}
	public void enterEmail(String email) {
		this.getEmailInputField().clear();
		this.getEmailInputField().sendKeys(email);
	}
	public void enterCurrentPassword(String currentPassword) {
		this.getCurrentPasswordInputField().clear();
		this.getCurrentPasswordInputField().sendKeys(currentPassword);
	}
	public void clickSaveButton() {
		this.getSaveButton().click();
	}
}
