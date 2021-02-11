package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {
	WebDriver driver;
	WebElement mrRadioButton;
	WebElement mrsRadioButton;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement emailInputField;
	WebElement currentPasswordInputField;
	WebElement newPasswordInputField;
	WebElement newsletterCheckbox;
	WebElement saveButton;
	WebElement confirmationMessage;
	WebElement backToAccountButton;

	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getMrRadioButton() {
		return driver.findElement(By.id("id_gender1"));
	}
	public WebElement getMrsRadioButton() {
		return driver.findElement(By.id("id_gender2"));
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
	public WebElement getNewPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}
	public WebElement getConfirmationMessage() {
		return driver.findElement(By.className("alert-success"));
	}
	public WebElement getBackToAccountButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a"));
	}


	public void clickMrRadioButton() {
		this.getMrRadioButton().click();
	}
	public void clickMrsRadioButton() {
		this.getMrsRadioButton().click();
	}
	public WebElement getNewsletterCheckbox() {
		return driver.findElement(By.id("newsletter"));
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
	public void enterNewPassword(String newPassword) {
		this.getNewPasswordInputField().clear();
		this.getNewPasswordInputField().sendKeys(newPassword);
	}
	public void checkNewsletterBox() {
		this.getNewsletterCheckbox().click();
	}
	public void clickSaveButton() {
		this.getSaveButton().click();
	}
	public void clickBackToAccountButton() {
		this.getBackToAccountButton().click();
	}
}
