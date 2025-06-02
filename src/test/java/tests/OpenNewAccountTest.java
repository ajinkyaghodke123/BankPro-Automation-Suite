package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenNewAccountPage;

public class OpenNewAccountTest extends TestBase {

    @Test
    public void testOpenNewAccount() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        // Step 2: Open new account
        OpenNewAccountPage newAccountPage = new OpenNewAccountPage(driver);
        newAccountPage.openNewAccount("SAVINGS");

        // Step 3: Validate
        Assert.assertTrue(newAccountPage.isAccountOpened(), "❌ Account creation failed.");
        System.out.println("✅ New account opened with ID: " + newAccountPage.getNewAccountId());
    }
}
