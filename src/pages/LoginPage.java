package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement emailInputField;
	WebElement passwordInputField;
	WebElement signInButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	public void enterEmail(String email) {
		this.getEmailInputField().sendKeys(email);
	}
	public void enterPassword(String password) {
		this.getPasswordInputField().sendKeys(password);
	}
	public void clickSignInButton() {
		this.getSignInButton().click();
	}
}
