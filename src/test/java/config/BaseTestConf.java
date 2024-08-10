package config;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import config.handler.AdHandler;

public class BaseTestConf {

	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	protected JavascriptExecutor js = null;
	protected AdHandler adHandler = null;

	@BeforeTest
	@Parameters("browser")
	public void initConfig(@Optional("firefox")String browser) {
		driver = new WebDriverConfig().getDriver(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		adHandler = new AdHandler(driver);
	}

	@AfterTest
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void quitDriver() {
		driver.close();
	}
}
