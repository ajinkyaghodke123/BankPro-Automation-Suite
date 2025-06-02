package tests.APITests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import pages.LoginPage;
import utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FundsTransferAPITest extends TestBase {
    
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);  // driver inherited from TestBase
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        assertTrue(driver.getTitle().contains("Accounts Overview"), "Login failed or unexpected title.");
    }


}
