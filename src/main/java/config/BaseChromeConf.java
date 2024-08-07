package config;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import config.handler.AdHandler;


public class BaseChromeConf {

	protected static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected static JavascriptExecutor js = null;
	protected static AdHandler adHandler = null;

	@BeforeTest
	public static void initConfig() {
		driver = WebDriverConfig.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		adHandler = new AdHandler(driver);
	}

	@AfterTest
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public static void quitDriver() {
		driver.close();
	}
}
