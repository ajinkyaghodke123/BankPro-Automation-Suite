package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenNewAccountPage;
import utils.TestDataStore;

public class OpenNewAccountTest extends TestBase {

    @Test
    public void testOpenNewAccount() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        // Step 2: Open new account
        OpenNewAccountPage newAccountPage = new OpenNewAccountPage(driver);
        newAccountPage.openNewAccount("SAVINGS");
        
        String accountId = newAccountPage.getNewAccountId();
        System.out.println(" New account ID: " + accountId);

        // Store dynamically for later use
        TestDataStore.set("accountId", accountId);

        Assert.assertTrue(newAccountPage.isAccountOpened(), "Account creation failed.");


        // Step 3: Validate
        Assert.assertTrue(newAccountPage.isAccountOpened(), "❌ Account creation failed.");
        System.out.println(" New account opened with ID: " + newAccountPage.getNewAccountId());
    }
}
