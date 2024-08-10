package config.handler;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AdHandler {
	private WebDriver driver;

	public AdHandler(WebDriver driver) {
		this.driver = driver;
	}

	public void closeAdIfPresent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			// Trying to find the ad iframe or close button directly
			WebElement adFrame = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe#ad-frame")));
			WebElement closeButton = adFrame.findElement(By.cssSelector("button.close-ad"));
			if (closeButton.isDisplayed()) {
				closeButton.click();
				System.out.println("Ad closed successfully.");
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Ad not present or could not be closed.");
		}
	}
}
