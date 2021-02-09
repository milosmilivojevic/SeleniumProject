package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {
	WebDriver driver;
	WebElement signInButton;
	

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}

	public void clickSignInButton() {
		this.getSignInButton().click();
	}

}
