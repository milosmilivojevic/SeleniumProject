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
	@Test 
	public void loginWithValidCredentials() throws InterruptedException {

		signIn();
		
		Assert.assertEquals(true, myAccountPage.getSignOutButton().isDisplayed());
	}
	@Test 
	public void loginWithInvalidPassword() throws InterruptedException {
		String email = excelReader.getData("Login tests", 13, 6);
		String password = excelReader.getData("Login tests", 14, 6);
		
		signIn(email, password);
		
		Assert.assertEquals(true, loginPage.getSignInButton().isDisplayed());
	}
	@Test 
	public void loginWithInvalidEmail() throws InterruptedException {
		String email = excelReader.getData("Login tests", 21, 6);
		String password = excelReader.getData("Login tests", 22, 6);
		
		signIn(email, password);
		
		Assert.assertEquals(true, loginPage.getSignInButton().isDisplayed());
	}
	@Test 
	public void loginWithInvalidCredentials() throws InterruptedException {
		String email = excelReader.getData("Login tests", 29, 6);
		String password = excelReader.getData("Login tests", 30, 6);
		
		signIn(email, password);
		
		Assert.assertEquals(true, loginPage.getSignInButton().isDisplayed());
	}
	@Test 
	public void loginWithEmptyCredentials() throws InterruptedException {
		String email = "";
		String password = "";
		
		signIn(email, password);
		
		Assert.assertEquals(true, loginPage.getSignInButton().isDisplayed());
	}
	@Test 
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
