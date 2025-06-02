package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Accounts Overview']")
    WebElement header;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logoutLink;

    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHeaderDisplayed() {
        return header.isDisplayed();
    }

    public void logout() {
        logoutLink.click();
    }
}
