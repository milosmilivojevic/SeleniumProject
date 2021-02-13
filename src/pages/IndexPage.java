package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IndexPage {
	WebDriver driver;
	WebElement signInButton;
	WebElement product1Card;
	WebElement addToCartButton1;
	WebElement product2Card;
	WebElement addToCartButton2;
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
	public WebElement getAddToCartButton1() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
	}
	public WebElement getProduct2Card() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]"));
	}
	public WebElement getAddToCartButton2() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]"));
	}
	public WebElement getClosePopupButton() {
		return driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
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
	public void hoverOverProduct1() {
		Actions action = new Actions(driver);
		WebElement product1 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]"));
		action.moveToElement(product1).build().perform();
	}
	public void hoverOverProduct2() {
		Actions action = new Actions(driver);
		WebElement product2 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]"));
		action.moveToElement(product2).build().perform();
	}
	public void clickAddToCartButton1() {
		this.getAddToCartButton1().click();
	}
	public void clickAddToCartButton2() {
		this.getAddToCartButton2().click();
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
