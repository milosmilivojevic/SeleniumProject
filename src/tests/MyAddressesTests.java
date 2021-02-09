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
	/*
	//@Test (priority = 0)
	public void updateAddress() throws InterruptedException {
		
		signIn(email, password);
		myAccountPage.clickMyAddressesButton();
		Thread.sleep(1500);
		myAddressesPage.clickUpdateButton();
		Thread.sleep(1500);
		addressFormPage.enterFirstName(firstName);
		addressFormPage.enterLastName(lastName);
		addressFormPage.enterAddress(address);
		addressFormPage.enterCity(city);
		addressFormPage.enterPostalCode(postalCode);
		Thread.sleep(1500);
		addressFormPage.clickSaveButton();
	}
	*/
	@Test (priority = 1)
	public void AddNewAddress() throws InterruptedException {
		String email = excelReader.getData("Valid credentials", 4, 8);
		String password = excelReader.getData("Valid credentials", 5, 8);
		String firstName = excelReader.getData("Add address", 5, 8);
		String lastName = excelReader.getData("Add address", 6, 8);
		String address = excelReader.getData("Add address", 7, 8);
		String city = excelReader.getData("Add address", 8, 8);
		String state = excelReader.getData("Add address", 9, 8);
		String postalCode = excelReader.getData("Add address", 10, 8);
		int mobilePhoneNumber = Integer.valueOf(excelReader.getData("Add address", 11, 8));
		String addressTitle = excelReader.getData("Add address", 12, 8);
		
		signIn(email, password);
		myAccountPage.clickMyAddressesButton();
		Thread.sleep(1500);
		myAddressesPage.clickAddANewAddressButton();
		Thread.sleep(1500);
		addressFormPage.enterFirstName(firstName);
		addressFormPage.enterLastName(lastName);
		addressFormPage.enterAddress(address);
		addressFormPage.enterCity(city);
		addressFormPage.selectState(state);
		addressFormPage.enterPostalCode(postalCode);
		addressFormPage.enterMobilePhoneNumber(mobilePhoneNumber);
		addressFormPage.enterAddressTitle(addressTitle);
		Thread.sleep(4500);
		//addressFormPage.clickSaveButton();
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		//driver.navigate().refresh();
		Thread.sleep(2000);
	}

	/*
	public void fillAddressForm() {
		addressFormPage.enterFirstName(firstName);
		addressFormPage.enterLastName(lastName);
		addressFormPage.enterAddress(address);
		addressFormPage.enterCity(city);
		Thread.sleep(1500);
		//addressFormPage.selectState(state);
		Thread.sleep(1500);
		addressFormPage.enterPostalCode(postalCode);
		Thread.sleep(1500);
		addressFormPage.enterMobilePhoneNumber(mobilePhoneNumber);
		addressFormPage.enterAddressTitle(addressTitle);
		Thread.sleep(4500);
		//addressFormPage.clickSaveButton();
	}
	*/
}
