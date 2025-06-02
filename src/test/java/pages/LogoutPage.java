package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(linkText = "Log Out")
    WebElement logoutLink;

    @FindBy(name = "username")
    WebElement usernameField;

    public void logout() {
        logoutLink.click();
        wait.until(ExpectedConditions.visibilityOf(usernameField));
    }

    public boolean isLoggedOut() {
        return usernameField.isDisplayed();
    }
}
