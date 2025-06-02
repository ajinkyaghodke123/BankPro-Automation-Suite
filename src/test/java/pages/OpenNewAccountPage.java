package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class OpenNewAccountPage {
    WebDriver driver;
    WebDriverWait wait;

    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(linkText = "Open New Account")
    WebElement openNewAccountLink;

    @FindBy(id = "type")
    WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    WebElement openAccountButton;

    @FindBy(id = "newAccountId")
    WebElement newAccountId;

    public void openNewAccount(String accountType) {
        openNewAccountLink.click();
        wait.until(ExpectedConditions.visibilityOf(accountTypeDropdown));

        new Select(accountTypeDropdown).selectByVisibleText(accountType);
        new Select(fromAccountDropdown).selectByIndex(0); // Select first account

        openAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(newAccountId));
    }

    public boolean isAccountOpened() {
        try {
            return newAccountId.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getNewAccountId() {
        return newAccountId.getText();
    }
}
