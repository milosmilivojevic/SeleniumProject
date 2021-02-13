package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addressLabel;
	WebElement secondAddressLabel;
	WebElement deleteSecondAddressButton;
	WebElement addANewAddressButton;

	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//a[@title=\"Update\"]"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//a[@title=\"Delete\"]"));
	}

	public WebElement getAddressLabel() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div/ul/li[1]/h3"));
	}

	public WebElement getSecondAddressLabel() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div[2]/ul/li[1]/h3"));
	}

	public WebElement getDeleteSecondAddressButton() {
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li[9]/a[2]"));
	}

	public WebElement getAddANewAddressButton() {
		return driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
	}

	public void clickUpdateButton() {
		this.getUpdateButton().click();
	}

	public void deleteAddress() throws InterruptedException {
		this.getDeleteButton().click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}

	public void deleteSecondAddress() throws InterruptedException {
		if (this.getDeleteSecondAddressButton().isDisplayed()) {
			this.getDeleteSecondAddressButton().click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		}
	}
	public int numberOfAddresses() {
		List<WebElement> numberOfAddresses = driver.findElements(By.className("page-subheading")); 
		return numberOfAddresses.size();
	}
	public void clickAddANewAddressButton() {
		this.getAddANewAddressButton().click();
	}

}
