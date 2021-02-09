package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddressFormPage;
import pages.IndexPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.PersonalInfoPage;
import pages.WishlistPage;

public class TestBase {
	WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	AddressFormPage addressFormPage;
	WishlistPage wishlistPage;
	PersonalInfoPage personalInfoPage;
	ExcelReader excelReader;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.indexPage = new IndexPage(driver);
		this.loginPage = new LoginPage (driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressesPage = new MyAddressesPage(driver);
		this.addressFormPage = new AddressFormPage(driver);
		this.wishlistPage = new WishlistPage(driver);
		this.personalInfoPage = new PersonalInfoPage(driver);
		this.excelReader = new ExcelReader("data\\testPlan.xlsx");
		
		driver.manage().window().maximize();
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}

