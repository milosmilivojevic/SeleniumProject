package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAddressesTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	//@Test (priority = 0)
	private void updateAddress() throws InterruptedException {
		String email = excelReader.getData("Valid credentials", 4, 8);
		String password = excelReader.getData("Valid credentials", 5, 8);
		String firstName = "Michael";
		String lastName = "Jordan";
		String address = "123 Bull Street";
		String city = "Chicago";
		String postalCode = "60007";
		
		signIn(email, password);
		myAccountPage.clickMyAddressesButton();
		Thread.sleep(1500);
		myAddressesPage.clickUpdateButton();
		Thread.sleep(1500);
		addressFormPage.enterFirstName(firstName);
		Thread.sleep(1500);
		addressFormPage.enterLastName(lastName);
		Thread.sleep(1500);
		addressFormPage.enterAddress(address);
		Thread.sleep(1500);
		addressFormPage.enterCity(city);
		Thread.sleep(1500);
		addressFormPage.enterPostalCode(postalCode);
		Thread.sleep(1500);
		addressFormPage.clickSaveButton();
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		//driver.navigate().refresh();
		Thread.sleep(2000);
	}
	public void signIn(String email, String password) throws InterruptedException {
		indexPage.clickSingInButton();
		Thread.sleep(1500);
		loginPage.enterEmail(email);
		Thread.sleep(1500);
		loginPage.enterPassword(password);
		Thread.sleep(1500);
		loginPage.clickSignInButton();
		Thread.sleep(1500);

	}
}
