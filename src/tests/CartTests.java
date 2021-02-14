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
		indexPage.hoverOverProduct(indexPage.getProduct1Card());
		Thread.sleep(3000);
		indexPage.clickAddToCartButton(indexPage.getAddToCartButton1());
		Thread.sleep(3000);
		indexPage.clickProceedToCheckoutButton();
		Thread.sleep(3000);
		
		int actualQuantity = Integer.valueOf(cartPage.getQuantity().getAttribute("value"));
		int expectedQuantity = Integer.valueOf(excelReader.getData("Cart tests", 5, 6));
		String actualNumberOfProducts = cartPage.getProductsQuantityLabel().getText();
		String expectedNumberOfProducts = excelReader.getData("Cart tests", 7, 6);
		String actualProductName = cartPage.getProduct1Name().getText();
		String expectedProductName = excelReader.getData("Cart tests", 4, 6);
		Assert.assertEquals(actualQuantity, expectedQuantity);
		Assert.assertEquals(actualNumberOfProducts, expectedNumberOfProducts);
		Assert.assertEquals(actualProductName, expectedProductName);
		
		
	}
	@Test (priority = 5)
	public void add1ProductToCartAndIncreaseQuantity() throws InterruptedException {
		scrollDown();
		Thread.sleep(3000);
		indexPage.hoverOverProduct(indexPage.getProduct2Card());
		Thread.sleep(3000);
		indexPage.clickAddToCartButton(indexPage.getAddToCartButton2());
		Thread.sleep(3000);
		indexPage.clickProceedToCheckoutButton();
		Thread.sleep(3000);
		cartPage.clickPlusButton();
		Thread.sleep(3000);
		cartPage.clickPlusButton();
		Thread.sleep(3000);
		
		int actualQuantity = Integer.valueOf(cartPage.getQuantity().getAttribute("value"));
		int expectedQuantity = Integer.valueOf(excelReader.getData("Cart tests", 17, 6));
		Assert.assertEquals(actualQuantity, expectedQuantity);

	}
	@Test (priority = 10)
	public void addMultipleProductsToCart() throws InterruptedException {
		add1ProductToCart();
		Thread.sleep(3000);
		indexPage.hoverOverProduct(indexPage.getProduct2Card());
		Thread.sleep(3000);
		indexPage.clickAddToCartButton(indexPage.getAddToCartButton2());
		Thread.sleep(3000);
		indexPage.closePopup();	
		indexPage.hoverOverProduct(indexPage.getProduct3Card());
		Thread.sleep(3000);
		indexPage.clickAddToCartButton(indexPage.getAddToCartButton3());
		Thread.sleep(3000);
		indexPage.clickProceedToCheckoutButton();
		Thread.sleep(3000);
		
		String actualText = cartPage.getProductsQuantityLabel().getText();
		String expectedText = excelReader.getData("Cart tests", 31, 6);
		Assert.assertEquals(actualText, expectedText);
		
	}
	@Test (priority = 15)
	public void removeProductFromCart() throws InterruptedException {
		add1ProductToCart();
		indexPage.clickShoppingCartIcon();
		Thread.sleep(3000);
		cartPage.emptyCart();
		Thread.sleep(3000);
		
		Assert.assertTrue(cartPage.getEmptyCartMessage().isDisplayed());
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(1500);
	}
}
