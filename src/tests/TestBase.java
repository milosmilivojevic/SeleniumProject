package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddressFormPage;
import pages.CartPage;
import pages.IndexPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.PersonalInfoPage;
import pages.WishlistPage;

public class TestBase {
	
	WebDriver driver;
	
	//Pages
	
	IndexPage indexPage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	AddressFormPage addressFormPage;
	WishlistPage wishlistPage;
	PersonalInfoPage personalInfoPage;
	CartPage cartPage;
	ExcelReader excelReader;


	@BeforeClass
	public void beforeClass() throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.indexPage = new IndexPage(driver);
		this.loginPage = new LoginPage (driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressesPage = new MyAddressesPage(driver);
		this.addressFormPage = new AddressFormPage(driver);
		this.wishlistPage = new WishlistPage(driver);
		this.personalInfoPage = new PersonalInfoPage(driver);
		this.cartPage = new CartPage(driver);
		this.excelReader = new ExcelReader("data\\testPlan.xlsx");
		
		driver.manage().window().maximize();
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	
	public void signIn() throws InterruptedException {
		indexPage.clickSignInButton();
		loginPage.enterEmail(excelReader.getData("Login tests", 5, 6));
		loginPage.enterPassword(excelReader.getData("Login tests", 6, 6));
		loginPage.clickSignInButton();
	}
	public void signIn(String email, String password) throws InterruptedException {
		indexPage.clickSignInButton();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSignInButton();
	}
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
	}
}


