package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement signOutButton;
	WebElement myAddressesButton;
	WebElement myPersonalInformationButton;
	WebElement myWishlistButton;

	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
	
	public WebElement getMyAddressesButton() {
		return driver.findElement(By.className("icon-building"));
		
	}
	public WebElement getMyPersonalInformationButton() {
		return driver.findElement(By.className("icon-user"));
	}
	public WebElement getMyWishlistButton() {
		return driver.findElement(By.className("icon-heart"));
	}
	public void clickMyAddressesButton() {
		this.getMyAddressesButton().click();
	}
	public void clickMyPersonalInformationButton() {
		this.getMyPersonalInformationButton().click();
	}
	public void clicMyWishlistButton() {
		this.getMyWishlistButton().click();
	}
	public void clickSignOutButton() {
		this.getSignOutButton().click();
	}
}
