package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test (priority = 0)
	public void loginWithValidCredentials() throws InterruptedException {
		String email = excelReader.getData("Valid credentials", 4, 8);
		String password = excelReader.getData("Valid credentials", 5, 8);
		
		signIn(email, password);
		
		Assert.assertEquals(true, myAccountPage.getSignOutButton().isDisplayed());
	}
	@Test (priority = 1)
	public void loginWithInvalidCredentials() throws InterruptedException {
		String email = excelReader.getData("Invalid credentials", 4, 8);
		String password = excelReader.getData("Invalid credentials", 5, 8);
		
		signIn(email, password);
		
		Assert.assertEquals(true, loginPage.getSignInButton().isDisplayed());
	}
	@Test (priority = 2)
	public void loginWithEmptyCredentials() throws InterruptedException {
		String email = excelReader.getData("Empty credentials", 4, 8);
		String password = excelReader.getData("Empty credentials", 5, 8);
		
		signIn(email, password);
		
		Assert.assertEquals(true, loginPage.getSignInButton().isDisplayed());
	}
	@Test (priority = 3)
	public void logout() throws InterruptedException {
		loginWithValidCredentials();
		Thread.sleep(1500);
		myAccountPage.clickSignOutButton();
		
		Assert.assertEquals(true, loginPage.getSignInButton().isDisplayed());
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		//driver.navigate().refresh();
		Thread.sleep(2000);
	}
	

}
