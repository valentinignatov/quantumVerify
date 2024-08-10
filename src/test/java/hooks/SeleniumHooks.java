package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.WebDriverConfig;
import config.handler.AdHandler;

public class SeleniumHooks {

	private static WebDriver driver;
	private static WebDriverWait wait = null;
	private static JavascriptExecutor js = null;
	private static AdHandler adHandler = null;

    @Before
    public void setUp() {
        driver = new WebDriverConfig().getDriver("chrome");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		adHandler = new AdHandler(driver);
    }

    public static WebDriverWait getWait() {
		return wait;
	}

	public static JavascriptExecutor getJs() {
		return js;
	}

	public static AdHandler getAdHandler() {
		return adHandler;
	}

	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}