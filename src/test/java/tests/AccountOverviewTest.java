package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import base.TestBase;
import pages.AccountOverviewPage;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountOverviewTest extends TestBase {
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

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
