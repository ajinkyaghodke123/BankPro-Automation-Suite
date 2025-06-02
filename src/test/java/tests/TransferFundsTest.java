package tests;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AccountOverviewPage;
import pages.LoginPage;
import pages.TransferPage;

public class TransferFundsTest extends TestBase {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

	}

	@Test
	public void testAccountOverviewHeaderVisible() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("john", "demo");

		AccountOverviewPage overviewPage = new AccountOverviewPage(driver);
		Assert.assertTrue(overviewPage.isHeaderDisplayed(), "Accounts Overview header is not displayed.");
	}

	@Test
	public void testTransferFunds() {
		TransferPage transferPage = new TransferPage(driver);
		transferPage.transferFunds("100");

		Assert.assertTrue(transferPage.isTransferSuccessful(),
				" Transfer was not successful. Please check if the confirmation is visible.");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
