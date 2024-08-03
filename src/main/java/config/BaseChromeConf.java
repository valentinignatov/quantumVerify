package config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.handler.AdHandler;
import config.page.LoginPage;
import config.page.WebDriverSingleton;

public class BaseChromeConf {

	protected static WebDriver driver = null;
	private static String browserName = "chrome";
	private static LoginPage loginPage;
	protected WebDriverWait wait = null;
	protected JavascriptExecutor js = null;
	protected AdHandler adHandler = null;

	@Before
	public void initConfig() {
		driver = WebDriverSingleton.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		adHandler = new AdHandler(driver);
	}

	@After
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void quitDriver() {
		driver.close();
	}
}
