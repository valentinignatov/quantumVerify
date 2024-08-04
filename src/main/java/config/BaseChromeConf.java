package config;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.handler.AdHandler;
import config.page.WebDriverConfig;


public class BaseChromeConf {

	protected static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected static JavascriptExecutor js = null;
	protected static AdHandler adHandler = null;

	@BeforeAll
	public static void initConfig() {
		driver = WebDriverConfig.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		adHandler = new AdHandler(driver);
	}

	@AfterEach
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterAll
	public static void quitDriver() {
		driver.close();
	}
}
