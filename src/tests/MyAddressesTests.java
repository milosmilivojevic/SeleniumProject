package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAddressesTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test 
	public void updateAddress() throws InterruptedException {
		String address = excelReader.getData("Add address", 7, 8);
		String city = excelReader.getData("Add address", 8, 8);
		String state = excelReader.getData("Add address", 9, 8);
		String postalCode = excelReader.getData("Add address", 10, 8);
		int mobilePhoneNumber = Integer.valueOf(excelReader.getData("Add address", 11, 8));
		String addressTitle = excelReader.getData("Add address", 12, 8);

		signIn();
		Thread.sleep(1500);
		myAccountPage.clickMyAddressesButton();
		Thread.sleep(1500);
		myAddressesPage.clickUpdateButton();
		Thread.sleep(1500);
		fillInAddressForm(address, city, state, postalCode, mobilePhoneNumber, addressTitle);
		addressFormPage.clickSaveButton();
		Thread.sleep(1500);
		
		String actualText = myAddressesPage.getAddressLabel().getText().toUpperCase();
		String expectedText = addressTitle.toUpperCase();
		Assert.assertEquals(actualText, expectedText);
		
		myAddressesPage.clickUpdateButton();
		Thread.sleep(1500);
		if(addressFormPage.getAddressInputField().getAttribute("value") != excelReader.getData("Address tests", 4, 7)) 
			revertToOldAddress();
		
	}
	@Test 
	public void addNewAddress() throws InterruptedException {
		String address = excelReader.getData("Address tests", 4, 6);
		String city = excelReader.getData("Address tests", 5, 6);
		String state = excelReader.getData("Address tests", 6, 6);
		String postalCode = excelReader.getData("Address tests", 7, 6);
		int mobilePhoneNumber = Integer.valueOf(excelReader.getData("Address tests", 8, 6));
		String addressTitle = excelReader.getData("Address tests", 9, 6);
		
		signIn();
		myAccountPage.clickMyAddressesButton();
		Thread.sleep(1500);
		myAddressesPage.clickAddANewAddressButton();
		Thread.sleep(1500);
		fillInAddressForm(address, city, state, postalCode, mobilePhoneNumber, addressTitle);
		addressFormPage.clickSaveButton();
		
		String actualText = myAddressesPage.getSecondAddressLabel().getText().toUpperCase();
		String expectedText = addressTitle.toUpperCase();
		Assert.assertEquals(actualText, expectedText);
		
		myAddressesPage.deleteSecondAddress();
	}
	
	//@Test (priority = 2)
	public void deleteAddress() throws InterruptedException {
		signIn();
		Thread.sleep(1500);
		myAccountPage.clickMyAddressesButton();
		Thread.sleep(1500);
		if (myAddressesPage.getDeleteButton().isDisplayed()) 
			myAddressesPage.deleteAddress();
		Thread.sleep(1500);
		myAddressesPage.clickAddANewAddressButton();
		//fillInAddressForm(address, city, state, postalCode, mobilePhoneNumber, addressTitle);
		
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		//driver.navigate().refresh();
		Thread.sleep(2000);
	}

	
	public void fillInAddressForm(String address, String city, String state, String postalCode, int mobilePhoneNumber, String addressTitle) throws InterruptedException {
		//addressFormPage.enterFirstName(firstName);
		//addressFormPage.enterLastName(lastName);
		addressFormPage.enterAddress(address);
		addressFormPage.enterCity(city);
		addressFormPage.selectState(state);
		addressFormPage.enterPostalCode(postalCode);
		addressFormPage.enterMobilePhoneNumber(mobilePhoneNumber);
		addressFormPage.enterAddressTitle(addressTitle);
		//Thread.sleep(2500);
		//addressFormPage.clickSaveButton();
	}
	public void revertToOldAddress() throws InterruptedException {
		String address = excelReader.getData("Address tests", 4, 7);
		String city = excelReader.getData("Address tests", 5, 7);
		String state = excelReader.getData("Address tests", 6, 7);
		String postalCode = excelReader.getData("Address tests", 7, 7);
		int mobilePhoneNumber = Integer.valueOf(excelReader.getData("Address tests", 8, 7));
		String addressTitle = excelReader.getData("Address tests", 9, 7);
		
		addressFormPage.enterAddress(address);
		addressFormPage.enterCity(city);
		addressFormPage.selectState(state);
		addressFormPage.enterPostalCode(postalCode);
		addressFormPage.enterMobilePhoneNumber(mobilePhoneNumber);
		addressFormPage.enterAddressTitle(addressTitle);
		Thread.sleep(1500);
		addressFormPage.clickSaveButton();
		
	}
	
}
