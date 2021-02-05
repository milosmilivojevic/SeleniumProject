package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{
	
	@Test
	public void logIn() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(3000);
	}
}
