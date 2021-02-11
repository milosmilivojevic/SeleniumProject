package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoTests extends TestBase {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test
	public void editPersonalInfo() throws InterruptedException {
		
		String firstName = excelReader.getData("Personal info tests", 4, 6);
		String lastName = excelReader.getData("Personal info tests", 5, 6);
		String email = excelReader.getData("Personal info tests", 6, 6);
		String currentPassword = excelReader.getData("Personal info tests", 7, 6);

		signIn();
		Thread.sleep(1000);
		myAccountPage.clickMyPersonalInformationButton();
		Thread.sleep(1000);
		personalInfoPage.enterFirstName(firstName);
		personalInfoPage.enterLastName(lastName);
		personalInfoPage.enterEmail(email);
		personalInfoPage.enterCurrentPassword(currentPassword);
		Thread.sleep(1000);
		personalInfoPage.clickSaveButton();
		
		Assert.assertTrue(personalInfoPage.getConfirmationMessage().isDisplayed());
		
		revertToOldPersonalInfo();
		
		Assert.assertTrue(personalInfoPage.getConfirmationMessage().isDisplayed());
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		// driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void revertToOldPersonalInfo() throws InterruptedException {
		String firstName = excelReader.getData("Personal info tests", 4, 7);
		String lastName = excelReader.getData("Personal info tests", 5, 7);
		String email = excelReader.getData("Personal info tests", 6, 7);
		String currentPassword = excelReader.getData("Personal info tests", 7, 7);
		
		personalInfoPage.clickBackToAccountButton();
		Thread.sleep(1000);
		myAccountPage.clickMyPersonalInformationButton();
		Thread.sleep(1000);
		personalInfoPage.enterFirstName(firstName);
		personalInfoPage.enterLastName(lastName);
		personalInfoPage.enterEmail(email);
		personalInfoPage.enterCurrentPassword(currentPassword);
		Thread.sleep(1000);
		personalInfoPage.clickSaveButton();
}
}