package config.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage implements Page {
	private static WebDriver driver;

	@FindBy(id = "username")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement loginSubmit;
	
	@FindBy(id = "flash")
	private WebElement successInfo;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
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
		loginSubmit.click();
	}

	@Override
	public void get(String url) {
		driver.get(url);
	}

	@Override
	public String findText() {
		return successInfo.getText();
	}

}
