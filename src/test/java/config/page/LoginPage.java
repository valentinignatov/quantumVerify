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

	public void scroll(WebDriverWait wait, JavascriptExecutor js) {
		try {
			WebElement element = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

			// Wait for the element to be in the viewport and clickable
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			// Additional wait to ensure the scroll has completed
			wait.until((WebDriver d) -> {
				return js
						.executeScript(
								"var elem = arguments[0];" + "var box = elem.getBoundingClientRect();"
										+ "return (box.top >= 0 && box.left >= 0 && box.bottom <= "
										+ "(window.innerHeight || document.documentElement.clientHeight) && "
										+ "box.right <= (window.innerWidth || document.documentElement.clientWidth));",
								element)
						.equals(true);
			});
		} catch (Exception e) {
			System.out.println("Failed to scroll to and stabilize the element: " + e.getMessage());
		}
	}

}
