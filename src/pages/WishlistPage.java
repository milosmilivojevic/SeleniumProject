package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage {
	WebDriver driver;
	WebElement nameInputField;
	WebElement saveButton;
	WebElement textForAssert;


	public WishlistPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getNameInputField() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public String textForAssert() {
		return String.valueOf(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[1]")).getText());

	}
	public void enterWishlistName(String wishlistName) {
		driver.findElement(By.id("name")).sendKeys(wishlistName);
	}
	public void clickSaveButton() {
		this.getSaveButton().click();
	}
	public void removeLists() {
		List<WebElement> removeListIcons = driver.findElements(By.className("icon-remove"));
		for (int i = 0; i < removeListIcons.size(); i++) {
			if (removeListIcons.size() > 0) {
				removeListIcons.get(i).click();
				driver.switchTo().alert().accept();
			}
		}
	}
	
}
