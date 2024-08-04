package config.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Page {
	public void get(String url);
	
	public default void scroll(WebDriverWait wait, JavascriptExecutor js, String component) {
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(component)));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
	}
	
	public String findText();
}
