package config.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	protected static WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void scroll(WebDriverWait wait, JavascriptExecutor js, By by) {
		try {
            WebElement element = driver.findElement(by);
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

            // Wait for the element to be in the viewport and clickable
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Additional wait to ensure the scroll has completed
            wait.until((WebDriver d) -> {
                return js.executeScript(
                    "var elem = arguments[0];" +
                    "var box = elem.getBoundingClientRect();" +
                    "return (box.top >= 0 && box.left >= 0 && box.bottom <= " +
                    "(window.innerHeight || document.documentElement.clientHeight) && " +
                    "box.right <= (window.innerWidth || document.documentElement.clientWidth));",
                    element
                ).equals(true);
            });
        } catch (Exception e) {
            System.out.println("Failed to scroll to and stabilize the element: " + e.getMessage());
        }
		
	}

}
