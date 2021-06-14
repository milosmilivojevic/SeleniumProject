package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WebElement plusButton;
	WebElement quantity;
	WebElement emptyCartMessage;
	WebElement productsQuantityLabel;
	WebElement product1Name;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getPlusButton() {
		return driver.findElement(By.className("icon-plus"));
	}
	public WebElement getQuantity() { return driver.findElement(By.xpath("//input[contains(@class,'cart_quantity_input')]")); }
	public WebElement getEmptyCartMessage() {
		return driver.findElement(By.className("alert-warning"));
	}
	public WebElement getProductsQuantityLabel() {
		return driver.findElement(By.id("summary_products_quantity"));
	}
	public WebElement getProduct1Name() { return driver.findElement(By.xpath("(//*[@class='product-name']/a)[1]")); }


	public void clickPlusButton() {
		this.getPlusButton().click();
	}
	public void emptyCart() throws InterruptedException {
		List<WebElement> deleteIcons = driver.findElements(By.className("icon-trash"));
		for (int i = 0; i < deleteIcons.size(); i++) {
			if (deleteIcons.size() > 0) {
				deleteIcons.get(i).click();
				Thread.sleep(2000);
			}
		}
	}
}
