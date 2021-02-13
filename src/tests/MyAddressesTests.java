package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAddressesTests extends TestBase{
	private String address;
	private String city;
	private String state;
	private String postalCode;
	private int mobilePhoneNumber;
	private String addressTitle;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test (priority = 0)
	public void updateAddress() throws InterruptedException {
		address = excelReader.getData("Address tests", 15, 6);
		city = excelReader.getData("Address tests", 16, 6);
		state = excelReader.getData("Address tests", 17, 6);
		postalCode = excelReader.getData("Address tests", 18, 6);
		mobilePhoneNumber = Integer.valueOf(excelReader.getData("Address tests", 19, 6));
		addressTitle = excelReader.getData("Address tests", 20, 6);

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
	@Test (priority = 5)
	public void addNewAddress() throws InterruptedException {
		address = excelReader.getData("Address tests", 4, 6);
		city = excelReader.getData("Address tests", 5, 6);
		state = excelReader.getData("Address tests", 6, 6);
		postalCode = excelReader.getData("Address tests", 7, 6);
		mobilePhoneNumber = Integer.valueOf(excelReader.getData("Address tests", 8, 6));
		addressTitle = excelReader.getData("Address tests", 9, 6);
		
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
	}
	
	@Test (priority = 10)
	public void deleteAddress() throws InterruptedException {
		signIn();
		Thread.sleep(1500);
		myAccountPage.clickMyAddressesButton();
		Thread.sleep(1500);
		if (myAddressesPage.getDeleteSecondAddressButton().isDisplayed())
		myAddressesPage.deleteSecondAddress();
		Thread.sleep(1500);
		
		Assert.assertTrue(myAddressesPage.numberOfAddresses() == 1);
		
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(1500);
	}

	
	public void fillInAddressForm(String address, String city, String state, String postalCode, int mobilePhoneNumber, String addressTitle) throws InterruptedException {
		addressFormPage.enterAddress(address);
		addressFormPage.enterCity(city);
		addressFormPage.selectState(state);
		addressFormPage.enterPostalCode(postalCode);
		addressFormPage.enterMobilePhoneNumber(mobilePhoneNumber);
		addressFormPage.enterAddressTitle(addressTitle);
	}
	public void revertToOldAddress() throws InterruptedException {
		address = excelReader.getData("Address tests", 4, 7);
		city = excelReader.getData("Address tests", 5, 7);
		state = excelReader.getData("Address tests", 6, 7);
		postalCode = excelReader.getData("Address tests", 7, 7);
		mobilePhoneNumber = Integer.valueOf(excelReader.getData("Address tests", 8, 7));
		addressTitle = excelReader.getData("Address tests", 9, 7);
		
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
