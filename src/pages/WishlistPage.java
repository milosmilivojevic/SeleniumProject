package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage {
	WebDriver driver;
	WebElement nameInputField;
	WebElement saveButton;

	public WishlistPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getNameInputField() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	public void enterWishlistName(String wishlistName) {
		driver.findElement(By.id("name")).sendKeys(wishlistName);
	}
	public void clickSaveButton() {
		this.getSaveButton().click();
	}
}
