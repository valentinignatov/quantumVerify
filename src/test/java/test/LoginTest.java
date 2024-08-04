package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.BaseChromeConf;
import config.handler.AdHandler;
import config.page.LoginPage;
import config.page.Page;
import config.page.PageFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class LoginTest extends BaseChromeConf {

//	@Test
    public void logIn() {
        Path path = Paths.get("driver",  "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toAbsolutePath().toString());

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        AdHandler adHandler = new AdHandler(driver);

        try {
            driver.get("https://practice.expandtesting.com/login");

            adHandler.closeAdIfPresent();

            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/form/div/div/input[@type='text']")));
            usernameInput.sendKeys("practice");

            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#password")));
            passwordInput.sendKeys("SuperSecretPassword!");

            adHandler.closeAdIfPresent();

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

            adHandler.closeAdIfPresent();
            submitButton.click();
            
            WebElement succesInfo = driver.findElement(By.cssSelector("#flash > b"));
            
            assertEquals(succesInfo.getText(), "You logged into a secure area!");

        } finally {
            driver.quit();
        }
    }
	
	@Test
    public void logIn2() {
		Page loginPage = PageFactory.getPage("login", driver);
		
		loginPage.get("https://practice.expandtesting.com/login");
		adHandler.closeAdIfPresent();
		
        ((LoginPage) loginPage).enterUsername("practice");
        adHandler.closeAdIfPresent();
        
        ((LoginPage) loginPage).enterPassword("SuperSecretPassword!");
        adHandler.closeAdIfPresent();
        
        loginPage.scroll(wait, js, "button[type='submit']");
        
        ((LoginPage) loginPage).clickLogin();
        
        assertEquals(((WebElement) loginPage).getText(), "You logged into a secure area!");
	}

}
