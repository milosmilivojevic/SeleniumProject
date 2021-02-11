package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	//@Test (priority = 0)
	public void addWishlist() throws InterruptedException {
		String wishlistName = excelReader.getData("Wishlist tests", 3, 6);
		
		signIn();
		myAccountPage.clickMyWishlistButton();
		Thread.sleep(1500);
		wishlistPage.enterWishlistName(wishlistName);
		Thread.sleep(1500);
		wishlistPage.clickSaveButton();
		
		//Assert.assertEquals(wishlistPage.textForAssert(), wishlistName);
		wishlistPage.removeLists();
	}
	@Test (priority = 1)
	public void addMultipleWishlists() throws InterruptedException {
		String wishlistName = excelReader.getData("Wishlist tests", 3, 6);
		int numberOfWishlists = 3;
		
		signIn();
		myAccountPage.clickMyWishlistButton();
		Thread.sleep(1500);
		
		for (int i = 0; i < numberOfWishlists; i++) {
			wishlistPage.enterWishlistName(wishlistName+i);
			wishlistPage.clickSaveButton();
		}
		
		wishlistPage.enterWishlistName(wishlistName);
		wishlistPage.clickSaveButton();
		
		//Assert.assertEquals(, );
		wishlistPage.removeLists();
	}
	//@Test (priority = 2)
	public void removeWishlists() throws InterruptedException {
		String wishlistName = "lista1";      // excelReader.getData("add wishlist", 5, 8);
		
		addWishlist();
		wishlistPage.enterWishlistName(wishlistName);
		wishlistPage.clickSaveButton();
		wishlistPage.removeLists();
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
