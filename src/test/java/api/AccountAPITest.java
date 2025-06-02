package api;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataStore;

public class AccountAPITest {

    @Test
    public void testGetAccountDetails() {
        // Get account ID from TestDataStore
        String accountId = TestDataStore.get("accountId");
        Assert.assertNotNull(accountId, "❌ Account ID not found in shared store.");

        // Call API
        RestAssured.baseURI = "https://parabank.parasoft.com/parabank";
        Response response = RestAssured
            .given()
            .get("/services/bank/accounts/" + accountId)
            .then()
            .extract().response();

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Raw XML: \n" + response.asString());

        XmlPath xml = new XmlPath(response.asString());
        String balance = xml.getString("account.balance");

        // Validate
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(balance, "❌ Balance not found.");
    }
}
