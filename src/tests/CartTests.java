package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends TestBase{
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test (priority = 0)
	public void add1ProductToCart() throws InterruptedException {
		scrollDown();
		Thread.sleep(3000);
		indexPage.hoverOverProduct1();
		Thread.sleep(3000);
		indexPage.clickAddToCartButton1();
		Thread.sleep(3000);
		indexPage.closePopup();		
		
	}
	@Test (priority = 5)
	public void add1ProductToCartAndIncreaseQuantity() throws InterruptedException {
		scrollDown();
		Thread.sleep(3000);
		indexPage.hoverOverProduct2();
		Thread.sleep(3000);
		indexPage.clickAddToCartButton2();
		Thread.sleep(3000);
		indexPage.clickProceedToCheckoutButton();
		Thread.sleep(3000);
		cartPage.clickPlusButton();
		Thread.sleep(2000);
		cartPage.clickPlusButton();
		Thread.sleep(2000);
		
		int actualQuantity = Integer.valueOf(cartPage.getQuantity().getAttribute("value"));
		int expectedQuantity = Integer.valueOf(excelReader.getData("Cart tests", 17, 6));
		Assert.assertEquals(actualQuantity, expectedQuantity);

	}
	@Test (priority = 10)
	public void removeProductFromCart() throws InterruptedException {
		add1ProductToCart();
		indexPage.clickShoppingCartIcon();
		Thread.sleep(2000);
		cartPage.emptyCart();
		
		Assert.assertTrue(cartPage.getEmptyCartMessage().isDisplayed());
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(1500);
	}
}
