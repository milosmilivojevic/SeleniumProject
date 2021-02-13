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
		return String.valueOf(driver.findElement(By.xpath("//tr[starts-with(@id ,'wishlist')]//td[1]//a[1]")).getText());
	}
	
	public void enterWishlistName(String wishlistName) {
		driver.findElement(By.id("name")).sendKeys(wishlistName);
	}
	public void clickSaveButton() {
		this.getSaveButton().click();
	}
	public void removeLists() throws InterruptedException {
		List<WebElement> removeListIcons = driver.findElements(By.className("icon-remove"));
		for (int i = 0; i < removeListIcons.size(); i++) {
			if (removeListIcons.size() > 0) {
				removeListIcons.get(i).click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			}
		}
	}
	public int numberOfWishlists() {
		List<WebElement> wishlists = driver.findElements(By.xpath("//tr[starts-with(@id ,'wishlist')]"));
		return wishlists.size();
	}
}
