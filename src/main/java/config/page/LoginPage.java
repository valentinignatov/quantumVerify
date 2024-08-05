package config.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

	@FindBy(id = "username")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement loginSubmit;
	
	@FindBy(id = "flash")
	private WebElement successInfo;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String username) {
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmit));
		loginSubmit.click();
	}
	
	public void get() {
		driver.get("https://practice.expandtesting.com/login");
		driver.manage().window().maximize();
	}
	
	public String findSuccesText() {
		return successInfo.getText();
	}

}
