package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IndexPage {
	WebDriver driver;
	WebElement signInButton;
	WebElement product1Card;
	WebElement product2Card;
	WebElement product3Card;
	WebElement addToCartButton1;
	WebElement addToCartButton2;
	WebElement addToCartButton3;
	WebElement closePopupButton;
	WebElement proceedToCheckoutButton;
	WebElement shoppingCartIcon;
	

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	public WebElement getProduct1Card() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]"));
	}
	public WebElement getProduct2Card() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]"));
	}
	public WebElement getProduct3Card() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]"));
	}
	public WebElement getAddToCartButton1() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
	}
	public WebElement getAddToCartButton2() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]"));
	}
	public WebElement getAddToCartButton3() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]"));
	}
	public WebElement getClosePopupButton() {
		return driver.findElement(By.xpath("//*[@class=\"cross\"]"));
	}
	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]"));
	}
	public WebElement getShoppingCartIcon() {
		return driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]"));
	}
	
	
	public void clickSignInButton() {
		this.getSignInButton().click();
	}
	public void hoverOverProduct(WebElement productCard) {
		Actions action = new Actions(driver);
		action.moveToElement(productCard).build().perform();
	}
	public void clickAddToCartButton(WebElement button) {
		button.click();
	}
	public void closePopup() {
		this.getClosePopupButton().click();
	}
	public void clickProceedToCheckoutButton() {
		this.getProceedToCheckoutButton().click();
	}
	public void clickShoppingCartIcon() {
		this.getShoppingCartIcon().click();
	}
}
