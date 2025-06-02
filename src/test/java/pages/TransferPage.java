package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class TransferPage {
	WebDriver driver;
	WebDriverWait wait;

	public TransferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(linkText = "Transfer Funds")
	WebElement transferFundsLink;

	@FindBy(id = "amount")
	WebElement amountField;

	@FindBy(id = "fromAccountId")
	WebElement fromAccountDropdown;

	@FindBy(id = "toAccountId")
	WebElement toAccountDropdown;

	@FindBy(xpath = "//input[@value='Transfer']")
	WebElement transferButton;

	@FindBy(xpath = "//*[contains(text(),'Transfer Complete')]")
	WebElement transferSuccessHeader;

	public void transferFunds(String amount) {
		// Step 1: Click the link to load the transfer page
		transferFundsLink.click();

		// Step 2: Wait until the URL actually contains "/transfer.htm"
		wait.until(ExpectedConditions.urlContains("transfer.htm"));

		// Step 3: Wait until the amount field is visible on the page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));

		// Step 4: Now it's safe to interact
		amountField.clear();
		amountField.sendKeys(amount);
		transferButton.click();
	}

	public boolean isTransferSuccessful() {
		try {
			wait.until(ExpectedConditions.visibilityOf(transferSuccessHeader));
			return transferSuccessHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
