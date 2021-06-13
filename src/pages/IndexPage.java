package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 60);
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
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("login")));
		return element;
	}
	public WebElement getProduct1Card() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"homefeatured\"]/li[1]")));
		return element;
	}
	public WebElement getProduct2Card() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"homefeatured\"]/li[2]")));
		return element;
	}
	public WebElement getProduct3Card() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"homefeatured\"]/li[3]")));
		return element;
	}
	public WebElement getAddToCartButton1() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"homefeatured\"]//*[text()=\"Add to cart\"])[1]")));
		return element;
	}
	public WebElement getAddToCartButton2() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"homefeatured\"]//*[text()=\"Add to cart\"])[2]")));
		return element;
	}
	public WebElement getAddToCartButton3() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"homefeatured\"]//*[text()=\"Add to cart\"])[3]")));
		return element;
	}
	public WebElement getClosePopupButton() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"cross\"]")));
		return element;
	}
	public WebElement getProceedToCheckoutButton() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=\"Proceed to checkout\"]")));
		return element;
	}
	public WebElement getShoppingCartIcon() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=\"View my shopping cart\"]")));
		return element;
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
