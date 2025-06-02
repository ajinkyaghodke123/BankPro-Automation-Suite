package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import base.TestBase;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends TestBase {

	@Test
	public void testValidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
		assertTrue(driver.getTitle().contains("Accounts Overview"), "Login failed or unexpected title.");
	}

}
