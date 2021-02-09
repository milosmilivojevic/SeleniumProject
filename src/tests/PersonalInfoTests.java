package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoTests extends TestBase {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void editPersonalInfo() throws InterruptedException {
		String email = excelReader.getData("Valid credentials", 4, 8);
		String password = excelReader.getData("Valid credentials", 5, 8);
		String firstName = ""; // excelReader.getData("Edit personal info", 4, 8);
		String lastName = "";
		String emailAddress = "";
		String currentPassword = "";

		signIn(email, password);
		Thread.sleep(1000);
		myAccountPage.clickMyPersonalInformationButton();
		Thread.sleep(1000);
		personalInfoPage.clickMrRadioButton();
		personalInfoPage.enterFirstName(firstName);
		personalInfoPage.enterLastName(lastName);
		personalInfoPage.enterEmail(emailAddress);
		personalInfoPage.enterCurrentPassword(currentPassword);
		personalInfoPage.clickSaveButton();
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		// driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
