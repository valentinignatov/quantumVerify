package config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {
	private static WebDriver driver;

    private WebDriverConfig() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (WebDriverConfig.class) {
                if (driver == null) {
                	Path path = Paths.get("driver", "chromedriver.exe");
                	System.setProperty("webdriver.chrome.driver", path.toAbsolutePath().toString());
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }
}
