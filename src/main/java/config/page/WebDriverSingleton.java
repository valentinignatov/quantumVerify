package config.page;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
	private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (WebDriverSingleton.class) {
                if (driver == null) {
                	Path path = Paths.get("driver", "chromedriver-win64", "chromedriver.exe");
                	System.setProperty("webdriver.chrome.driver", path.toAbsolutePath().toString());
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }
}
