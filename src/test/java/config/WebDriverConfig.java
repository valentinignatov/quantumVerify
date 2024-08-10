package config;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class WebDriverConfig {
	private WebDriver driver;

	public WebDriverConfig() {
	}

	public WebDriver getDriver(String browser) {
		if (driver == null) {
			synchronized (WebDriverConfig.class) {
				if (driver == null) {
					switch (browser.toLowerCase()) {
					case "firefox":
						Path firefoxPath = Paths.get("driver", "geckodriver.exe");
                        System.setProperty("webdriver.gecko.driver", firefoxPath.toAbsolutePath().toString());
                        FirefoxOptions options = new FirefoxOptions();
                        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                        
                        // Use the custom profile created earlier
//                        FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\ОК\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\my-custom-profile-test-debug"));
//                        profile.setPreference("browser.startup.homepage", "about:blank");
//                        profile.setPreference("startup.homepage_welcome_url", "about:blank");
//                        profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
                        
                        FirefoxProfile profile = new FirefoxProfile();

                        options.setProfile(profile);
                        
                        driver = new FirefoxDriver(options);
						break;
					case "edge":
						Path edgePath = Paths.get("driver", "msedgedriver.exe");
						System.setProperty("webdriver.edge.driver", edgePath.toAbsolutePath().toString());
						driver = new EdgeDriver();
						break;
					case "chrome":
					default:
						Path chromePath = Paths.get("driver", "chromedriver.exe");
						System.setProperty("webdriver.chrome.driver", chromePath.toAbsolutePath().toString());
						driver = new ChromeDriver();
						break;
					}
				}
			}
		}
		return driver;
	}
}
