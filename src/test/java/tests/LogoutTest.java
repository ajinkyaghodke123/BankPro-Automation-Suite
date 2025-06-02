package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends TestBase {

    @Test
    public void testLogoutFunctionality() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        // Step 2: Logout
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        // Step 3: Verify logout
        Assert.assertTrue(logoutPage.isLoggedOut(), "❌ Logout failed. Username field not visible.");
        System.out.println("✅ Logout successful - redirected to login page.");
    }
}
