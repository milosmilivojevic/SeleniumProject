package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WishlistTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test (priority = 0)
	public void addWishlist() throws InterruptedException {
		String wishlistName = excelReader.getData("Wishlist tests", 3, 6);
		
		signIn();
		myAccountPage.clickMyWishlistButton();
		Thread.sleep(1500);
		wishlistPage.enterWishlistName(wishlistName);
		Thread.sleep(1500);
		wishlistPage.clickSaveButton();
		
		Assert.assertEquals(wishlistPage.textForAssert(), wishlistName);
		
	}
	@Test (priority = 5)
	public void addMultipleWishlists() throws InterruptedException {
		String wishlistName = excelReader.getData("Wishlist tests", 3, 6);
		int numberOfWishlists = Integer.valueOf(excelReader.getData("Wishlist tests", 8, 6));
		
		signIn();
		myAccountPage.clickMyWishlistButton();
		Thread.sleep(1500);
		
		for (int i = 0; i < numberOfWishlists; i++) {
			wishlistPage.enterWishlistName(wishlistName+i);
			Thread.sleep(1000);
			wishlistPage.clickSaveButton();
			Thread.sleep(1000);
		}
		
		Assert.assertTrue(wishlistPage.numberOfWishlists() == numberOfWishlists + 1);
	}
	@Test (priority = 10)
	public void removeWishlists() throws InterruptedException {
		signIn();
		myAccountPage.clickMyWishlistButton();
		Thread.sleep(1500);
		wishlistPage.removeLists();
		Thread.sleep(5000);
		
		Assert.assertTrue(wishlistPage.numberOfWishlists() == 0);
		
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
